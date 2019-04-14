package ginyolith.dddcrss.data.article.remote.factory

import ginyolith.dddcrss.domain.model.ArticleCategory
import javax.inject.Inject

/** ドメインモデル、エンティティなど複数の要素が登場する場合に処理を行う、状態を持たないクラス */
class ArticleTranslateDomainService @Inject constructor() {
    fun resolveFactory(category: ArticleCategory) : ArticleFactory {
        return when(category) {
            // 今は全てはてなのフォーマットのため全てはてなのRSSとして解釈する
            ArticleCategory.GENERAL,
            ArticleCategory.LIFE,
            ArticleCategory.WORLD,
            ArticleCategory.POLITICS_ECONOMY -> HatenaRssArticleFactory()
        }
    }
}