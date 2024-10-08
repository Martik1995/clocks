import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel<DataState>  : ViewModel() {

    private val _state: MutableState<ScreenState<DataState>> = mutableStateOf(ScreenState.Loading)
    val state: State<ScreenState<DataState>> = _state

    private var currentJob: Job? = null

    fun onUIEvent(event: UIEvent) {
        reduce(event)
    }

    protected abstract fun createDefaultDataState(): DataState

    protected fun isLoading(): Boolean = _state.value is ScreenState.Loading

    protected open fun reduce(event: UIEvent) {
        // Handle UI events
    }

    protected fun updateData(work: (currentData: DataState) -> DataState) {
        val currentData = (state.value as? ScreenState.Data)?.data ?: createDefaultDataState()
        val newState = ScreenState.Data(work(currentData))
        _state.value = newState
    }

    protected fun updateStateData(data: DataState) {
        _state.value = ScreenState.Data(data)
    }

    protected fun <WorkResult> createRequest(
        request: suspend CoroutineScope.(currentData: DataState) -> WorkResult
    ): ViewModelRequest<DataState, WorkResult> {
        return ViewModelRequest(this, request)
    }

    protected fun <WorkResult> launchRequest(
        work: suspend CoroutineScope.(currentData: DataState) -> WorkResult,
        onLoading: () -> Unit,
        onData: (result: WorkResult, data: DataState) -> Unit,
        onError: (reason: Throwable) -> Unit
    ): Job {
        currentJob?.cancel()
        return viewModelScope.launch {
            onLoading()
            try {
                val result = work(state.value.getData() ?: createDefaultDataState())
                onData(result, state.value.getData() ?: createDefaultDataState())
            } catch (e: Throwable) {
                onError(e)
            }
        }.also { currentJob = it }
    }

    protected fun onErrorDefaultReaction(reason: Throwable) {
        _state.value = ScreenState.Error(reason)
    }

    sealed class UIEvent

    sealed class ScreenState<out T> {
        data object Loading : ScreenState<Nothing>()
        data class Data<out T>(val data: T) : ScreenState<T>()
        data class Error(val reason: Throwable) : ScreenState<Nothing>()

        fun getData(): T? = (this as? Data<T>)?.data
    }

    protected class ViewModelRequest<DataState, WorkResult>(
        private val viewModel: BaseViewModel<DataState>,
        private val work: suspend CoroutineScope.(currentData: DataState) -> WorkResult
    ) {
        fun launch(
            onLoading: () -> Unit,
            onData: (result: WorkResult) -> Unit,
            onError: (reason: Throwable) -> Unit
        ): Job {
            return viewModel.launchRequest(work, onLoading, { result, data -> onData(result) }, onError)
        }
    }
}
