package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe

interface MenuStrategy {

    fun setSelectedRecipe(recipeId: String, selectedStatus: Boolean, recipes: List<Recipe>)

    fun setSelectedRecipe(recipeIds: List<String>, selectedStatus: Boolean, recipes: List<Recipe>)

    fun getSelectedRecipe(): List<Recipe>


}