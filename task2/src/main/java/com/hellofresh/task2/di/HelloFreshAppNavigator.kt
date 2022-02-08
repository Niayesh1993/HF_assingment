package com.hellofresh.task2.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.hellofresh.task2.R
import dagger.hilt.android.qualifiers.ActivityContext
import xyz.zohre.presentation.AppNavigator
import xyz.zohre.presentation.AppPage
import xyz.zohre.ui.HomeFragment
import javax.inject.Inject

class HelloFreshAppNavigator @Inject constructor(@ActivityContext private val activity: Context):
    AppNavigator {
    override fun navigateTo(appPage: AppPage) {
        when (appPage) {
            is AppPage.HomePage -> {
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance()).
                    commit()
            }
        }
    }
}