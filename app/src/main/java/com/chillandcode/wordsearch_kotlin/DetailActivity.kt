/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chillandcode.wordsearch_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillandcode.wordsearch_kotlin.databinding.WordDetailsBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        //similar to static class
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = WordDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val letterId = intent.extras?.getString(LETTER).toString()
        binding.detailWordsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.detailWordsRecyclerView.adapter = WordAdapter(letterId, this)
        binding.detailWordsRecyclerView.addItemDecoration(
            (DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            ))
        )
        title = getString(R.string.detail_prefix) + " " + letterId
    }

}
