package ginyolith.dddcrss.di

import dagger.Module
import dagger.Provides
import ginyolith.dddcrss.domain.repository.ArticleRepository
import ginyolith.dddcrss.domain.usecase.GetArticleList
import ginyolith.dddcrss.domain.usecase.GetCategoryList
import ginyolith.dddcrss.domain.usecase.impl.GetArticleListImpl
import ginyolith.dddcrss.domain.usecase.impl.GetCategoryListImpl
import javax.inject.Singleton

@Module
class FlavorModule : FlavorModuleIF {

    @Provides
    @Singleton
    override fun provideGetCategoryList(): GetCategoryList {
        return GetCategoryListImpl()
    }

    @Provides
    @Singleton
    override fun provideGetArticleList(repo: ArticleRepository): GetArticleList {
        return GetArticleListImpl(repo)
    }

}