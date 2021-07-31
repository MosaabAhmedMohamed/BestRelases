package com.movie.bestrelases.custom

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.movie.bestrelases.base.ui.BaseDialog
import com.movie.bestrelases.databinding.DialogRetryBinding


class RetryDialog : BaseDialog() {

    private lateinit var binding: DialogRetryBinding

    private lateinit var onRetry: () -> Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogRetryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewClicked() {
        binding.btnRetry.setOnClickListener {
            dismiss()
            onRetry()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        requireActivity().finish()
    }

    override fun init() {
    }

    companion object {
        fun newInstance(onRetry: () -> Unit): RetryDialog {
            val args = Bundle()
            return RetryDialog().apply {
                this.onRetry = onRetry
                this.arguments = args
            }
        }
    }

}