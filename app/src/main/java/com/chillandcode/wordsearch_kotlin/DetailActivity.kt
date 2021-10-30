package com.chillandcode.wordsearch_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillandcode.wordsearch_kotlin.databinding.ActivityMainBinding
import com.chillandcode.wordsearch_kotlin.databinding.WordDetailsBinding

class DetailActivity:AppCompatActivity() {
    companion object {//similar to static class
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=WordDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val letterId= intent.extras?.getString(LETTER).toString()
        binding.detailWordsRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.detailWordsRecyclerView.adapter=WordAdapter(letterId,this)
        binding.detailWordsRecyclerView.addItemDecoration((DividerItemDecoration(this,DividerItemDecoration.VERTICAL)))
        title=getString(R.string.detail_prefix)+" "+letterId
    }

}
