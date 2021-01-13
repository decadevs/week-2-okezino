package com.example.jos_week2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val FIRSTFRAGMENTTAG = "param1"

class FirstFragment  : Fragment() {

    private var getStackPosition: Int? = null
    lateinit  var  fragmentTextView : TextView

    companion object {
        /**
         * @param  stackPosition Parameter 1.
         * @return A new instance of fragment ForthFragment.
         */
        fun newInstance(stackPosition: Int) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putInt(FIRSTFRAGMENTTAG, stackPosition)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            getStackPosition = it.getInt(FIRSTFRAGMENTTAG)
        }

    }

    /**
     * Inflate the layout for this fragment
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        fragmentTextView = view.findViewById(R.id.fragment1)
        fragmentTextView.text = getString(R.string.fragmentText1,getStackPosition)
        return view
    }


}