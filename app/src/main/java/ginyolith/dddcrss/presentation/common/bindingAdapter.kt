package ginyolith.dddcrss.presentation.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("android:text")
fun TextView.setDateText(date: Date?) {
    date?.let {
        // 現時点でのロケールに基づいて、時刻の表示テキストを設定
        val locale = context.resources.configuration.locale
        this.text = SimpleDateFormat("yyyy/MM/dd hh:mm:ss", locale).format(it)
    }
}

@BindingAdapter("android:src")
fun ImageView.loadUrl(url: URL?) {
    url?.let {
        // 画像URLの読み込み
        Glide
            .with(this)
            .load(url.toString())
            .into(this)
    }
}