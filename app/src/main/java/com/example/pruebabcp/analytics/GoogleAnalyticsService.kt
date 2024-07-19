package com.example.pruebabcp.analytics

class GoogleAnalyticsService : AnalyticsService {
    override fun trackEvent(screen: String, values: Map<String, String>) {
        println("Google Analytics - Track Event: $screen, Values: $values")
    }
}