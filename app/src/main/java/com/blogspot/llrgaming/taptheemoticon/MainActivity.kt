package com.blogspot.llrgaming.taptheemoticon

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
	
	lateinit var btnplay: Button
	lateinit var sound: MediaPlayer
	lateinit var btnexit: Button
	lateinit var btnhelp: Button
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		sound = MediaPlayer.create(this@MainActivity, R.raw.main)
		sound.start()
		
		btnexit = findViewById(R.id.exit)
		btnexit.setOnClickListener {
			this@MainActivity.finish()
			sound.stop()
		}
		
		btnplay = findViewById(R.id.play)
		btnplay.setOnClickListener {
			startActivity(Intent(this, Level::class.java))
			sound.stop()
		}
		
		btnhelp = findViewById(R.id.help)
		btnhelp.setOnClickListener {
			showDialog()
		}
		
	}
	
	fun showDialog() {
		val alertDialogBuilder = AlertDialog.Builder(
			this
		)
		
		// set pesan dari dialog
		alertDialogBuilder
			.setTitle("Help")
			.setMessage("tap each emoticon that appears on the screen, the time you can do it varies depending on the level you choose. each level has a different level of speed")
			.setPositiveButton("OK") { dialog, id ->
			}
		val alertDialog = alertDialogBuilder.create()
		alertDialog.show()
	}
	
}


