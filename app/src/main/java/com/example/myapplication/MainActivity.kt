package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val activitymainbutton = findViewById<Button>(R.id.activitymainbutton)
//        val edittext = findViewById<EditText>(R.id.EditText)
//        val textview = findViewById<TextView>(R.id.TextView)
        EditText.setText("")
        activitymainbutton.setOnClickListener {
            val text = EditText.text.toString()
            TextView.text = text

        }


        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)
        fragmentbutton2.setOnClickListener {
            setCurrentFragment(firstFragment)
        }

        fragmentbutton1.setOnClickListener {
            setCurrentFragment(secondFragment)
        }


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mHome -> setCurrentFragment(firstFragment)
                R.id.mChat -> setCurrentFragment(secondFragment)
                R.id.mProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }
        bottomNavigationView.getOrCreateBadge(R.id.mChat).apply {
            number = 10
            isVisible=true
        }
    }


    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()

        }
}