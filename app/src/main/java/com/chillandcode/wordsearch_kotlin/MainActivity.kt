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
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillandcode.wordsearch_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var isLinearLayoutManager: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateLayout()

    }

    private fun updateLayout() {// switch between grid or normal view
        if (isLinearLayoutManager)
            binding.mainListRecyclerView.layoutManager = LinearLayoutManager(this)
        else
            binding.mainListRecyclerView.layoutManager = GridLayoutManager(this, 4)

        binding.mainListRecyclerView.adapter = LetterAdapter()
        // the adapter of recycler view determines the scrolling and replacing of contents in the recycler view
        // a recycler view have number of columns as per the content arrangements which updates when changes occur
        // the adapter  manages the each visible item and few buffered items in the recycler view
    }

    private fun updateIcon(menuItem: MenuItem) {//updates the view icon

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_dialer)
            else
                ContextCompat.getDrawable(this, android.R.drawable.ic_menu_view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Grid or list => finding menuItem and updating the icon
        menuInflater.inflate(R.menu.view_control, menu)
        val layoutButton = menu.findItem(R.id.menu_toggle_view)
        updateIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //toggle view logic
        return when (item.itemId) {
            R.id.menu_toggle_view -> {
                isLinearLayoutManager = !isLinearLayoutManager
                updateLayout()
                updateIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}