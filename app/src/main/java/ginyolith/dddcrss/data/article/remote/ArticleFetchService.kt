package ginyolith.dddcrss.data.article.remote

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.reactivex.Single
import java.net.URL
import javax.inject.Inject

/** HTTP通信を実際に行い、RSSを取得する責務のクラス */
class ArticleFetchService @Inject constructor() {

    fun fetch(url: URL): Single<SyndFeed> {
        return Single.create {
            it.onSuccess(SyndFeedInput().build(XmlReader(url)))
        }
    }
}
