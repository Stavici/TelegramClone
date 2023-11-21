package com.example.telegramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.telegramclone.databinding.ActivityMainBinding
import com.example.telegramclone.ui.fragments.ChatsListFragment
import com.example.telegramclone.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainAppDrawer: AppDrawer
    private lateinit var mainToolBar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }
    override fun onStart() {
        super.onStart()
        initFileds()
        initFunc()
    }
    private fun initFunc() {
        setSupportActionBar(mainToolBar)
        mainAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsListFragment()).commit()
    }
    private fun initFileds() {
        mainToolBar = mainBinding.mainToolBar
        mainAppDrawer = AppDrawer(this, mainToolBar)
    }
}