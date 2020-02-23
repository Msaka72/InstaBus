package com.example.instabus

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment


class ListStationActivity : Fragment () {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_station, container, false)
    }
}

private class MyAdapter : BaseAdapter() {
    // override other abstract methods here
    override fun getView(
        position: Int,
        convertView: View,
        container: ViewGroup
    ): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.list_item, container, false)
        }
        (convertView.findViewById<View>(R.id.text1) as TextView)
            .setText(getItem(position))
        return convertView
    }
}