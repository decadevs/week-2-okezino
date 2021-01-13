package com.example.jos_week2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_main.*


private const val FORTHFRAGMENTTAG = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ForthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForthFragment : Fragment() {
    private var getStackPosition: Int? = null
    lateinit  var  fragmentTextView : TextView

    companion object {
        /**
         * @param stackPosition Parameter 1.
         * @return A new instance of fragment ForthFragment.
         */

        fun newInstance(stackPosition: Int) =
            ForthFragment().apply {
                arguments = Bundle().apply {
                    putInt(FORTHFRAGMENTTAG, stackPosition)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            getStackPosition = it.getInt(FORTHFRAGMENTTAG)
        }

    }
    /**
     * Inflate the layout for this fragment
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val viewpoint = inflater.inflate(R.layout.fragment_forth, container, false)
        fragmentTextView = viewpoint.findViewById(R.id.fragment4)
        fragmentTextView.text = getString(R.string.fragmentText4,getStackPosition)

        return viewpoint
    }


}