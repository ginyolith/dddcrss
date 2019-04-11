package ginyolith.dddcrss.presentation.common

import android.view.View

sealed class UiState {
    object Display : UiState()

    object Loading : UiState()

    data class Error(val t : Throwable) : UiState()

    val contentVisibility by lazy {
        when(this) {
            is Loading -> View.GONE
            is Display -> View.VISIBLE
            is Error -> View.GONE
        }
    }
}