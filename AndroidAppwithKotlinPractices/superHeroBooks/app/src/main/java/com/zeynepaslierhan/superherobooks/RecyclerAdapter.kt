package com.zeynepaslierhan.superherobooks

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycle_row.view.*

class RecyclerAdapter(val superHerosList: ArrayList<String>,val superHerosImgs: ArrayList<Bitmap>) : RecyclerView.Adapter<RecyclerAdapter.SuperHerosVH>() {
    class SuperHerosVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHerosVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_row,parent,false)
        return SuperHerosVH(itemView)
    }

    override fun onBindViewHolder(holder: SuperHerosVH, position: Int) {
        holder.itemView.recyclerTextView.text = superHerosList.get(position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PageActivity::class.java)
            intent.putExtra("superHerosNames",superHerosList.get(position))
            var singleton = SingletonClass.chosen
            singleton.img = superHerosImgs.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return superHerosList.size
    }
}