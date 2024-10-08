package com.mmg.clocks.shared.network

sealed class DomainError(val originalException: Throwable) : Throwable() {
    class Unknown(originalException: Throwable) : DomainError(originalException)
    class Network(originalException: Throwable) : DomainError(originalException)
    class Timeout(originalException: Throwable) : DomainError(originalException)
}