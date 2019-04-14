package ginyolith.dddcrss.data.article.remote

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.reactivex.Single
import java.net.URL

class ArticleFetchService {

    fun fetch(url: URL): Single<SyndFeed> {
        return Single.create {
            it.onSuccess(SyndFeedInput().build(XmlReader(url)))
        }
    }
}
