package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.RecipeItem
import com.hellofresh.task1.model.Subscription

object TestData {

    private val recipe1 = RecipeItem("101", "sushi", "hot")
    private val recipe2 = RecipeItem("102", "pasta", "quick")
    private val recipe3 = RecipeItem("103", "sandwich", "cold")

     val recipeList = mutableListOf<Recipe>(
    Recipe(recipe1, available = true, selected = false),
    Recipe(recipe2, available = true, selected = true),
    Recipe(recipe3, available = false, selected = false)
    )

    val selectedRecipeList = mutableListOf<Recipe>(
        Recipe(recipe2, available = true, selected = true)
    )

    val availableRecipeList = mutableListOf<Recipe>(
        Recipe(recipe1, available = true, selected = false),
        Recipe(recipe2, available = true, selected = true))

     val subscription = Subscription("50", "25 Feb", false)

}