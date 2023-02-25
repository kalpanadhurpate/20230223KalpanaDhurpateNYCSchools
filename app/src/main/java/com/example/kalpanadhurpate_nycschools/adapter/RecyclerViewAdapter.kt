package com.example.kalpanadhurpate_nycschools.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalpanadhurpate_nycschools.R
import com.example.kalpanadhurpate_nycschools.pojo.SchoolListPojoItem

class RecyclerViewAdapter() :
    RecyclerView.Adapter<MyViewHolder>() {
    private var schoolList = mutableListOf<SchoolListPojoItem>()
    var onItemClick: ((SchoolListPojoItem) -> Unit)? = null

    public fun updateMovieList(list: List<SchoolListPojoItem>) {
        this.schoolList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val school = schoolList[position]
        holder.bind(school)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(school)
        }

    }

    override fun getItemCount(): Int {
        return schoolList.size
    }
}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: SchoolListPojoItem) {
        val nameTextView = view.findViewById<TextView>(R.id.textViewCollegeName)
        nameTextView.text = fruit.school_name
    }

}