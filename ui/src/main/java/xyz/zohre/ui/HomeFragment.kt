package xyz.zohre.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import xyz.zohre.presentation.BaseFragment
import xyz.zohre.presentation.shortToast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val adapter = RecipeRecyclerAdapter()
    private val viewModel: HomeViewModel by getLazyViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe_recycler.adapter = adapter
        recipe_recycler.itemAnimator = DefaultItemAnimator()
        currentDate.text = getCurrentDate()

        initObservers()
        viewModel.searchProducts()
    }

    private fun initObservers() {
        viewModel.recipes.observe(
            viewLifecycleOwner,
            Observer {
                it?.let { it1 -> adapter.insertItems(it1) }
                progressbar.visibility = View.GONE

            }
        )
        viewModel.showError.observe(
            viewLifecycleOwner,
            Observer { event ->
                event.getContentIfNotHandled()?.let { textData ->
                    textData.shortToast(requireContext())
                }
            }
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentDate(): String {
        val currentDateTime = LocalDateTime.now()
        return currentDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
    }
}