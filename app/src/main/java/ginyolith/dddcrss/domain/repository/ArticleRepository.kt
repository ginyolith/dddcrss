package ginyolith.dddcrss.domain.repository

import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import io.reactivex.Single

interface ArticleRepository {
    fun getArticleList(category: ArticleCategory): Single<List<Article>>
}