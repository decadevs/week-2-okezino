package com.example.jos_week2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val SECONDFRAGMENTTAG = "param1"


class SecondFragment: Fragment() {
    private var getStackPosition: Int? = null
    lateinit  var  fragmentTextView : TextView

    companion object {
        /**
         * @param stackPosition Parameter .
         * @return A new instance of fragment ForthFragment.
         */

        fun newInstance(stackPosition: Int) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(SECONDFRAGMENTTAG, stackPosition)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            getStackPosition = it.getInt(SECONDFRAGMENTTAG)
        }

    }

    /**
     * Inflate the layout for this fragment
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        fragmentTextView = view.findViewById(R.id.fragment2)
        fragmentTextView.text = getString(R.string.fragmentText2,getStackPosition)
        return view
    }


}