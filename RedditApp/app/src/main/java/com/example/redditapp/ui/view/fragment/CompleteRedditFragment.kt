package com.example.redditapp.ui.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.redditapp.R
import com.example.redditapp.databinding.FragmentCompleteRedditBinding
import com.example.redditapp.service.constants.RedditConstants
import com.example.redditapp.service.image.ImageService
import com.example.redditapp.service.model.appmodel.RedditModel

class CompleteRedditFragment : Fragment() {
    // Binding
    private var _binding: FragmentCompleteRedditBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<CompleteRedditFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Bundle?
    ): View? {

        // Binding
        _binding = FragmentCompleteRedditBinding.inflate(layoutInflater)

        // Load Args
        val reddit = args.reddit
        loadDataFromMain(requireContext(), reddit)

        return binding.root
    }

    private fun loadDataFromMain(context: Context, reddit: RedditModel) {
        binding.textTitle.text = reddit.title
        binding.textAuthor.text = getString(R.string.author_complete_activity, reddit.author)
        binding.textScore.text = getString(R.string.score_complete_activity, reddit.score)
        binding.textComments.text =
            getString(R.string.comments_complete_activity, reddit.numComments)
        val url = reddit.url
        ImageService.loadImage(context, url, binding.imageReddit)
    }
}
