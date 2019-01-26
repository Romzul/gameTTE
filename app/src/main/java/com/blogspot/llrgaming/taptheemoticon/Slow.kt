package com.blogspot.llrgaming.taptheemoticon

import android.app.AlertDialog
import android.content.DialogInterface
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_slow.*
import kotlin.random.Random

class Slow : AppCompatActivity() {
	
	var score : Int = 0
	var imageArray = ArrayList<ImageView>()
	var handler : Handler = Handler()
	var runnable : Runnable = Runnable {  }
	lateinit var sound : MediaPlayer
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_slow)
		
		sound = MediaPlayer.create(this@Slow, R.raw.medium)
		sound.start()
		
		score = 0
		
		imageArray = arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)
		
		
		hideImages()
		
		
		
		
		object : CountDownTimer(20000,1000){
			override fun onFinish() {
				timerText.text = "Time's Off"
				showDialog()
				sound.stop()
				handler.removeCallbacks(runnable)
				for (image in imageArray){
					image.visibility = View.INVISIBLE
				}
			}
			
			override fun onTick(p0: Long) {
				timerText.text = "Timer : " + p0 / 1000
			}
			
		}.start()
		
	}
	
	fun hideImages(){
		
		runnable = object : Runnable {
			
			override fun run() {
				
				for (image in imageArray){
					image.visibility = View.INVISIBLE
				}
				
				val random = Random
				val index = random.nextInt(8 - 0)
				imageArray[index].visibility = View.VISIBLE
				
				handler.postDelayed(runnable,700)
				
			}
			
		}
		handler.post(runnable)
		
	}
	
	
	
	fun increaseScore(view: View){
		score++
		
		scoreText.text = "Score : " + score
	}
	
	fun showDialog() {
		val alertDialogBuilder = AlertDialog.Builder(
			this
		)
		// set pesan dari dialog
		alertDialogBuilder
			.setTitle("Waktu Habis")
			.setMessage("Score Anda : "+score)
			.setPositiveButton("OK") { dialog, id ->
				// jika tombol diklik, maka akan menutup activity ini
				sound.stop()
				this.finish()
			}
		val alertDialog = alertDialogBuilder.create()
		alertDialog.show()
	}
	
}
