package ginyolith.dddcrss.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ginyolith.dddcrss.RssApplication
import ginyolith.dddcrss.data.DataModule
import ginyolith.dddcrss.presentation.ArticleListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    FlavorModule::class,
    DataModule::class
])
interface AppComponent : AndroidInjector<RssApplication> {

    fun inject(articleListFragment: ArticleListFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}