package com.example.pruebabcp.analytics

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnalyticsManager @Inject constructor(
    private val firebaseAnalyticsService: FirebaseAnalyticsService,
    private val googleAnalyticsService: GoogleAnalyticsService,
    private val metaAnalyticsService: MetaAnalyticsService
) : ViewModel() {

    fun trackEvent(screen: String, action: Map<String, String>) {
        firebaseAnalyticsService.trackEvent(screen, action)
        googleAnalyticsService.trackEvent(screen, action)
        metaAnalyticsService.trackEvent(screen, action)
    }
}
