package com.example.kalpanadhurpate_nycschools.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.kalpanadhurpate_nycschools.R


class SchoolDetailFragment : DialogFragment() {

    companion object {
        const val TAG = "SimpleDialog"
        private const val KEY_SCHOOL_NAME = "school_name"
        private const val KEY_MATH = "sat_math_avg_score"
        private const val KEY_READING = "sat_critical_reading_avg_score"
        private const val KEY_WRITING = "sat_writing_avg_score"

        fun newInstance(
            schoolName: String,
            math: String,
            reading: String,
            writing: String,
        ): SchoolDetailFragment {
            val args = Bundle()
            args.putString(KEY_SCHOOL_NAME, schoolName)
            args.putString(KEY_MATH, math)
            args.putString(KEY_READING, reading)
            args.putString(KEY_WRITING, writing)
            val fragment = SchoolDetailFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.layout_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        val textViewSchool = view.findViewById<TextView>(R.id.textViewSchoolName)
        val textViewMath = view.findViewById<TextView>(R.id.textView1)
        val textViewReading = view.findViewById<TextView>(R.id.textView2)
        val textViewWriting = view.findViewById<TextView>(R.id.textView3)

        textViewSchool.text = arguments?.getString(KEY_SCHOOL_NAME)
        textViewMath.text = arguments?.getString(KEY_MATH)
        textViewReading.text = arguments?.getString(KEY_READING)
        textViewWriting.text = arguments?.getString(KEY_WRITING)


        //view.t = arguments?.getString(KEY_MATH)
        ///   view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
    }

    private fun setupClickListeners(view: View) {

        val button = view.findViewById<Button>(R.id.btnOk)
        button.setOnClickListener {
            dismiss()
        }
    }
}