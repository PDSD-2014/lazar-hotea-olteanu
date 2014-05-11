package com.example.proiectpdsd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	void SetButtonListener() {
		((Button)findViewById(R.id.startGame)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(),PlayActivity.class);
				startActivity(intent);
						
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SetButtonListener();
		final ProgressBar pb =(ProgressBar)findViewById(R.id.progressBar1);
		Thread th = new Thread(new Runnable() {
			int i;
			@Override
			public void run() {
				pb.setProgress(i++);
				
			}
		});
		th.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
