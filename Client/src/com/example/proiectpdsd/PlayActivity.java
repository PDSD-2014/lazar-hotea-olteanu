package com.example.proiectpdsd;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class PlayActivity extends Activity {
	InterfaceHandler ih = new InterfaceHandler(this); ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("dwadaw", "dwadwaad");
		
		ih.SetCountDownTimer();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
