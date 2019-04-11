package ginyolith.dddcrss.di

import dagger.Module
import dagger.Provides
import ginyolith.dddcrss.domain.usecase.FakeGetArticleListImpl
import ginyolith.dddcrss.domain.usecase.GetArticleList
import javax.inject.Singleton

@Module
class FlavorModule : FlavorModuleIF {

    @Provides
    @Singleton
    override fun provideGetArticleList(): GetArticleList {
        return FakeGetArticleListImpl()
    }

}