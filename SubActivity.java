package kr.zeroand.simpleActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//1. 화면 디자인한  layout을 호출
		setContentView(R.layout.main_sub);

		Intent i=getIntent();
		String value=i.getCharSequenceExtra("inputData").toString();
		View v=findViewById(R.id.viewData);
		TextView tv=(TextView)v;
		tv.setText("mainActivity에서 받은  value : " + value);
		//2. 이벤트 발생
		actionEvent();
	}
	private void actionEvent() {		
		findViewById(R.id.subExit).setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				getUserMessage("메인페이지 이동");
				finish();				
			}
		});
	}

	private void getUserMessage( CharSequence message) {
		Toast.makeText(this, message,  Toast.LENGTH_SHORT).show();
		Log.i("SubActivity", message+"");		
	}
}