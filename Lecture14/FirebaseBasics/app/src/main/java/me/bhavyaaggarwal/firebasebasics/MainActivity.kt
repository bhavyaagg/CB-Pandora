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

        val leftClickBundle = Bundle()
        leftClickBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "left")

        val rightClickBundle = Bundle()
        rightClickBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "right")

        btnLeft.setOnClickListener({
            firebaseAnalytics.logEvent(
                    FirebaseAnalytics.Event.SELECT_CONTENT,
                    leftClickBundle
            )
        })

        btnRight.setOnClickListener({
            firebaseAnalytics.logEvent(
                    FirebaseAnalytics.Event.SELECT_CONTENT,
                    rightClickBundle
            )
        })

    }
}
