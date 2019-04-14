package ginyolith.dddcrss.data.article.remote

import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import io.reactivex.Single

class ArticleRemoteDataSource {
    fun getArticleList(category: ArticleCategory): Single<List<Article>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}