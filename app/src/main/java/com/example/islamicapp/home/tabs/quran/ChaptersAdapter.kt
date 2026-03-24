package com.example.islamicapp.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.databinding.ItemChapterBinding
import com.example.islamicapp.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>) :
    RecyclerView.Adapter<ChaptersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(    //function مسؤولة عن إنشاء شكل العنصر الواحد
        holder: ViewGroup,
        position: Int
    ): ViewHolder {
        val itemBinding = ItemChapterBinding.inflate(
            LayoutInflater.from(holder.context), holder, false
        )
        return ViewHolder(itemBinding)

    }

    override fun onBindViewHolder(   //دي مسؤولة عن تعبية البيانات لكل عنصر
        holder: ViewHolder,
        position: Int
    ) {
        val chapter = chapters[position]
        holder.itemBinding.tvArabicTitle.text = chapter.titleAr
        holder.itemBinding.tvEnglishTitle.text = chapter.titleEn
        holder.itemBinding.tvVersesNo.text = chapter.versesNumber
        holder.itemBinding.tvChapterNo.text = "${chapter.index + 1}"


    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    class ViewHolder(val itemBinding: ItemChapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }
}