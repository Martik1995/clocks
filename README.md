Гайд по приложению "Clocks"
Описание приложения:
Приложение состоит из двух экранов. Первый экран показывает текущее время выбранного города, второй — позволяет выбрать город из списка. Время синхронизируется через API-сервис timeapi.io.

Приложение построено на принципах чистой архитектуры и использует паттерн MVI (Model-View-Intent) для управления состоянием и обработки пользовательских действий.

Стек технологий

Язык: Kotlin

Пользовательский интерфейс (UI): Jetpack Compose — для декларативного создания интерфейсов.

Работа с сетью: Retrofit — для HTTP-запросов, OkHttp3 — для сетевых операций.

Сериализация: Kotlin Serialization — для обработки JSON-данных.

Внедрение зависимостей (DI): Koin — для управления зависимостями.

Навигация: Jetpack Navigation — для переходов между экранами.

Конфигурация приложения

compileSdk = 34 — версия Android SDK для компиляции

minSdk = 24 — минимальная версия Android 7.0.

targetSdk = 34 — целевая версия Android.

Это приложение с минимальным и современным стеком технологий для работы с сетевыми данными, навигацией и архитектурой, что делает его простым в поддержке и масштабировании.
