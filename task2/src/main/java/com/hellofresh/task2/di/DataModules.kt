package com.hellofresh.task2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.zohre.data.discovery.RecipeRepository
import xyz.zohre.data.discovery.RecipeRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
class DataModules {
    @Provides
    fun provideRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository {
        return recipeRepositoryImpl
    }
}