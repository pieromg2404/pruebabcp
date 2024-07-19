package com.example.pruebabcp.analytics

class MetaAnalyticsService : AnalyticsService {
    override fun trackEvent(screen: String, values: Map<String, String>) {
        println("Meta Analytics - Track Event: $screen, Values: $values")
    }
}
