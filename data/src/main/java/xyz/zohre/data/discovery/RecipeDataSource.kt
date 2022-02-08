package xyz.zohre.data.discovery

import retrofit2.Response
import retrofit2.http.GET
import xyz.zohre.data.model.Recipe

interface RecipeDataSource {

    @GET("/android-test/recipes.json")
    suspend fun searchRecipe(): Response<List<Recipe>>
}