package com.example.mvvmcorurion.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcorurion.R
import com.example.mvvmcorurion.model.jsonListItem



class QuoteAdapter(private val dataSet: List<jsonListItem>,
    private val listener : RecyclickviewClickListinor) :
    RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView
        val name: TextView
        val btn : Button

        init {
            // Define click listener for the ViewHolder's View
            id = view.findViewById(R.id.id)
            name = view.findViewById(R.id.name)
            btn = view.findViewById(R.id.btn)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rowsample, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.id.text = dataSet[position].email
        viewHolder.name.text = dataSet[position].name
        viewHolder.btn.setOnClickListener {
            listener.onRecycleViewItemClick(viewHolder.btn,dataSet[position])

        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
