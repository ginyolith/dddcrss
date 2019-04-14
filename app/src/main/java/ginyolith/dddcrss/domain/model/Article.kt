package ginyolith.dddcrss.domain.model

import java.net.URL

/** 記事情報 */
data class Article(
    /** サムネイルURL */
    val thumbnailUrl: URL?,

    /** 記事タイトル */
    val title : String,

    /** 実際の記事へのURL */
    val url : URL
)