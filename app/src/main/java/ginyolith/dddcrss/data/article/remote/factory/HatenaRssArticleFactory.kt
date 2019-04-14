package ginyolith.dddcrss.data.article.remote.factory

import com.rometools.rome.feed.synd.SyndEntry
import ginyolith.dddcrss.domain.model.Article
import java.net.URL

/** はてなのRSSをドメインモデルとして解釈するためのFactory */
class HatenaRssArticleFactory : ArticleFactory() {
    override fun create(entry: SyndEntry): Article {
        val url = entry.foreignMarkup.firstOrNull { it.name == "imageurl" }?.text


        return Article(
            title = entry.title,
            thumbnailUrl = url?.let { URL(it) },
            url = URL(entry.uri),
            description = entry.description.value,
            pubDate = entry.publishedDate
        )
    }

}