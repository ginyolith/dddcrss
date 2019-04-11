package ginyolith.dddcrss.domain.usecase

import com.github.javafaker.Faker
import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import io.reactivex.Single
import java.net.URL
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

class FakeGetArticleListImpl : GetArticleList {
    private val faker = Faker(Locale("ja_JP"))

    override fun execute(category: ArticleCategory): Single<List<Article>> {
        return Single.create {emitter ->
            (1..Random.nextInt(40..100))
                .map {
                    // ダミーの記事インスタンス生成
                    Article(
                        thumbnailUrl = URL("https://picsum.photos/500/?image=${Random.nextInt(100)}"),
                        title = faker.medical().medicineName(),
                        url = URL("https://www.google.com/?hl=ja")
                    )
                }
                .let { emitter.onSuccess(it) }
        }
    }
}