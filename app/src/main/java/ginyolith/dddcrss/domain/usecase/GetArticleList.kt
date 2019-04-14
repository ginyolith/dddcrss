package ginyolith.dddcrss.domain.usecase

import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import io.reactivex.Single

/** 記事一覧を取得する */
interface GetArticleList {
    fun execute(category : ArticleCategory) : Single<List<Article>>
}