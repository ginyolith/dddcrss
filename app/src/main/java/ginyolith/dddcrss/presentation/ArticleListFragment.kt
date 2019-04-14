package ginyolith.dddcrss.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ginyolith.dddcrss.R
import ginyolith.dddcrss.RssApplication
import ginyolith.dddcrss.databinding.ArticleListFragmentBinding
import ginyolith.dddcrss.databinding.ItemArticleListBinding
import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.usecase.GetArticleList
import javax.inject.Inject

class ArticleListFragment : Fragment() {

    companion object {

        private const val TAG_ARTICLE_CATEGORY = "TAG_ARTICLE_CATEGORY"

        fun newInstance(category: ArticleCategory)
                = ArticleListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(TAG_ARTICLE_CATEGORY, category)
            arguments = bundle
        }
    }

    /** このフラグメントで表示する記事カテゴリ */
    private val category : ArticleCategory? by lazy {
        arguments?.getSerializable(TAG_ARTICLE_CATEGORY)?.let {
            it as ArticleCategory
        }
    }

    val viewModel: ArticleListViewModel by lazy {
        ViewModelProviders.of(this, factory).get(ArticleListViewModel::class.java)
    }

    private val factory : ArticleListViewModel.Factory by lazy {
        ArticleListViewModel.Factory(getArticleList, category)
    }

    @Inject
    lateinit var getArticleList : GetArticleList

    lateinit var binding : ArticleListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.article_list_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (requireActivity().application as RssApplication).appComponent.inject(this)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.articleListView.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())

            viewModel.articleList.observe(viewLifecycleOwner, Observer {
                adapter.notifyDataSetChanged()
            })
        }

    }

    class BindingHolder(val binding : ItemArticleListBinding) : RecyclerView.ViewHolder(binding.root)

    private val adapter : RecyclerView.Adapter<BindingHolder> by lazy {
        object : RecyclerView.Adapter<BindingHolder>() {

            val itemList
                get() = viewModel.articleList.value ?: emptyList()

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
                return BindingHolder(
                    DataBindingUtil.inflate(layoutInflater, R.layout.item_article_list, parent, false)
                )
            }

            override fun getItemCount(): Int = itemList.size

            override fun onBindViewHolder(holder: BindingHolder, position: Int) {
                itemList[position].let {
                    holder.binding.parent.setOnClickListener {_ ->
                        val tabsIntent = CustomTabsIntent.Builder()
                            .setShowTitle(true)
                            .enableUrlBarHiding().build()
                        tabsIntent.launchUrl(requireActivity(), Uri.parse(it.url.toString()))
                    }

                    // タイトルを設定
                    holder.binding.titleTextView.text = it.title

                    // 画像URLの読み込み
                    it.thumbnailUrl?.let { url ->
                        Glide
                            .with(requireContext())
                            .load(url.toString())
                            .into(holder.binding.thumbnailImageView)
                    }

                }
            }
        }
    }

}
