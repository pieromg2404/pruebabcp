package com.example.pruebabcp.analytics.module

import com.example.pruebabcp.analytics.AnalyticsManager
import com.example.pruebabcp.analytics.FirebaseAnalyticsService
import com.example.pruebabcp.analytics.GoogleAnalyticsService
import com.example.pruebabcp.analytics.MetaAnalyticsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {

    @Provides
    @Singleton
    fun provideFirebaseAnalyticsService(): FirebaseAnalyticsService {
        return FirebaseAnalyticsService()
    }

    @Provides
    @Singleton
    fun provideGoogleAnalyticsService(): GoogleAnalyticsService {
        return GoogleAnalyticsService()
    }

    @Provides
    @Singleton
    fun provideMetaAnalyticsService(): MetaAnalyticsService {
        return MetaAnalyticsService()
    }

    @Provides
    @Singleton
    fun provideAnalyticsManager(
        firebaseAnalyticsService: FirebaseAnalyticsService,
        googleAnalyticsService: GoogleAnalyticsService,
        metaAnalyticsService: MetaAnalyticsService
    ): AnalyticsManager {
        return AnalyticsManager(
            firebaseAnalyticsService,
            googleAnalyticsService,
            metaAnalyticsService
        )
    }
}
