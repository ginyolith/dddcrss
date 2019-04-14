package ginyolith.dddcrss.di

import ginyolith.dddcrss.domain.repository.ArticleRepository
import ginyolith.dddcrss.domain.usecase.GetArticleList
import ginyolith.dddcrss.domain.usecase.GetCategoryList

interface FlavorModuleIF {
    fun provideGetCategoryList(): GetCategoryList
    fun provideGetArticleList(repo: ArticleRepository): GetArticleList
}