package com.hellofresh.task2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import xyz.zohre.presentation.AppNavigator

@InstallIn(ActivityComponent::class)
@Module
class ActivityModule {
    @Provides
    fun provideAppNavigator(helloFreshAppNavigator: HelloFreshAppNavigator): AppNavigator {
        return helloFreshAppNavigator
    }


}