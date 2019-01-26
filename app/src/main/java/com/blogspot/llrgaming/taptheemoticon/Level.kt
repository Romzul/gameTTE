package com.blogspot.llrgaming.taptheemoticon

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class Level : AppCompatActivity() {
	
	lateinit var btnslow: Button
	lateinit var btnmedium: Button
	lateinit var btnfast: Button
	lateinit var btnextreme: Button
	lateinit var sound: MediaPlayer
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_level)
		
		sound = MediaPlayer.create(this@Level, R.raw.menu)
		sound.start()
		
		
		btnslow = findViewById(R.id.slow)
		btnslow.setOnClickListener {
			startActivity(Intent(this, Slow::class.java))
			sound.stop()
		}
		
		btnmedium = findViewById(R.id.medium)
		btnmedium.setOnClickListener {
			startActivity(Intent(this, Medium::class.java))
			sound.stop()
		}
		
		btnfast = findViewById(R.id.fast)
		btnfast.setOnClickListener {
			startActivity(Intent(this, Fast::class.java))
			sound.stop()
		}
		
		btnextreme = findViewById(R.id.extreme)
		btnextreme.setOnClickListener {
			startActivity(Intent(this, Extreme::class.java))
			sound.stop()
		}
		
	}
}
