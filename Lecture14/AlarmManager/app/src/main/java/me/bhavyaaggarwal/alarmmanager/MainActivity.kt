package me.bhavyaaggarwal.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(
                this,
                123,
                i,
                PendingIntent.FLAG_ONE_SHOT
        )

        val am: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.setRepeating(
                AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 1 * 60 * 1000,
                60 * 1000,
                pi
        )
    }
}
