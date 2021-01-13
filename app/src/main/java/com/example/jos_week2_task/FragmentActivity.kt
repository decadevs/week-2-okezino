package com.example.jos_week2_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_main.*


class FragmentActivity : AppCompatActivity() {

    companion object{
        var num = 1
         var stackOfFragment : Int = 0
    }

       lateinit var addbutton : Button
       lateinit var removebutton : Button
//       lateinit var textChange : TextView
       var Tag = "fragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        addbutton = findViewById(R.id.button)
        removebutton = findViewById(R.id.button2)




        val fragmentManager = supportFragmentManager



        removebutton.setOnClickListener {
            fragmentManager.popBackStack()
            stackOfFragment = fragmentManager.backStackEntryCount
//            textChange.text = getString(R.string.position, stackOfFragment)
        }

        fun fragment(number: Int,stackOfFragmentNumber : Int) {
            val secondFragment = SecondFragment.newInstance(stackOfFragmentNumber)
            val firstFragment = FirstFragment.newInstance(stackOfFragmentNumber)
            val thirdFragment = ThirdFragment.newInstance(stackOfFragmentNumber)
            val forthFragment = ForthFragment.newInstance(stackOfFragmentNumber)

            when {

              number ==  1 -> {
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment1, firstFragment)
                            .addToBackStack(null)
                            .commit()
                    num++
                }

              number ==  2 -> {
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment1, secondFragment)
                            .addToBackStack(null)
                            .commit()
                    num++
                }
              number ==  3 -> {
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment1, thirdFragment)
                            .addToBackStack(null)
                            .commit()
                    num++
                }
             number == 4 -> {
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment1, forthFragment)
                            .addToBackStack(null)
                            .commit()
                    num = 1
                }
            }


        }


        addbutton.setOnClickListener {
            stackOfFragment = fragmentManager.backStackEntryCount
            fragment(num, stackOfFragment)

//            textChange.text = getString(R.string.position, stackOfFragment)
            Log.d(Tag, num.toString())
        }


    }

//    override fun onResume() {
//        super.onResume()
//
//        if(stackOfFragment == 0) removebutton.isClickable = false
//    }


}