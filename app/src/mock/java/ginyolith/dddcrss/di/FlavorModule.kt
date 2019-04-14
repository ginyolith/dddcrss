package ginyolith.dddcrss.di

import dagger.Module
import dagger.Provides
import ginyolith.dddcrss.domain.repository.ArticleRepository
import ginyolith.dddcrss.domain.usecase.FakeGetArticleListImpl
import ginyolith.dddcrss.domain.usecase.FakeGetCategoryListImpl
import ginyolith.dddcrss.domain.usecase.GetArticleList
import ginyolith.dddcrss.domain.usecase.GetCategoryList
import javax.inject.Singleton

@Module
class FlavorModule : FlavorModuleIF {

    @Provides
    @Singleton
    override fun provideGetCategoryList(): GetCategoryList {
        return FakeGetCategoryListImpl()
    }

    @Provides
    @Singleton
    override fun provideGetArticleList(repo: ArticleRepository): GetArticleList {
        return FakeGetArticleListImpl()
    }

}