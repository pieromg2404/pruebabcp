package com.example.pruebabcp.analytics

interface AnalyticsService {
    fun trackEvent(screen: String, values: Map<String, String>)
}

