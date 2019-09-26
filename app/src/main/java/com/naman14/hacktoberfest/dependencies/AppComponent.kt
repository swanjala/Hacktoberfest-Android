package com.naman14.hacktoberfest.dependencies

import com.naman14.hacktoberfest.application.HacktoberApplication

interface AppComponent {

    fun inject(target:HacktoberApplication)

}