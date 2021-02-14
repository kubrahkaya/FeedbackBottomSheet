package com.example.feedbackbottomsheet

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.example.feedbackbottomsheet.databinding.BottomSheetFeedbackBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FeedbackBottomSheet : BottomSheetDialogFragment() {

    private val binding by viewBinding(BottomSheetFeedbackBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.setOnShowListener {
            val d = it as BottomSheetDialog
            val bottomSheetInternal = d.findViewById<View>(R.id.design_bottom_sheet)
            if (bottomSheetInternal != null) {
                BottomSheetBehavior.from(bottomSheetInternal).state =
                    BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return inflater.inflate(R.layout.bottom_sheet_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userInput.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                dismiss()
            }
            false
        }
        binding.doneButton.setOnClickListener { dismiss() }
        binding.userInput.imeOptions = EditorInfo.IME_ACTION_DONE
        binding.userInput.setRawInputType(InputType.TYPE_CLASS_TEXT)
    }

    override fun getTheme(): Int {
        return R.style.FeedbackBottomSheetDialog
    }

    companion object {
        val TAG = FeedbackBottomSheet::class.java.simpleName
    }
}