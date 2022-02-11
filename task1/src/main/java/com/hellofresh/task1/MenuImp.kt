package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.Subscription

class MenuImp(private val subscription: Subscription): Menu {

    private val recipes: List<Recipe> = ArrayList<Recipe>()
    var selectedRecipe: ArrayList<Recipe> = ArrayList()

    override fun getAvailableRecipe(): List<Recipe> {
        var availableRecipe: ArrayList<Recipe> = ArrayList()
        for (recipe in recipes){
            if (recipe.available) {
                availableRecipe.add(recipe)
            }
        }
        return availableRecipe

    }

    override fun setSelectedRecipe(recipeId: String, selectedStatus: Boolean) {
        for (recipe in recipes){
            if (recipe.recipeItem.id == recipeId && checkRestriction()) {
                recipe.selected = selectedStatus
                selectedRecipe.add(recipe)
            }
            else showRestrictionError()
        }
    }

    override fun setSelectedRecipe(recipeIds: List<String>, selectedStatus: Boolean) {
       for (item in recipeIds) {
           for (recipe in recipes) {
               if (recipe.recipeItem.id == item && checkRestriction()) {
                   recipe.selected = selectedStatus
                   selectedRecipe.add(recipe)
               }
               else showRestrictionError()
           }
       }
    }

    private fun showRestrictionError() {
        println("Your Selected List is Full!")
    }

    override fun getSelectedRecipe(): List<Recipe> {
        return selectedRecipe
    }

    override fun searchByTag(tag: String): List<Recipe> {
        var taggedRecipe: ArrayList<Recipe> = ArrayList()
        for (recipe in recipes){
            if (recipe.recipeItem.tag == tag) {
                taggedRecipe.add(recipe)
            }
        }
        return taggedRecipe
    }

    override fun checkRestriction(): Boolean {
        if (subscription.isForFamily && selectedRecipe.size < 5) return true
        return !subscription.isForFamily && selectedRecipe.size < 3
    }

}