package fi.oamk.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var message: ArrayList<String>
    private lateinit var database: DatabaseReference
    private lateinit var edMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //PART 1
        /*
        //write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, world!")
        */

        //PART 2
        edMessage = findViewById(R.id.messageText)
        database = Firebase.database.reference
        message = arrayListOf()

        edMessage.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                addMessage()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false

        }
    }

    val messageListener = object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot){

        }

        override fun onCancelled(error: DatabaseError){

        }
    }

    private fun addMessage() {
        val newMessage = edMessage.text.toString()
        message.add(newMessage)
        database.child("message").setValue(message)
        edMessage.setText("")
    }
}