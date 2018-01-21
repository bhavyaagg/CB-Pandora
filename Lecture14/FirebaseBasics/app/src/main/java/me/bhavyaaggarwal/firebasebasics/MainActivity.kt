package me.bhavyaaggarwal.firebasebasics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        val clickEvent: (View) -> Unit = {
            with(Bundle()) {
                putString("button", (it as Button).text.toString())
                firebaseAnalytics.logEvent(
                        "click",
                        this
                )
            }
        }

        btnLeft.setOnClickListener(clickEvent)

        btnRight.setOnClickListener(clickEvent)

    }
}
