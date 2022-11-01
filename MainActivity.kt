package com.example.whishlist

import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var wishes: List<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameET = findViewById<EditText>(R.id.name_text)
        val urlET = findViewById<EditText>(R.id.url_text)
        val priceET = findViewById<EditText>(R.id.price_text)
        val submitBtn = findViewById<Button>(R.id.submit_btn)


        submitBtn.setOnClickListener {
            WishFetcher.addWishes(nameET.text.toString(), urlET.text.toString(), priceET.text.toString())

            val wishesRv = findViewById<RecyclerView>(R.id.wishesRv)

            wishes = WishFetcher.getWishes()

            val adapter = WishAdapter(wishes)

            wishesRv.adapter = adapter

            wishesRv.layoutManager = LinearLayoutManager(this)

            nameET.text.clear()
            urlET.text.clear()
            priceET.text.clear()
            hideKeyboard()
        }
    }
    private fun hideKeyboard() {
        val view = this.currentFocus

        if (view != null) {
            val hideMe = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken, 0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}