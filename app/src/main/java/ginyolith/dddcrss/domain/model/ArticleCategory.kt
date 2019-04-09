package ginyolith.dddcrss.domain.model

import java.net.URL

/** 記事カテゴリ */
enum class ArticleCategory(val title : String, val rssUrl : URL) {
    GENERAL("総合", URL("http://b.hatena.ne.jp/hotentry.rss")),
    LIFE("暮らし", URL("http://b.hatena.ne.jp/hotentry/life.rss")),
    WORLD("世の中", URL("http://b.hatena.ne.jp/hotentry/social.rss")),
    POLITICS_ECONOMY("政治と経済", URL("http://b.hatena.ne.jp/hotentry/economics.rss"))
}