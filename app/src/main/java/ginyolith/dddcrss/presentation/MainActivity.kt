package ginyolith.dddcrss.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import ginyolith.dddcrss.R
import ginyolith.dddcrss.RssApplication
import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.usecase.GetCategoryList
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getArticleCategory : GetCategoryList

    private val viewPagerAdapter by lazy {
        object: FragmentPagerAdapter(supportFragmentManager) {

            val itemList = getArticleCategory.execute()

            override fun getItem(position: Int): Fragment {
                // タブ位置に基づいて、記事カテゴリを取得
                return ArticleListFragment.newInstance(itemList[position])
            }

            override fun getCount(): Int = ArticleCategory.values().size

            override fun getPageTitle(position: Int): CharSequence? {
                return ArticleCategory.values()[position].title
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as RssApplication).appComponent.inject(this)

        viewPager.let {
            it.adapter = viewPagerAdapter
            it.offscreenPageLimit = 2
        }

        tabLayout.setupWithViewPager(viewPager)
    }
}
