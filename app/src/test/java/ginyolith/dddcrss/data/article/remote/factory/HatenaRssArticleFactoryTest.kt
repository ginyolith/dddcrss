package ginyolith.dddcrss.data.article.remote.factory

import ginyolith.dddcrss.data.article.remote.ArticleFetchService
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.Test
import java.net.URL

class HatenaRssArticleFactoryTest {

    val factory = HatenaRssArticleFactory()

    val service = ArticleFetchService()

    @Test
    fun create() {
        val result = service.fetch(URL("http://b.hatena.ne.jp/hotentry.rss")).blockingGet()

        assertThatCode {
            val model = factory.create(result.entries[0])
            println(model)
        }
            .doesNotThrowAnyException()

    }
}