package com.example.githubokhttpissueslist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubokhttpissueslist.R
import com.example.githubokhttpissueslist.data.models.Issues
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_issues.view.*

class IssueAdapter(private val data:List<Issues>):RecyclerView.Adapter<IssueViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder
    = IssueViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_issues,parent,false)
    )

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class IssueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Issues)= with(itemView){
        issueTv.text = item.title
        usernameTv.text = item.user?.login
        issueDescTv.text = item.body
        Picasso.get().load(item.user?.avatarUrl).into(userImgView)
    }
}