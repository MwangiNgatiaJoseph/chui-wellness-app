package com.zariel.chui_wellnessapp20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

//    A variable to store the ads once it loads
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        MobileAds.initialize(this)
        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)




//display the ad
        loadInterstitialAd()




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Healthy recipe intent
//        finding the view from the layout using their ids

//        create a variable to store the buttons

        val recipe=findViewById<Button>(R.id.recipes)

//        set on  click listener

        recipe.setOnClickListener {
//            writing our intents

             val recipeIntent= Intent(applicationContext, HealthyRecipe::class.java)
            startActivity(recipeIntent)
//
            showInterstitialAd()

        }

//        nutrition intent

        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {

            val nutritionIntent= Intent(applicationContext,NutritionAdvice::class.java)
            startActivity(nutritionIntent)

//
            showInterstitialAd()
        }

//        meditation intent

        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {

            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
        }
//        weekly goals intent

        val goals=findViewById<Button>(R.id.goals)

        goals.setOnClickListener {

            val goalsIntent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(goalsIntent)

        }

//        check progress intent

        val progress=findViewById<Button>(R.id.progress)

        progress.setOnClickListener {

            val checkProgressIntent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(checkProgressIntent)
        }
//        exercise intent

        val exercise=findViewById<Button>(R.id.exercise)

        exercise.setOnClickListener {

            val exerciseIntent= Intent(applicationContext, Exercise::class.java)
            startActivity(exerciseIntent)
        }

//        hydration intent

        val hydration=findViewById<Button>(R.id.hydration)

        hydration.setOnClickListener {

            val hydrationIntent= Intent(applicationContext, Hydration::class.java)
            startActivity(hydrationIntent)

        }

//        motivation intent

        val motivation=findViewById<Button>(R.id.motivation)

        motivation.setOnClickListener {

            val motivationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(motivationIntent)

        }

//


    }

    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }


}