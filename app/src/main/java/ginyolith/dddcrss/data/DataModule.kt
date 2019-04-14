package ginyolith.dddcrss.data

import dagger.Module
import dagger.Provides
import ginyolith.dddcrss.data.article.ArticleRepositoryImpl
import ginyolith.dddcrss.data.article.remote.ArticleRemoteDataSource
import ginyolith.dddcrss.domain.repository.ArticleRepository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideArticleRepository(): ArticleRepository {
        return ArticleRepositoryImpl(ArticleRemoteDataSource())
    }
}