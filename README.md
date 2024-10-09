Гайд по приложению "Clocks"

Описание приложения:
Приложение состоит из двух страниц. Первая страница отображает текущее время выбранного города, а вторая страница позволяет выбрать город. Время синхронизируется с помощью запроса на сервис timeapi.io. В приложении реализована чистая архитектура и паттерн MVI (Model-View-Intent) для управления состоянием и реакцией на события.

Технологический стек:
Plugins:

android.application: плагин для сборки Android-приложений.
kotlin.android: добавляет поддержку языка Kotlin.
kotlin.serialization: используется для сериализации данных, что упрощает работу с JSON при сетевых запросах.
Android конфигурация:

compileSdk = 34: версия SDK, используемая для компиляции.
minSdk = 24: минимальная поддерживаемая версия Android (7.0 Nougat).
targetSdk = 34: целевая версия Android, на которую ориентируется приложение.
versionCode = 1 и versionName = "1.0.0": версии приложения.
Build Types:

release: настройки для сборки релизной версии, с возможностью минимизации кода через ProGuard.
Compose и Kotlin настройки:

compose = true: включает Jetpack Compose для создания декларативного пользовательского интерфейса.
kotlinCompilerExtensionVersion = "1.5.1": версия компилятора Kotlin для поддержки Compose.
Зависимости:
Core:

core.ktx: упрощенные расширения для работы с Android API.
lifecycle.runtime.ktx: управление жизненным циклом компонентов.
UI:

ui, ui.graphics, material3: библиотеки для создания пользовательских интерфейсов на основе Jetpack Compose и Material Design 3.
ui.tooling.preview: поддержка предпросмотра интерфейсов в Android Studio.
activity.compose: интеграция Activity с Compose.
Network & Serialization:

retrofit: для выполнения HTTP-запросов к API.
okhttp3: HTTP-клиент для сетевых запросов.
serialization.json: сериализация данных в формате JSON с использованием Kotlin Serialization.
serialization.converter: конвертер для работы с Retrofit и сериализацией.
logging.interceptor: для логирования сетевых запросов и ответов.
Dependency Injection (DI):

koin.android, koin.core, koin.androidx.compose: внедрение зависимостей через Koin для Android и Compose.
Navigation:

navigation.fragment, navigation.ui, navigation.compose: библиотеки для навигации между экранами с помощью Jetpack Navigation.
Tests:

junit: для модульного тестирования.
androidx.test.junit, espresso.core: для инструментальных тестов на Android.
ui.test.junit4: для тестирования пользовательского интерфейса в Jetpack Compose.
Debug:

ui.tooling, ui.test.manifest: инструменты для отладки и тестирования UI.
Версии:
compileSdk: 34
minSdk: 24
targetSdk: 34
versionCode: 1
versionName: 1.0.0
Данный стек технологий и библиотек позволяет приложению эффективно управлять состоянием, выполнять сетевые запросы, и организовывать навигацию и синхронизацию данных через API, сохраняя гибкость архитектуры и модульность.
