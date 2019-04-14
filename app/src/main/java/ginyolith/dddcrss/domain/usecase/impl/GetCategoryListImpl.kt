package ginyolith.dddcrss.domain.usecase.impl

import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.usecase.GetCategoryList

class GetCategoryListImpl : GetCategoryList {
    override fun execute(): List<ArticleCategory> {
        return ArticleCategory.values().toList()
    }
}