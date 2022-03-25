package com.example.ass

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class Row_Book (val activity: Activity, val books: ArrayList<Book>): RecyclerView.Adapter<Row_Book.ViewMyHolder>(){
    inner class ViewMyHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var bookName = itemView.findViewById<TextView>(R.id.book_Name)
        var author = itemView.findViewById<TextView>(R.id.author_book)
        var year = itemView.findViewById<TextView>(R.id.publish_year)
        var price = itemView.findViewById<TextView>(R.id.book_Price)
        var ratingStar = itemView.findViewById<RatingBar>(R.id.rating_Star)
        var rating = itemView.findViewById<TextView>(R.id.rating_Number)
        var editButton = itemView.findViewById<Button>(R.id.add_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewMyHolder {
        val root = LayoutInflater.from(activity).inflate(R.layout.item, parent, false)
        return ViewMyHolder(root)
    }

    override fun onBindViewHolder(holder: ViewMyHolder, position: Int) {
        holder.bookName.text = books[position].name
        holder.author.text = books[position].author
        holder.year.text = (books[position].year!!.year + 1900).toString()
        holder.price.text = books[position].price.toString()
        holder.rating.text = books[position].rates.toString()
        holder.ratingStar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            if (b) {
                holder.rating.text = fl.toString()
            }
        }
        holder.ratingStar.rating = books[position].rates

        holder.editButton.setOnClickListener {
            activity.startActivity(Intent(activity, Book_Add:: class.java).putExtra("book", books[position]))
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }
}