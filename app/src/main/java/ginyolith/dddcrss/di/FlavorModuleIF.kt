package ginyolith.dddcrss.di

import ginyolith.dddcrss.domain.usecase.GetArticleList

interface FlavorModuleIF {
    fun provideGetArticleList() : GetArticleList
}