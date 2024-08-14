package com.example.manolja.ui.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manolja.R
import com.example.manolja.data.RecordItem

class RecordAdapter(private val recordItems: List<RecordItem>) : RecyclerView.Adapter<RecordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_record, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recordItem = recordItems[position]
        holder.date.text = recordItem.date
        holder.caption.text = recordItem.caption

        Glide.with(holder.itemView.context)
            .load(recordItem.imageUrl)
            .into(holder.imageView)

        // 아이템 클릭 시 팝업을 띄우는 리스너 설정
        holder.itemView.setOnClickListener {
            showItemPopup(holder.itemView, recordItem, position)
        }
    }

    override fun getItemCount() = recordItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.date)
        val caption: TextView = itemView.findViewById(R.id.caption)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    private fun showItemPopup(view: View, recordItem: RecordItem, position: Int) {
        // 팝업 창의 레이아웃을 inflate
        val dialogView = LayoutInflater.from(view.context).inflate(R.layout.dialog_record_detail, null)

        // 팝업 창의 요소들을 설정
        val popupImageView: ImageView = dialogView.findViewById(R.id.popupImageView)
        val popupDate: TextView = dialogView.findViewById(R.id.popupDate)
        val popupCaptionEdit: EditText = dialogView.findViewById(R.id.popupCaptionEdit)

        popupDate.text = recordItem.date
        popupCaptionEdit.setText(recordItem.caption)

        Glide.with(view.context)
            .load(recordItem.imageUrl)
            .into(popupImageView)

        // AlertDialog를 생성하고 팝업을 표시
        AlertDialog.Builder(view.context)
            .setView(dialogView)
            .setPositiveButton("Save") { dialog, _ ->
                // 사용자가 입력한 새로운 텍스트를 기록
                val newCaption = popupCaptionEdit.text.toString()
                recordItems[position].caption = newCaption

                // RecyclerView에 변경사항 반영
                notifyItemChanged(position)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}