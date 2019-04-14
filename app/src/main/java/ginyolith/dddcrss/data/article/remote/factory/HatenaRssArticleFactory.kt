package ginyolith.dddcrss.data.article.remote.factory

import com.rometools.rome.feed.synd.SyndEntry
import ginyolith.dddcrss.domain.model.Article
import java.net.URL

/** はてなのRSSをドメインモデルとして解釈するためのFactory */
class HatenaRssArticleFactory : ArticleFactory() {
    override fun create(entry: SyndEntry): Article {
        return Article(
            title = entry.title,
            thumbnailUrl = entry.foreignMarkup.first { it.name == "imageurl" }.text.let { URL(it) },
            url = URL(entry.uri))
    }

}