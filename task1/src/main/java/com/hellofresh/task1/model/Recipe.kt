package com.hellofresh.task1.model

data class Recipe(
    val recipeItem: RecipeItem,
    val available: Boolean,
    var selected: Boolean
)
