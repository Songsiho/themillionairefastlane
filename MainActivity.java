package kr.zeroand.simpleActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//1. ȭ�� ��������  layout�� ȣ��
		setContentView(R.layout.main);

		//2. �̺�Ʈ �߻�
		actionEvent();
	}
	private void actionEvent() {
		findViewById(R.id.submit).setOnClickListener(this);
		findViewById(R.id.no).setOnClickListener(this);
	/*	findViewById(R.id.exit).setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				getUserMessage("���� ����");
				finish();				
			}
		});*/
	}
	/**OnClickListener interface's overriding method*/
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.no:
			getUserMessage("���");
			break;
		case R.id.submit:
			getUserMessage("Ȯ��");
			//���� ������--> SubActivity �̵�
			Intent i=new Intent(getApplicationContext(), SubActivity.class);
			EditText et=(EditText)(findViewById(R.id.inputData));
			CharSequence value=et.getText();
			//CharSequence value=(EditText)(findViewById(R.id.inputData)).getText();
			i.putExtra("inputData",value);
			startActivity(i);
			
			break;
		}
	}
	private void getUserMessage( CharSequence message) {
		Toast.makeText(MainActivity.this, message,  Toast.LENGTH_SHORT).show();
		Log.i("MainActivity", message+"");		
	}
}