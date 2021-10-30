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

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

// credits : vishnu sunilkumar **** www.chillandcode.com


//shows main screen with all letters
// ALL println() methods are created for understanding the concept

// ***** RESULT
// The adapter is initialised only once
// There after the adapter returns a reference to the Concerned View Holder
// ie, the LetterAdapter here returns an Adapter [RecyclerView.Adapter] of <T> for Type < LetterAdapter.LetterViewHolder>
// this LetterViewHolder - > contains all information relating to an item in the recycler view
// in the on create view holder method the layout for the view [ie, a single item in the recycler view ] is prepared by inflating the base layout
// then this layout is passed to the LetterViewHolder class
// credits : vishnu sunilkumar **** www.chillandcode.com
// The on create view holder returns the prepared LetterViewHolder , which contains the button only in our case...
// Now, All the view holder classes created this way will have the button in it
// Each of this views are then passed for binding-> ie, for actual display to the recycler view
// The on bind view holder takes the Letter View Holder object and the position number
// It looks at the list data with position and the holder component is updated with data relating to that position
//
// *********
class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {
    init {
        println("202020 INITIALISED ********* ADAPTER ")
    }


    //creates a list from A to Z to show it in recycler view in main screen
    private val list = ('A').rangeTo('Z').toList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_letter, parent, false)
        println("202020 CALLED CREATE VIEW HOLDER")
        return LetterViewHolder(layout)
    }

    class LetterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //print ln statements to identify how many times all the respective functions or classes are called/created

        init {
            println("202020 INITIALISED CLASS LETTER VIEW HOLDER ")
        }

        val button: Button = view.findViewById<Button>(R.id.button_item_letter)

    }


    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        println("202020 CALLED BIND VIEW HOLDER")
        val item =
            list[position]// updating the view holder at the position with the data to be displayed at that position
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val context = holder.itemView.context
            // credits : vishnu sunilkumar **** www.chillandcode.com
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        println("202020 CALLED GET ITEM COUNT")
        return list.size // this is the number of items to be expected by the adapter... if this is reduced the adapter holds the operations to that number ..
        //if this exceeds the actual number of data available then it will lead to index out of bounds exception
        // credits : vishnu sunilkumar **** www.chillandcode.com
    }
}