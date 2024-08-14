package com.example.manolja.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.manolja.R
import com.example.manolja.domain.Coupon

class QuestAdapter(
    private val couponItems: MutableList<Coupon> = mutableListOf(),
    private var itemsEnabled: Boolean = false
) : RecyclerView.Adapter<QuestAdapter.ViewHolder>() {

    private var itemClickListener: ((String) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCoupon: TextView = itemView.findViewById(R.id.tvCoupon)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvDiscount: TextView = itemView.findViewById(R.id.tvDiscount)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)

        init {
            itemView.setOnClickListener {
                if (itemsEnabled) {
                    val couponName = tvCoupon.text.toString()
                    itemClickListener?.invoke(couponName)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quest_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = couponItems[position]
        holder.tvCoupon.text = item.name
        holder.tvLocation.text = item.location
        holder.tvDiscount.text = item.discount
        holder.tvContent.text = item.content
        holder.itemView.isEnabled = itemsEnabled
    }

    override fun getItemCount(): Int = couponItems.size

    fun setItemsEnabled(enabled: Boolean) {
        itemsEnabled = enabled
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (String) -> Unit) {
        itemClickListener = listener
    }

    fun addCoupons(newCoupons: List<Coupon>) {
        couponItems.clear()
        couponItems.addAll(newCoupons)
        notifyDataSetChanged()
    }
}