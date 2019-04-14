package ginyolith.dddcrss.data.article.remote

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.net.URL

class ArticleFetchServiceTest {

    val service = ArticleFetchService()

    @Test
    fun fetch() {
        val result = service.fetch(URL("http://b.hatena.ne.jp/hotentry.rss")).blockingGet()

        assertThat(result)
            .`as`("正常に通信が成功し、RSSの値が取得できている")
            .isNotNull

        assertThat(result.title)
            .`as`("正常な値が取得できている")
            .isEqualTo("はてなブックマーク - 人気エントリー - 総合")
    }
}