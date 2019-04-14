package ginyolith.dddcrss.data.article

import ginyolith.dddcrss.data.article.remote.ArticleRemoteDataSource
import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.repository.ArticleRepository
import io.reactivex.Single

class ArticleRepositoryImpl(private val remote: ArticleRemoteDataSource) : ArticleRepository {
    override fun getArticleList(category: ArticleCategory): Single<List<Article>> {
        return remote.getArticleList(category)
    }
}