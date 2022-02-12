package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe

class MenuContext(private val menuStrategy: MenuStrategy) {

    private val recipes: List<Recipe> = ArrayList<Recipe>()

    fun getAvailableRecipe(): List<Recipe> {
        val availableRecipe: ArrayList<Recipe> = ArrayList()
        for (recipe in recipes){
            if (recipe.available) {
                availableRecipe.add(recipe)
            }
        }
        return availableRecipe

    }

    fun searchByTag(tag: String): List<Recipe> {
        var taggedRecipe: ArrayList<Recipe> = ArrayList()
        for (recipe in recipes){
            if (recipe.recipeItem.tag == tag) {
                taggedRecipe.add(recipe)
            }
        }
        return taggedRecipe
    }

    fun setSelectedRecipe(recipeId: String, selectedStatus: Boolean)
    {
        return menuStrategy.setSelectedRecipe(recipeId, selectedStatus, recipes)
    }

    fun setSelectedRecipe(recipeIds: List<String>, selectedStatus: Boolean)
    {
        return menuStrategy.setSelectedRecipe(recipeIds, selectedStatus, recipes)
    }

    fun getSelectedRecipe(): List<Recipe> {
        return menuStrategy.getSelectedRecipe()
    }
}