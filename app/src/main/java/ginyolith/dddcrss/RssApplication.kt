package ginyolith.dddcrss

import android.app.Application
import androidx.multidex.MultiDexApplication
import ginyolith.dddcrss.di.DaggerAppComponent

class RssApplication :MultiDexApplication() {
    val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }
}