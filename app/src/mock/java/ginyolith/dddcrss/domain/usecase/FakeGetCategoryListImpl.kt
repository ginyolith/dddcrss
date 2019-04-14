package ginyolith.dddcrss.domain.usecase

import ginyolith.dddcrss.domain.model.ArticleCategory

class FakeGetCategoryListImpl : GetCategoryList {
    override fun execute(): List<ArticleCategory> {
        return ArticleCategory.values().toList()
    }
}