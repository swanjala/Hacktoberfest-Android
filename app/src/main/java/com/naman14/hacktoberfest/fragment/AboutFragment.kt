package com.naman14.hacktoberfest.fragment

import android.app.Fragment
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.naman14.hacktoberfest.R
import com.naman14.hacktoberfest.utils.Utils
import java.util.zip.Inflater

class AboutFragment : Fragment() {

    @BindView(R.id.tv_website)
    lateinit var tv_website:TextView

    override fun onCreateView(inflater:LayoutInflater?, container:ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootView:View = inflater!!.inflate(R.layout.fragment_about,
                container,false)
        ButterKnife.bind(this, rootView)
       // tv_website.paintFlags(Paint.UNDERLINE_TEXT_FLAG)
        return rootView

    }

    @OnClick
    fun websiteClicked() {
        Utils.openChromeCustomTab(activity, "https://hacktoberfest.digitalocean.com")

    }
    @OnClick
    fun viewGithub() {
        Utils.openChromeCustomTab(activity,"https://github.com/naman14/Hacktoberfest-Android")

    }
    @OnClick
    fun signUp() {
        Utils.openChromeCustomTab(activity,"https://hacktoberfest.digitalocean.com/sign_up/register")
    }
}


