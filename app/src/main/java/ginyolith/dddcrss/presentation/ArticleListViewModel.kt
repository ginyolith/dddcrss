package ginyolith.dddcrss.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider
import ginyolith.dddcrss.domain.model.Article
import ginyolith.dddcrss.domain.model.ArticleCategory
import ginyolith.dddcrss.domain.usecase.GetArticleList
import ginyolith.dddcrss.presentation.common.SingleLiveEvent
import ginyolith.dddcrss.presentation.common.UiState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.IllegalStateException

class ArticleListViewModel(
    getArticleList : GetArticleList,
    category : ArticleCategory?) : ViewModel() {

    val uiState = SingleLiveEvent<UiState>()

    val articleList : LiveData<List<Article>>
        get() = _articleList

    private val _articleList = MutableLiveData<List<Article>>()

    private val disposables = CompositeDisposable()


    init {
        if (category == null) {
            // カテゴリが取得できない場合エラー
            uiState.value = UiState.Error(IllegalStateException("記事カテゴリが取得できません"))
        } else {

            // 記事一覧の読み込みを行う
            uiState.value = UiState.Loading

            getArticleList.execute(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        _articleList.value = it
                        uiState.value = UiState.Display
                    },
                    onError = {
                        Timber.e(it)
                        uiState.value = UiState.Error(it)
                    }
                )
                .addTo(disposables)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    class Factory(
        private val getArticleList : GetArticleList,
        private val category : ArticleCategory?) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ArticleListViewModel(getArticleList, category) as T
    }
}
