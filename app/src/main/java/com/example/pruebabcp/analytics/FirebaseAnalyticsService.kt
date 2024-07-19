package com.example.pruebabcp.analytics

class FirebaseAnalyticsService : AnalyticsService {
    override fun trackEvent(screen: String, values: Map<String, String>) {
        println("Firebase Analytics - Track Event: $screen, Values: $values")
    }
}