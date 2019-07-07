package com.ach.androidcertf.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.ach.androidcertf.R
import com.ach.androidcertf.adapters.SectionsAdapter
import com.ach.androidcertf.models.SectionBean

class SectionsActivity : AppCompatActivity() {

    var prodAdapter: SectionsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) { // the ? is to allow a null saveInstanceState https://kotlinlang.org/docs/reference/null-safety.html
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var sectionsList: ListView = this.findViewById(R.id.activity_main_sections)
        setupSections(sectionsList)
    }


    private fun setupSections(sectionsList: ListView) {
//        val prodAdapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.sections)
//        )

        var sectionsAdapter = SectionsAdapter(applicationContext, getData())

        sectionsList.adapter = sectionsAdapter
        sectionsList.setOnItemClickListener { parent, view, position, id ->
            var selectedItem = sectionsList.getItemAtPosition(position) as SectionBean

            if (selectedItem.subList.size > 0) {
                sectionsAdapter = SectionsAdapter(applicationContext, selectedItem.subList)

            } else if (selectedItem.activityName != null && selectedItem.activityName.length > 0) {
                // go to activity
            }

        }
    }

    private fun getData(): ArrayList<SectionBean> {
        var sections: ArrayList<SectionBean> = ArrayList()

        for (item in resources.getStringArray(R.array.sections)) {
            sections.add(SectionBean(item, ""))

        }


        return sections
    }


}
