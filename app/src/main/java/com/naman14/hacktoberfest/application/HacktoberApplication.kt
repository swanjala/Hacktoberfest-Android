package com.naman14.hacktoberfest.application

import android.app.Application
import com.naman14.hacktoberfest.dependencies.AppComponent
import com.naman14.hacktoberfest.dependencies.AppModule

class HacktoberApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()
        appComponent = initDagger(this)
    }
    private fun initDagger(application:HacktoberApplication):AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(application))
                    .build()

}
