package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe

interface Menu {

    fun getAvailableRecipe(): List<Recipe>

    fun setSelectedRecipe(recipeId: String, selectedStatus: Boolean)

    fun setSelectedRecipe(recipeIds: List<String>, selectedStatus: Boolean)

    fun getSelectedRecipe(): List<Recipe>

    fun searchByTag(tag: String): List<Recipe>

    fun checkRestriction(): Boolean

}