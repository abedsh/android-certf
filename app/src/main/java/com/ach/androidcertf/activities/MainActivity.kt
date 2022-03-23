package com.ach.androidcertf.activities

import android.os.Bundle
import com.ach.androidcertf.fragments.FragmentList
import com.ach.androidcertf.models.SectionBean
import com.ach.androidcertf.models.SectionBeanResponse
import com.google.gson.Gson
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.ach.androidcertf.R
import com.ach.androidcertf.utils.AppUtils
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        // test commit
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) { // the ? is to allow a null saveInstanceState https://kotlinlang.org/docs/reference/null-safety.html
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {


        val gson = Gson()
        var response: SectionBeanResponse? = null

        try {
            // the sections objects are in json to facilitate modifying them
            val jsonStr = this.getString(R.string.sectionsJson)
            response = gson.fromJson(jsonStr, SectionBeanResponse::class.java)

            if (response != null) {
                toNextFragmentList(response.sectionBeans)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Must be safe
        }
    }


    fun toNextFragmentList(list: MutableList<SectionBean>) {
        var fragment: FragmentList = FragmentList.newInstance(list)


        supportFragmentManager.beginTransaction()
            .replace(R.id.root_view, fragment, fragment.javaClass.simpleName)
            .addToBackStack(null).commit()

    }

    fun toNextActivity(activityName: String) {

        try {
            val activity = Class.forName(AppUtils.getAppPackageName(this).plus(".activities.").plus(activityName))
            val intent = Intent(this, activity)
            startActivity(intent)
        } catch (ignored: Exception) {
            ignored.printStackTrace()
        }


    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 1) {  // to disable popping the initial fragment at count 1
            super.onBackPressed()
        }


    }
}
