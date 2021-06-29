package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val donebtn: Button = findViewById(R.id.done_button)
        val ne: TextView = findViewById(R.id.nickname_edit)
        val nt: TextView = findViewById(R.id.nickname_text)

        donebtn.setOnClickListener() {
            addNickname(it)
            nt.text = ne.text
            ne.visibility = View.GONE
            donebtn.visibility = View.GONE
            nt.visibility = View.VISIBLE

        }
        nt.setOnClickListener(){
            ne.text = nt.text
            ne.visibility = View.VISIBLE
            donebtn.visibility = View.VISIBLE
            nt.visibility = View.GONE
            updateNickname(it)

        }
    }

   private fun addNickname(it: View?) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it?.windowToken,0)
    }//try ???

    private fun updateNickname(it: View?) {
        val ne: EditText = findViewById(R.id.nickname_edit)
        ne.requestFocus()
        ne.setSelection(ne.length())
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        /* this can work too
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(ne, 0) //ne = nickname_edit
        */

    }
}

