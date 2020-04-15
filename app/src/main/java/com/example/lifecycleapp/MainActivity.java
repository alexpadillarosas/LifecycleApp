package com.example.lifecycleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//https://developer.android.com/guide/components/activities/activity-lifecycle
public class MainActivity extends AppCompatActivity {

    TextView nameTextView;
    Button whoIAmButton;


    /**
     * Called when the activity is first created. This is where you should do all of your normal
     * static set up: create views, bind data to lists, etc. This method also provides you with a
     * Bundle containing the activity's previously frozen state, if there was one. Always followed
     * by onStart().
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.nameTextView);
        whoIAmButton = findViewById(R.id.whoIAmButton);

        whoIAmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTextView.setText("King Kong");
            }
        });
        Log.i( Constants.TAG ,"onCreate method called");
    }

    /**
     * Called when the activity is becoming visible to the user, as the app PREPARES for the activity
     * to enter the foreground and become interactive in the next method (onResume). For example,
     * this method is where the app initializes the code that maintains the UI.
     * the activity does not stay resident in the Started state. Once this callback finishes, the
     * activity enters the Resumed state, and the system invokes the onResume() method.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Constants.TAG, "onStart method called");
    }

    /**
     * Here the app comes to the foreground and becomes interactive!.
     * The app stays in this state until something happens to take focus away from the app.
     * Such an event might be, for instance, receiving a phone call, the user’s navigating to
     * another activity, or the device screen’s turning off.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "onResume method called");
    }

    /**
     * The system calls this method as the first indication that the user is leaving your activity
     * (though it does not always mean the activity is being destroyed); it indicates that the
     * activity is no longer in the foreground (though it may still be visible if the user is in
     * multi-window mode)
     * You can also use the onPause() method to release system resources, handles to sensors
     * (like GPS), or any resources that may affect battery life while your activity is paused and
     * the user does not need them.
     *
     * Possible causes of the pause state
     *
     * Some event interrupts app execution, as described in the onResume() section. This is the most common case.
     *
     * In Android 7.0 (API level 24) or higher, multiple apps run in multi-window mode. Because only
     * one of the apps (windows) has focus at any time, the system pauses all of the other apps.
     *
     * A new, semi-transparent activity (such as a dialog) opens. As long as the activity is still
     * partially visible but not in focus, it remains paused.
     *
     * it's the The counterpart to onResume(). When activity B is launched in front of activity A,
     * this callback will be invoked on A. B will not be created until A's onPause() returns, so
     * be sure to not do anything lengthy here.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "onPause method called");
    }

    /**
     * Called when you are no longer visible to the user. You will next receive either onRestart(),
     * onDestroy(), or nothing, depending on later user activity. Note that this method may never
     * be called, in low memory situations where the system does not have enough memory to keep
     * your activity's process running after its onPause() method is called.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "onStop method called");
    }

    /**
     * Called after your activity has been stopped, prior to it being started again. Always followed by onStart()
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Constants.TAG, "onRestart method called");
    }

    /**
     * The final call you receive before your activity is destroyed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "onDestroy method called");
    }
    //onSaveInstanceState() This method gets called before onStop()
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(Constants.NAME, nameTextView.getText().toString());

        super.onSaveInstanceState(outState);
    }
    //onRestoreInstanceState() method. This is called after onStart() and before onResume()
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nameTextView.setText(savedInstanceState.getString(Constants.NAME));

    }

    //to review later, and to save complex data
    //https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090

    //https://medium.com/hootsuite-engineering/handling-orientation-changes-on-android-41a6b62cb43f
}
