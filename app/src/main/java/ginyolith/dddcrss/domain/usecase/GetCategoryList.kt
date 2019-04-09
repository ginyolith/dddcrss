package ginyolith.dddcrss.domain.usecase

import ginyolith.dddcrss.domain.model.ArticleCategory

/** 記事カテゴリ一覧を取得する */
interface GetCategoryList {
    fun execute() : List<ArticleCategory>
}