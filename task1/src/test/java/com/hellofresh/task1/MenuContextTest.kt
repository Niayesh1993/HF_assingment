package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.Subscription
import org.junit.Assert
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import java.io.IOException

class MenuContextTest {

   lateinit var recipeList: List<Recipe>
   lateinit var subscription: Subscription
   private lateinit var menuContext: MenuContext
   private lateinit var personMenu: PersonMenu
   private lateinit var familyMenu: FamilyMenu

   @Before
   fun setUp() {
       recipeList = TestData.recipeList
       subscription = TestData.subscription
       personMenu = PersonMenu(subscription)
       familyMenu = FamilyMenu(subscription)
   }

    @Test
    fun checkGetAvailableWorkProperly(menuStrategy: MenuStrategy) {
        menuContext = MenuContext(menuStrategy)
        val result = menuContext.getAvailableRecipe()
        Assert.assertEquals(result, TestData.availableRecipeList)
    }

    @Test
    fun checkSearchByTagWorkProperly(menuStrategy: MenuStrategy) {
        menuContext = MenuContext(menuStrategy)
        val result = menuContext.searchByTag("cold")
        Assert.assertEquals(result, recipeList[2])
    }

    @Test
    fun checkGetSelectedRecipeWorkProperly(menuStrategy: MenuStrategy) {
        menuContext = MenuContext(menuStrategy)
        val result = menuContext.getSelectedRecipe()
        Assert.assertEquals(result, TestData.selectedRecipeList)
    }

    @Test
    fun checkSelectRecipeWorkProperly(menuStrategy: MenuStrategy, recipeId: String, selectedStatus: Boolean) {
        menuContext = MenuContext(menuStrategy)
        assertThrows(IOException::class.java){
            val result = menuContext.setSelectedRecipe(recipeId, selectedStatus)
        }
    }

}