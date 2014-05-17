package com.example.proiectpdsd;

import java.util.Currency;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
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
	
	public InterfaceHandler(Activity _activity) {
		this.activity = _activity;
	}
	public void InitInterface() {
		Button b;
		b = (Button)activity.findViewById(R.id.buttonA);
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonB);
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonC);
		AddListenerButton(b);
		b = (Button)activity.findViewById(R.id.buttonD);
		AddListenerButton(b);
		defaultButtonColour = b.getBackground();
	}
	void AddListenerButton(final Button b) {
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SetSelectedAnswer(b.getId());
				
			}
		});
	}
	public void SetSelectedAnswer(int id) {
		Button b = (Button)activity.findViewById(id);
		if (answerSelected != null) {
			answerSelected.setBackgroundDrawable(defaultButtonColour);
		}
			answerSelected = b;
			answerSelected.setBackgroundColor(Color.BLUE);
		
	}
	public Button GetSelectedAnswer() {
		return answerSelected;
	}
	public String GetSelectedAnswerString() {
		return answerSelected.getText().toString();
	}
	public void SetQuestion(String str) {
		TextView t = (TextView)activity.findViewById(R.id.intrebare);
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
	public void SetOppName(String str) {
		TextView t = (TextView)activity.findViewById(R.id.oppname);
		t.setText(str);
	}
	public void SetMyPoints(String str) {
		TextView t = (TextView)activity.findViewById(R.id.mypoints);
		t.setText(str);
	}
	public void SetOppPoints(String str) {
		TextView t = (TextView)activity.findViewById(R.id.opppoints);
		t.setText(str);
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
		CountDownTimer timer = new CountDownTimer(start,interval) {
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
	
	
	
	
	
	
}
