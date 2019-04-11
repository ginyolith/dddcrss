package ginyolith.dddcrss.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import ginyolith.dddcrss.R
import ginyolith.dddcrss.domain.model.ArticleCategory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewPagerAdapter = object: FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment {
            // タブ位置に基づいて、記事カテゴリを取得
            val category = ArticleCategory.values()[position]

            return ArticleListFragment.newInstance(category)
        }

        override fun getCount(): Int = ArticleCategory.values().size

        override fun getPageTitle(position: Int): CharSequence? {
            return ArticleCategory.values()[position].title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.let {
            it.adapter = viewPagerAdapter
            it.offscreenPageLimit = 2
        }

        tabLayout.setupWithViewPager(viewPager)
    }
}
