package com.example.manolja.ui.activity

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.manolja.R
import java.io.IOException

class CertActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var imageViewPreview: ImageView
    private var imageUri: Uri? = null
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cert)

        imageViewPreview = findViewById(R.id.imageViewPreview)
        val buttonUpload: Button = findViewById(R.id.buttonUpload)
        val buttonConfirm: Button = findViewById(R.id.buttonConfirm)
        val buttonCancel: Button = findViewById(R.id.buttonCancel)

        // ProgressDialog 초기화
        progressDialog = ProgressDialog(this).apply {
            setMessage("인증 중...")
            setCancelable(false)
        }

        // 사진 업로드 버튼 클릭 리스너
        buttonUpload.setOnClickListener { openFileChooser() }

        // 확인 버튼 클릭 리스너
        buttonConfirm.setOnClickListener {
            if (imageUri != null) {
                // 로딩 창 표시
                progressDialog.show()

                // 사진 업로드 로직 구현 (예: 서버에 업로드)
                // 여기서는 업로드가 완료된 후 로직을 직접 호출합니다.
                uploadImageAndFinish()
            } else {
                Toast.makeText(this, "사진을 선택해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 취소 버튼 클릭 리스너
        buttonCancel.setOnClickListener { finish() } // 액티비티 종료
    }

    private fun openFileChooser() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            try {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                imageViewPreview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImageAndFinish() {
        // 업로드 시뮬레이션을 위해 3초 지연
        Handler(Looper.getMainLooper()).postDelayed({
            // 로딩 창 닫기
            progressDialog.dismiss()

            // 결과 전달: 인증 성공
            val resultIntent = Intent()
            resultIntent.putExtra("upload_success", true)
            setResult(RESULT_OK, resultIntent)
            finish() // CertActivity 종료
        }, 3000) // 3000ms = 3초
    }
}