package ginyolith.dddcrss

import androidx.multidex.MultiDexApplication
import ginyolith.dddcrss.di.DaggerAppComponent
import timber.log.Timber

class RssApplication :MultiDexApplication() {
    val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()

        // Timberの初期化
        Timber.plant(Timber.DebugTree())
    }
}