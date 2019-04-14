package ginyolith.dddcrss.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import ginyolith.dddcrss.R
import ginyolith.dddcrss.databinding.LayoutLoadingAndErrorBinding
import ginyolith.dddcrss.presentation.common.UiState

class LoadingAndErrorLayout @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val binding : LayoutLoadingAndErrorBinding
            = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_loading_and_error, this, true)

    var onRetry : (() -> Boolean)? = null
        set(value) {
            field = value
            binding.retryButton.visibility = if (value == null) View.GONE else View.VISIBLE
        }

    companion object BindingAdapters {
        @BindingAdapter("uiState")
        @JvmStatic fun setUiState(loadingAndErrorView: LoadingAndErrorLayout, uiState: UiState?) {
            uiState?.let {
                loadingAndErrorView.binding.uiState = it
            }
        }

        @BindingAdapter("onRetry")
        @JvmStatic fun setOnRetry(loadingAndErrorView: LoadingAndErrorLayout, onClick: () -> Boolean) {
            loadingAndErrorView.binding.onRetry = View.OnClickListener {
                loadingAndErrorView.onRetry = onClick
                onClick()
            }
        }
    }
}