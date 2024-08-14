package com.example.manolja.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.manolja.R
import com.example.manolja.data.api.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private lateinit var ivMail: ImageView
    private lateinit var tvQuestPrompt: TextView
    private lateinit var textContainer: LinearLayout
    private lateinit var ivCoupon: ImageView
    private lateinit var couponDialog: Dialog
    private lateinit var layoutTextContainer: LinearLayout
    private lateinit var tvNoCoupons: TextView
    private lateinit var tvQuestName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvCouponName: TextView
    private lateinit var tvDiscountRate: TextView


    private var isCouponUsed: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val home_view = inflater.inflate(R.layout.fragment_home, container, false)
        val coupon_view = inflater.inflate(R.layout.coupon_dialog, container, false)
        // Initialize views
        ivMail = home_view.findViewById(R.id.ivMail)
        tvQuestPrompt = home_view.findViewById(R.id.tvQuestPrompt)
        textContainer = home_view.findViewById(R.id.textContainer)
        ivCoupon = home_view.findViewById(R.id.ivCoupon)

        tvQuestName = home_view.findViewById(R.id.tvQuestName)
        tvAddress = home_view.findViewById(R.id.tvAddress)
        tvCouponName = coupon_view.findViewById(R.id.tvCouponName)
        tvDiscountRate = coupon_view.findViewById(R.id.tvDiscount)
        ivMail.setOnClickListener {
            tvQuestPrompt.visibility = View.INVISIBLE
            ivMail.visibility = View.INVISIBLE
            textContainer.visibility = View.VISIBLE
        }

        ivCoupon.setOnClickListener {
            showCouponDialog()
        }

        // Load data from server
        loadQuest()

        return home_view
    }

    private fun loadQuest() {
        // Use coroutine to fetch data from server
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Fetch data from server
                val quest = RetrofitProvider.questApiService.getTodayQuest()
                withContext(Dispatchers.Main) {
                    // Update UI elements with fetched data
                    Log.d("here1", "loadData: ${quest.name}, ${quest.place}")
                    tvQuestName.text = "퀘스트: ${quest.name}"
                    tvAddress.text = "장소: ${quest.place}"
                }
            } catch (e: Exception) {
                Log.e("HomeFragment", "Error fetching data: ${e.message}")
            }
        }
    }

    private fun loadCoupon() {
        // Use coroutine to fetch data from server
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val coupon = RetrofitProvider.questApiService.checkCoupon("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d")

                withContext(Dispatchers.Main) {
                    // Update UI elements with fetched data
                    tvCouponName.text = coupon.place
                    tvDiscountRate.text = coupon.discount.toString()
                    Log.d("here2", "loadData: ${coupon.place}, ${coupon.discount}")
                }
            } catch (e: Exception) {
                Log.e("HomeFragment", "Error fetching data: ${e.message}")
            }
        }
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
}
