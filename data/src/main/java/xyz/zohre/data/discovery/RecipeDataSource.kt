package xyz.zohre.data.discovery

import retrofit2.Response
import retrofit2.http.GET
import xyz.zohre.data.model.Recipe

interface RecipeDataSource {

    @GET("https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/recipes.json")
    suspend fun searchRecipe(): Response<List<Recipe>>
}