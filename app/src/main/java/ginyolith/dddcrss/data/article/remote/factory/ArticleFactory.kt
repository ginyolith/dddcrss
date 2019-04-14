package ginyolith.dddcrss.data.article.remote.factory

import com.rometools.rome.feed.synd.SyndEntry
import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory

/** 他のフォーマットが増える可能性があるため、 Abstract Factoryでドメインモデルへの変換処理を作成 */
abstract class ArticleFactory {
    abstract fun create(entry : SyndEntry) : Article
}