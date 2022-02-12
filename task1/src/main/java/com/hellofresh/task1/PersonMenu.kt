package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.Subscription
import java.io.IOException

class PersonMenu(private val subscription: Subscription): MenuStrategy {

    var selectedRecipe: ArrayList<Recipe> = ArrayList()

    override fun setSelectedRecipe(recipeId: String, selectedStatus: Boolean, recipes: List<Recipe>) {
        for (recipe in recipes) {
            if (recipe.recipeItem.id == recipeId && selectedRecipe.size < 3) {
                recipe.selected = selectedStatus
                selectedRecipe.add(recipe)
            } else throw IOException()
        }
    }

    override fun setSelectedRecipe(recipeIds: List<String>, selectedStatus: Boolean, recipes: List<Recipe>) {
        for (item in recipeIds) {
            for (recipe in recipes) {
                if (recipe.recipeItem.id == item && selectedRecipe.size < 3) {
                    recipe.selected = selectedStatus
                    selectedRecipe.add(recipe)
                }
                else throw IOException()
            }
        }
    }

    override fun getSelectedRecipe(): List<Recipe> {
        return selectedRecipe
    }

}