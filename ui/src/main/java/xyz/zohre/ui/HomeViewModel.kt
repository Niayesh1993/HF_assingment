package xyz.zohre.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import xyz.zohre.data.discovery.RecipeRepository
import xyz.zohre.data.model.Recipe
import xyz.zohre.presentation.Event
import xyz.zohre.presentation.TextData
import xyz.zohre.domain.entities.Result
import xyz.zohre.presentation.parseErrorStringRes

import javax.inject.Inject

class HomeViewModel@Inject constructor(val recipeRepository: RecipeRepository) : ViewModel() {

    private var searchJob: Job? = null

    private val _recipes = MutableLiveData<List<Recipe>?>()
    val recipes: LiveData<List<Recipe>?> get() = _recipes

    private val _showError = MutableLiveData<Event<TextData>>()
    val showError: LiveData<Event<TextData>> = _showError

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun searchProducts() {
        searchJob?.cancel()

        searchJob = viewModelScope.launch {

            recipeRepository().collect { showResults(it) }
        }
    }

    private fun showResults(recipesDataResults: Result<List<Recipe>>) {

        when (recipesDataResults) {
            is Result.Success -> {
                val productsData = recipesDataResults.data
                _recipes.value = productsData
            }
            Result.Loading -> {
                _loading.value = true

            }
            is Result.Error -> {
                recipesDataResults.exception.let {
                    _showError.value = Event(it.parseErrorStringRes())
                }
            }
        }

    }
}