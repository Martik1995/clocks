package com.mmg.clocks.presentation.base

sealed class BaseScreenState<DataState: BaseDataState> {
    abstract fun getScreenData(): DataState?

    data class Loading<DataState: BaseDataState>(
        val data: DataState? = null
    ): BaseScreenState<DataState>() {
        override fun getScreenData(): DataState? = data
    }

    data class Error<DataState: BaseDataState>(
        val prevData: DataState? = null,
        val reason: Throwable? = null,
        val retryAction: () -> Unit
    ): BaseScreenState<DataState>() {
        override fun getScreenData(): DataState? = prevData
    }

    data class Data<DataState: BaseDataState>(
        val data: DataState
    ): BaseScreenState<DataState>() {
        override fun getScreenData(): DataState = data
    }
}
