package com.example.proiectpdsd;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class PlayActivity extends Activity {
	static InterfaceHandler ih;
	static ClientPlay clientplay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		
		ih = new InterfaceHandler(this);
		ih.InitInterface();
		ih.SetGameInfo(Client.gInfoInitial);
	//	clientplay = new ClientPlay();
	//	clientplay.start();

		
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
