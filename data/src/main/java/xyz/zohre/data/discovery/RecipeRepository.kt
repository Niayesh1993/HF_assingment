package xyz.zohre.data.discovery

import xyz.zohre.data.model.Recipe
import xyz.zohre.domain.FlowRepository

interface RecipeRepository: FlowRepository<List<Recipe>> {
}