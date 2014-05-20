package com.example.proiectpdsd;

import gameplay.Question;

import java.util.Currency;

import utils.GameInfo;
import utils.MessageType;
import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/*
 * Radical din pi
 */
public class InterfaceHandler {
	public Activity activity;
	int question_counter;
	Button answerSelected;
	Drawable defaultButtonColour;
	CountDownTimer timer;
	String currentAns;
	Boolean canAns;
	public InterfaceHandler(Activity activity) {
		this.activity = activity;
	}
	public void InitInterface() {
	//	Button b;
		Button b = (Button)activity.findViewById(R.id.buttonA);
	
		if(b==null) {
			Log.d("lemn","A");
		}
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonB);
		if(b==null) {
			Log.d("lemn","B");
		}
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonC);
		if(b==null) {
			Log.d("lemn","C");
		}
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonD);
		if(b==null) {
			Log.d("lemn","D");
		}
		AddListenerButton(b);
		defaultButtonColour = b.getBackground();
	
		b = (Button)activity.findViewById(R.id.buttonExitPlay);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.client.stopProcess();
			}
		});
		
	}
	void AddListenerButton( Button b) {
		if(b==null) {
			Log.d("lemn","b e null _________________");
		}
		final int id = b.getId();
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(canAns) {
					StopTimer();
					SetSelectedAnswer(id);
					canAns = false;
				}
				
			}
		});
	}
	public void SetSelectedAnswer(int id) {
		Button b = (Button)activity.findViewById(id);
		Log.d("buttontext", b.getText().toString());
		canAns = false;
		answerSelected = b;
		answerSelected.setBackgroundColor(Color.YELLOW);
		String response = MessageType.QUESTION_ANSWER + b.getText().toString() ;
		MainActivity.client.player.writeMessage(response);
	
	}
	public Button GetSelectedAnswer() {
		return answerSelected;
	}
	public String GetSelectedAnswerString() {
		return answerSelected.getText().toString();
	}
	public void SetQuestion(String str) {
		TextView t = (TextView)activity.findViewById(R.id.titleSmart);
		t.setText(str);
	}
	public void SetAnswerA(String str) {
		Button b = (Button)activity.findViewById(R.id.buttonA);
		b.setText(str);
	}
	public void SetAnswerB(String str) {
		Button b = (Button)activity.findViewById(R.id.buttonB);
		b.setText(str);
	}
	public void SetAnswerC(String str) {
		Button b = (Button)activity.findViewById(R.id.buttonC);
		b.setText(str);
	}
	public void SetAnswerD(String str) {
		Button b = (Button)activity.findViewById(R.id.buttonD);
		b.setText(str);
	}
	
	public void SetMyName(String str) {
		TextView t = (TextView)activity.findViewById(R.id.myname);
		t.setText(str);
	}
	public String GetMyName() {
		TextView t = (TextView)activity.findViewById(R.id.myname);
		return t.getText().toString();
	}
	public void SetOppName(String str) {
		TextView t = (TextView)activity.findViewById(R.id.username);
		t.setText(str);
	}
	public String GetOppName() {
		TextView t = (TextView)activity.findViewById(R.id.myname);
		return t.getText().toString();
	}
	public void SetMyPoints(String str) {
		TextView t = (TextView)activity.findViewById(R.id.mypoints);
		t.setText(str);
	}
	public String GetMyPoints() {
		TextView t = (TextView)activity.findViewById(R.id.mypoints);
		return t.getText().toString();
	}
	public void SetOppPoints(String str) {
		TextView t = (TextView)activity.findViewById(R.id.opppoints);
		t.setText(str);
	}
	public String GetOppPoints() {
		TextView t = (TextView)activity.findViewById(R.id.mypoints);
		return t.getText().toString();
	}
	public void SetQuestionCounter(String str) {
		TextView t = (TextView)activity.findViewById(R.id.question_counter);
		t.setText(str);
	}
	public void SetQuestionValue(String str) {
		TextView t = (TextView)activity.findViewById(R.id.question_value);
		t.setText(str);
	}
	public void SetCountDownTimer() {
		Log.d("dwadwa", "am intrat");
		long start = 15000;
		long interval = 1000;
		if(timer != null) {
			timer.cancel();
		}
		timer = new CountDownTimer(start,interval) {
			//final 
			
			public void onTick(long millisUntilFinished) {
				Log.d(String.valueOf(millisUntilFinished/1000), "da sigur");
				
				((TextView)activity.findViewById(R.id.timer)).setText(String.valueOf(millisUntilFinished/1000));
				
			}
			
		
			public void onFinish() {
				// TODO Auto-generated method stub
				TextView t = (TextView)activity.findViewById(R.id.timer);
				t.setText("");
			}
		}.start();
	}
	public void StopTimer() {
		
activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				timer.cancel();
				TextView t = (TextView)activity.findViewById(R.id.timer);
				t.setText("");
			}
		});

	}
	public void ShowCorrectAnswer() {
		Log.d("dwadwa", "am intrat");
		long start = 4000;
		long interval = 500;
		if(timer != null) {
			timer.cancel();
		}
		timer = new CountDownTimer(start,interval) {
			//final 
			
			public void onTick(long millisUntilFinished) {
				Log.d(String.valueOf(millisUntilFinished/500), "da sigur");
				
				//((TextView)activity.findViewById(R.id.timer)).setText(String.valueOf(millisUntilFinished/1000));
				if((millisUntilFinished / 500) %2 == 0 )
					GetButtonAnswer(currentAns).setBackgroundDrawable(defaultButtonColour);
				else
					GetButtonAnswer(currentAns).setBackgroundColor(Color.GREEN);		
			}
			
		
			public void onFinish() {
				GetButtonAnswer(currentAns).setBackgroundDrawable(defaultButtonColour);
				answerSelected.setBackgroundDrawable(defaultButtonColour);

			}
		}.start();
	}
	Button GetButtonAnswer(String ans) {
		Button b = (Button)activity.findViewById(R.id.buttonA);
		Log.d(b.getText().toString(), currentAns);
		if(b.getText().toString().equals((currentAns)))
			return b;
		 b = (Button)activity.findViewById(R.id.buttonB);
		 Log.d(b.getText().toString(), currentAns);
		 if(b.getText().toString().equals((currentAns)))
			return b;
		 b = (Button)activity.findViewById(R.id.buttonC);
		 Log.d(b.getText().toString(), currentAns);
		 if(b.getText().toString().equals((currentAns)))
			return b;
		 b = (Button)activity.findViewById(R.id.buttonD);
		 Log.d(b.getText().toString(), currentAns);
		 if(b.getText().toString().equals((currentAns)))
			return b;
		Log.d("getbuttonans","returneaza nulllll");
		return null;
	}
	public void SetNewQuestion(String question,String ansA,String ansB,String ansC,String ansD, String value) {
		SetQuestionCounter(String.valueOf(question_counter++));
		SetQuestion(question);
		SetAnswerA(ansA);
		SetAnswerB(ansB);
		SetAnswerC(ansC);
		SetAnswerD(ansD);
		SetQuestionValue(value);
		SetCountDownTimer();
	}
	public TextView getQuestionTextView() {
		TextView t = (TextView)activity.findViewById(R.id.titleSmart);
		return t;
	}
	public void EndGame()  {
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {

		Button b = (Button)activity.findViewById(R.id.buttonA);
		b.setVisibility(View.INVISIBLE);
		 b = (Button)activity.findViewById(R.id.buttonB);
		b.setVisibility(View.INVISIBLE);
		 b = (Button)activity.findViewById(R.id.buttonC);
		b.setVisibility(View.INVISIBLE);
		 b = (Button)activity.findViewById(R.id.buttonD);
		b.setVisibility(View.INVISIBLE);
		
		TextView t1 = (TextView)activity.findViewById(R.id.mypoints);
		TextView t2 = (TextView)activity.findViewById(R.id.opppoints);
		int myp,oppp;
		if(GetMyName().equals(Client.myName)) {
			 myp = Integer.valueOf(t1.getText().toString());
			 oppp =  Integer.valueOf(t2.getText().toString());
		}
		else {
			 oppp = Integer.valueOf(t1.getText().toString());
			 myp =  Integer.valueOf(t2.getText().toString());

		}
		if(myp > oppp)
			SetQuestion("You won ! Congratulations");
		if(myp == oppp)
			SetQuestion("Draw !");
		if(myp < oppp)
			SetQuestion("You lost !");
		
		
		
			long start = 5000;
			long interval = 500;
			CountDownTimer t;
			
			t = new CountDownTimer(start,interval) {
				//final 
				
				public void onTick(long millisUntilFinished) {
					Log.d(String.valueOf(millisUntilFinished/500), "da sigur");
					
					//((TextView)activity.findViewById(R.id.timer)).setText(String.valueOf(millisUntilFinished/1000));
					if((millisUntilFinished / 500) %2 == 0 )
						getQuestionTextView().setBackgroundColor(Color.CYAN);
					else
						getQuestionTextView().setBackgroundColor(Color.MAGENTA);
				}
				
			
				public void onFinish() {
					getQuestionTextView().setBackgroundColor(Color.CYAN);
					

				}
			}.start();
		
			
			}
		});
	}
	public void UpdateQuestion(final Question q) {
		Log.d("updateq","before setans");
		
		Log.d("updateq","after setans");
		canAns = true;
		currentAns = q.getSolution();
		activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SetQuestion(q.getQuestion());
				SetAnswerA(q.getVariants().get(0));
				SetAnswerB(q.getVariants().get(1));
				SetAnswerC(q.getVariants().get(2));
				SetAnswerD(q.getVariants().get(3));
				SetQuestionValue("QValue:" + String.valueOf(1));
				question_counter++;
				SetQuestionCounter("QNo:" + String.valueOf(question_counter));
				SetCountDownTimer();
				
			}
		});
		
	}
	
	public void SetGameInfo(final GameInfo gameInfo){
				activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SetMyName(gameInfo.getPlayerOne());
				SetOppName(gameInfo.getPlayerTwo());
				SetMyPoints(String.valueOf( gameInfo.getPlayerOneScore()));
				SetOppPoints(String.valueOf( gameInfo.getPlayerTwoScore()));

			}
		});
	}
	public void UpdateScore(final GameInfo gameInfo) {
			activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {

					SetMyPoints(String.valueOf( gameInfo.getPlayerOneScore()));
					SetOppPoints(String.valueOf(gameInfo.getPlayerTwoScore()));
					ShowCorrectAnswer();
			}
			});
	}
}
