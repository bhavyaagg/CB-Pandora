package me.bhavyaaggarwal.firebasebasics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        btnLeft.setOnClickListener({
            val clickBundle = Bundle()
            clickBundle.putString("button", "left")
            firebaseAnalytics.logEvent(
                    "click",
                    clickBundle
            )
        })

        btnRight.setOnClickListener({
            val clickBundle = Bundle()
            clickBundle.putString("button", "right")
            firebaseAnalytics.logEvent(
                    "click",
                    clickBundle
            )
        })

    }
}
