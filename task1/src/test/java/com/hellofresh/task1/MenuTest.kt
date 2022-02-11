package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.Subscription
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MenuTest {

   lateinit var recipeList: List<Recipe>
   lateinit var subscription: Subscription
   lateinit var menuImp: MenuImp

   @Before
   fun setUp() {
       recipeList = TestData.recipeList
       subscription = TestData.subscription
       menuImp = MenuImp(subscription)
   }

    @Test
    fun checkGetAvailableWorkProperly() {
        val result = menuImp.getAvailableRecipe()
        Assert.assertEquals(result, TestData.availableRecipeList)
    }

    @Test
    fun checkSearchByTagWorkProperly() {
        val result = menuImp.searchByTag("cold")
        Assert.assertEquals(result, recipeList[2])
    }

    @Test
    fun checkGetSelectedRecipeWorkProperly() {
        val result = menuImp.getSelectedRecipe()
        Assert.assertEquals(result, TestData.selectedRecipeList)
    }

    @Test
    fun checkRestrictionWorkProperly() {
        val result = menuImp.checkRestriction()
        Assert.assertEquals(result, true)
    }
}