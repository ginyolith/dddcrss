package ginyolith.dddcrss

import androidx.multidex.MultiDexApplication
import ginyolith.dddcrss.di.DaggerAppComponent

class RssApplication :MultiDexApplication() {
    val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }
}