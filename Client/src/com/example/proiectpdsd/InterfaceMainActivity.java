package com.example.proiectpdsd;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class InterfaceMainActivity {
	Activity activity;
	Thread thPB;
	public InterfaceMainActivity(Activity activity) {
		this.activity = activity;
	}
	public void SetProgressBar() {
		final ProgressBar pb =(ProgressBar)activity.findViewById(R.id.progressBar1);
		pb.setVisibility(View.VISIBLE);
		thPB = new Thread(new Runnable() {
			int i;
			@Override
			public void run() {
					
					pb.setProgress(i++);
				
			}
		});
		thPB.start();
	}
	public void StopPB() {
		final ProgressBar pb =(ProgressBar)activity.findViewById(R.id.progressBar1);
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub

				pb.setVisibility(View.INVISIBLE);
				
			}
		});

		thPB.interrupt();
		
	}
	public void Init() {
		Button startButton = (Button)activity.findViewById(R.id.startGame);
		final ProgressBar pb =(ProgressBar)activity.findViewById(R.id.progressBar1);
		final EditText editText = (EditText)activity.findViewById(R.id.editText1);
		

		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("lemn",editText.getText().toString());
				// TODO Auto-generated method stub
				if (editText.getText().length() != 0) {
					Log.d("lemn","inaitne new client");
					MainActivity.client = new Client();
					Log.d("lemn","dupa new client");
					MainActivity.client.start();
					Log.d("lemn","dupa start");
					SetProgressBar();
					Log.d("lemn","dupa set visible ");
				
				}
			}
		});
	}
	public void SetVisibilityProgressBar(int vis) {
		ProgressBar pb =(ProgressBar)activity.findViewById(R.id.progressBar1);
		pb.setVisibility(vis);
	}
	public String GetUserName() {
		EditText text = (EditText)activity.findViewById(R.id.editText1);
		return text.getText().toString();
	}
	public void StopProgressBar() {
		thPB.interrupt();;
	}
}
