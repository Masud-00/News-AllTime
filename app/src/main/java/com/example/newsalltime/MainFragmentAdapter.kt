package com.example.newsalltime

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsalltime.model.Article

class MainFragmentAdapter(private val listener: Context): RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {
    private val allArticle=ArrayList<Article>()
    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView =itemView.findViewById(R.id.title)
        val author: TextView =itemView.findViewById(R.id.author)
        val image: ImageView =itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        val viewHolder=MainViewHolder(view)
        view.setOnClickListener {
            listener.onItemClick(allArticle[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem=allArticle[position]

        holder.title.text= currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)


    }

    override fun getItemCount(): Int {
        return allArticle.size
    }

    fun updateNews(items: List<Article>){
        allArticle.clear()
        allArticle.addAll((items))
        notifyDataSetChanged()
    }
}

private fun Context.onItemClick(article: Article) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(this, Uri.parse(article.url))
}


