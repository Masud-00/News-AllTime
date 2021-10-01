package com.example.newsalltime.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsalltime.*
import com.example.newsalltime.api.NewsService
import com.example.newsalltime.databinding.FragmentBusinessBinding
import com.example.newsalltime.databinding.FragmentGeneralBinding
import com.example.newsalltime.viewmodel.MainViewModel
import com.example.newsalltime.viewmodel.MainViewModelFactory

class BusinessFragment : Fragment() {
    lateinit var binding: FragmentBusinessBinding
    lateinit var mAdapter: MainFragmentAdapter
    lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_business, container, false)




        val recyclerView=binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        mAdapter= MainFragmentAdapter(requireContext())
        recyclerView.adapter=mAdapter

        val newsService= NewsService.apiService
        val repository= Repository(newsService)
        val viewModelFactory= MainViewModelFactory(repository)

        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        if(NetworkUtils.isNetworkConnected(context)) {
            binding.progress.visibility=View.GONE
            viewModel.getNews("business", "in", "da19d9345a5d46e48a7f5002c04171b0")

            viewModel.articles.observe(viewLifecycleOwner, Observer {

                if (it.isSuccessful) {
                    it.body()?.let {
                        mAdapter.updateNews(it.articles)
                    }
                }


            })
        }
        else{
            binding.progress.visibility=View.VISIBLE
            Toast.makeText(requireContext(),"SomeThing is Wrong", Toast.LENGTH_LONG).show()
        }




        return binding.root

    }
}


