package com.example.redditapp.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.databinding.FragmentRedditListBinding
import com.example.redditapp.service.listener.RedditListener
import com.example.redditapp.service.model.appmodel.RedditModel
import com.example.redditapp.ui.adapter.RedditAdapter
import com.example.redditapp.ui.viewmodel.RedditListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RedditListFragment : Fragment() {

    // ViewModel & Binding
    private val viewModel: RedditListViewModel by viewModel()
    private val adapter: RedditAdapter by inject()
    private var _binding: FragmentRedditListBinding? = null
    private val binding get() = _binding!!

    // RecyclerView & Scroll
    private lateinit var recycler: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    // Transition
    private var isLoading = false
    private var transition = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {

        // Bindind
        _binding = FragmentRedditListBinding.inflate(layoutInflater)

        // RecylerView & Scroll
        recycler = binding.recyclerAllReddits
        layoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!isLoading) {
                    val visibleItemCount = layoutManager.getChildCount();
                    val totalItemCount = layoutManager.getItemCount();
                    val pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();

                    viewModel.onScroll(visibleItemCount, pastVisiblesItems, totalItemCount)

                }
            }
        })
        val redditListener = object : RedditListener {
            override fun onRedditClick(reddit: RedditModel) {
                transition = true
                viewModel.navigate(reddit)
            }

        }
        adapter.attachRedditListener(redditListener)

        // Refresh
        binding.swipeContainer.setOnRefreshListener {
            viewModel.getReddits()
            binding.swipeContainer.isRefreshing = false
        }

        // Observers
        observe()

        return binding.root

    }

    override fun onResume() {
        super.onResume()
        viewModel.getReddits()
    }

    private fun observe() {
        viewModel.reddits.observe(viewLifecycleOwner) {
            adapter.updateReddits(it)
            isLoading = false
        }
        viewModel.clickReddit.observe(viewLifecycleOwner) {
            if (transition == true) {
                val direction = RedditListFragmentDirections.actionRedditListFragmentToCompleteRedditFragment(it)
                findNavController().navigate(direction)
                transition = false
            }
        }
        viewModel.load.observe(viewLifecycleOwner) {
            if (it) {
                isLoading = true
                viewModel.getMoreReddits()
            }
        }
    }
}