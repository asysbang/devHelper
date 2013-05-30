package com.example.devhelper;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;

public class PhoneActivity extends Activity {

	private static final String mp3File = "/sdcard/1.wma";

	MediaPlayer m = new MediaPlayer();
	PhoneStateListener psl = new PhoneStateListener() {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			System.out.println("=======state======" + state);
			System.out.println("=======incomingNumber======" + incomingNumber);
			if (state == TelephonyManager.CALL_STATE_RINGING && m != null && m.isPlaying()) {
				m.stop();
				m.release();
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_main);
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		tm.listen(psl, PhoneStateListener.LISTEN_CALL_STATE);
	}

	public void playMusic(View v) {
		try {
			m = new MediaPlayer();
			m.setDataSource(mp3File);
			m.prepare();
			m.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
