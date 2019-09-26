package com.naman14.hacktoberfest.utils

import android.content.Context
import android.util.Property
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator

/**
 * Created by naman on 7/10/17.
 */

object AnimUtils {

    private var fastOutSlowIn: Interpolator? = null
    private var fastOutLinearIn: Interpolator? = null
    private var linearOutSlowIn: Interpolator? = null


    fun getFastOutSlowInInterpolator(context: Context): Interpolator? {
        if (fastOutSlowIn == null) {
            fastOutSlowIn = AnimationUtils.loadInterpolator(context,
                    android.R.interpolator.fast_out_slow_in)
        }
        return fastOutSlowIn
    }

    fun getFastOutLinearInInterpolator(context: Context): Interpolator? {
        if (fastOutLinearIn == null) {
            fastOutLinearIn = AnimationUtils.loadInterpolator(context,
                    android.R.interpolator.fast_out_linear_in)
        }
        return fastOutLinearIn
    }

    fun getLinearOutSlowInInterpolator(context: Context): Interpolator? {
        if (linearOutSlowIn == null) {
            linearOutSlowIn = AnimationUtils.loadInterpolator(context,
                    android.R.interpolator.linear_out_slow_in)
        }
        return linearOutSlowIn
    }

    abstract class IntProperty<T>(name: String) : Property<T, Int>(Int::class.java, name) {

        /**
         * A type-specific override of the [.set] that is faster when dealing
         * with fields of type `int`.
         */
        abstract fun setValue(`object`: T, value: Int)

        override fun set(`object`: T, value: Int?) {
            setValue(`object`, value!!)
        }

    }

}
