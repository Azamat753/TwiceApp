package com.siroca.twiceapp.utils.ext

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.example.core.base.BaseFragment
import com.example.core.base.BaseResult
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.PartResultBinding

fun View.visible() {
    this.isVisible = true
}

fun View.gone() {
    this.isVisible = false
}

fun Context.showToast(msg: String?) {
    msg?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
}

fun <B : ViewBinding, T : Any,
        N : Any> BaseFragment<B>.renderSimpleResult(
    root: ViewGroup,
    result: BaseResult<T, N>, onSuccess: (T) -> Unit,
    onError: (N?) -> Unit
) {
    val binding = PartResultBinding.bind(root)
    renderResult(
        root = root,
        result = result,
        onPending = {
            binding.progressBar.visible()
        },
        onError = { error ->
            binding.errorCont.visible()
            onError(error)
        },
        onSuccess = { data ->
            root.children
                .filter { it.id != R.id.progress_bar && it.id != R.id.error_cont }
                .forEach { it.visible() }
            onSuccess(data)
        }
    )
}

fun <B : ViewBinding> BaseFragment<B>.onTryAgainListener(
    root: View,
    onTryAgainAction: () -> Unit,
) {
    root.findViewById<Button>(R.id.btn_try_again).setOnClickListener { onTryAgainAction() }
}