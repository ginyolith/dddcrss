package ginyolith.dddcrss.domain.usecase.impl

import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.repository.ArticleRepository
import ginyolith.dddcrss.domain.usecase.GetArticleList
import io.reactivex.Single

class GetArticleListImpl(private val repo: ArticleRepository) : GetArticleList {
    override fun execute(category: ArticleCategory): Single<List<Article>> {
        return repo.getArticleList(category)
    }
}