package com.example.day22project_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya Singh", "Virat Kohli", "Rohit Sharma", "Sonam Bajwa", "Vikas Gupta",
            "Abdul Kalam")
        val lastMsg = arrayOf("Hey Vikas!! How are You"," Hello Vikas!!","Awesome,Cool","Hello Friend!!","Hey Vikas!! Nice to Meet You",
            "God bless you Vikas!!")
        val lastMsgTime = arrayOf("6:25 AM", "5:00 PM", "7:30 PM", "6:25 AM", "9;00 PM", "5;36 PM")
        val phoneNumber = arrayOf("7864537394","7856409082", "9087658904", "8388777386", "7354789076", "9564879345")
        val imgId = intArrayOf(R.mipmap.pic4, R.mipmap.pic0, R.mipmap.img, R.mipmap.img_1, R.mipmap.pic3, R.mipmap.pic5)

        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)

        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener{parent, view, position, id ->
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]
            val lastSeen = lastMsgTime[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            i.putExtra("lastShown", lastSeen)

            startActivity(i)
        }
    }
}