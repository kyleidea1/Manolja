package com.example.manolja.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manolja.R
import com.example.manolja.data.Message
import com.example.manolja.ui.MessageAdapter
import com.google.firebase.database.*

class ChatActivity : AppCompatActivity() {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button

    private lateinit var database: DatabaseReference
    private lateinit var messages: MutableList<Message>
    private val currentUser = "김주송"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        messageRecyclerView = findViewById(R.id.message_recycler_view)
        messageInput = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)

        messages = mutableListOf()
        messageAdapter = MessageAdapter(messages)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = messageAdapter

        // Firebase 데이터베이스 참조 설정
        database = FirebaseDatabase.getInstance().getReference("messages")

        // 메시지 전송 버튼 클릭 리스너
        sendButton.setOnClickListener {
            val text = messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                sendMessage(text)
            }
        }

        // Firebase 데이터베이스에서 메시지 불러오기
        loadMessages()
    }

    private fun loadMessages() {
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val message = snapshot.getValue(Message::class.java)
                message?.let {
                    val isCurrentUser = it.sender == currentUser
                    val newMessage = it.copy(isCurrentUser = isCurrentUser)
                    messages.add(newMessage)
                    messageAdapter.notifyItemInserted(messages.size - 1)
                    messageRecyclerView.scrollToPosition(messages.size - 1)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // 메시지가 수정된 경우 처리
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // 메시지가 삭제된 경우 처리
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // 메시지가 이동된 경우 처리
            }

            override fun onCancelled(error: DatabaseError) {
                // 데이터 로드 취소 시 처리할 코드
            }
        })
    }

    private fun sendMessage(text: String) {
        val message = Message(sender = currentUser, text = text, isCurrentUser = true)
        database.push().setValue(message)
        messageInput.text.clear()
    }
}
