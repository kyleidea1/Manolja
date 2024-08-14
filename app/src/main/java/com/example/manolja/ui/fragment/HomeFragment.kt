package com.example.manolja.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.manolja.R

class HomeFragment : Fragment() {

    private lateinit var ivMail: ImageView
    private lateinit var tvQuestPrompt: TextView
    private lateinit var textContainer: LinearLayout
    private lateinit var ivCoupon: ImageView
    private lateinit var couponDialog: Dialog
    private lateinit var layoutTextContainer: LinearLayout
    private lateinit var tvNoCoupons: TextView
    private var isCouponUsed: Boolean = false
    private lateinit var ivHpBar: ImageView
    private lateinit var ivBoogiEgg: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        var hp: Int = 1

        ivMail = view.findViewById(R.id.ivMail)
        tvQuestPrompt = view.findViewById(R.id.tvQuestPrompt)
        textContainer = view.findViewById(R.id.textContainer)
        ivCoupon = view.findViewById(R.id.ivCoupon)
        ivHpBar = view.findViewById(R.id.ivHpBar)
        ivBoogiEgg = view.findViewById(R.id.ivBoogiEgg)

        ivMail.setOnClickListener {
            tvQuestPrompt.visibility = View.INVISIBLE
            ivMail.visibility = View.INVISIBLE
            textContainer.visibility = View.VISIBLE
        }

        ivCoupon.setOnClickListener {
            showCouponDialog()
        }

        updateImages(hp)
        return view
    }

    private fun showCouponDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.coupon_dialog, null)
        val btnUseCoupon = dialogView.findViewById<Button>(R.id.btnUseCoupon)
        layoutTextContainer = dialogView.findViewById(R.id.layoutTextContainer)
        tvNoCoupons = dialogView.findViewById(R.id.tvNoCoupons)

        if (isCouponUsed) {
            layoutTextContainer.visibility = View.GONE
            tvNoCoupons.visibility = View.VISIBLE
        } else {
            layoutTextContainer.visibility = View.VISIBLE
            tvNoCoupons.visibility = View.GONE
            btnUseCoupon.setOnClickListener {
                showConfirmationDialog()
            }
        }

        couponDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        couponDialog.show()
    }

    private fun showConfirmationDialog() {
        AlertDialog.Builder(context)
            .setMessage("쿠폰을 사용하시겠어요?")
            .setPositiveButton("확인") { dialog, which ->
                layoutTextContainer.visibility = View.GONE
                tvNoCoupons.visibility = View.VISIBLE
                isCouponUsed = true
                couponDialog.dismiss()
            }
            .setNegativeButton("취소", null)
            .show()
    }

    private fun updateImages(hp: Int) {
        when (hp) {
            1 -> {
                ivHpBar.setImageResource(R.drawable.iv_hp_bar_1)
                ivBoogiEgg.setImageResource(R.drawable.iv_boogi_egg)
            }
            2 -> {
                ivHpBar.setImageResource(R.drawable.iv_hp_bar_2)
                ivBoogiEgg.setImageResource(R.drawable.iv_boogi_baby)
            }
            3 -> {
                ivHpBar.setImageResource(R.drawable.iv_hp_bar_3)
                ivBoogiEgg.setImageResource(R.drawable.iv_boogi_adult)
            }
        }
    }
}
