package ginyolith.dddcrss.data.article.remote

import ginyolith.dddcrss.data.article.remote.factory.ArticleTranslateDomainService
import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable
import javax.inject.Inject

class ArticleRemoteDataSource @Inject constructor(
    private val service: ArticleFetchService,
    private val translateService : ArticleTranslateDomainService) {

    fun getArticleList(category: ArticleCategory): Single<List<Article>> {
        return service
            .fetch(category.rssUrl)
            .flatMapObservable { it.entries.toObservable() }
            .map { translateService.resolveFactory(category).create(it) }
            .toList()
    }
}