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
        binding.mainList
        updateLayout()

    }

    private fun updateLayout() {
        if (isLinearLayoutManager)
            binding.mainList.layoutManager = LinearLayoutManager(this)
        else
            binding.mainList.layoutManager = GridLayoutManager(this, 4)

        binding.mainList.adapter=LetterAdapter()
    }

    private fun updateIcon(menuItem: MenuItem) {

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_dialer)
            else
                ContextCompat.getDrawable(this, android.R.drawable.ic_menu_view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.view_control, menu)
        val layoutButton = menu.findItem(R.id.menu_toggle_view)
        updateIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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