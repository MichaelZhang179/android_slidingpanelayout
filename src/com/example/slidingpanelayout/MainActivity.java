package com.example.slidingpanelayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn_back);
		btn.setOnClickListener(new OnClickListener() {
			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View v) {
				SlidingPaneLayout sp = (SlidingPaneLayout) findViewById(R.id.sliding_pl);
				sp.setPanelSlideListener(new PanelSlideListener() {
					@Override
					public void onPanelSlide(View arg0, float arg1) {
					}
					
					@Override
					public void onPanelOpened(View arg0) {
						openOptionsMenu();
					}
					
					@Override
					public void onPanelClosed(View arg0) {
						closeOptionsMenu();
					}
				});
				sp.setSliderFadeColor(android.R.color.transparent);
				if(sp.isOpen())
					sp.closePane();
				else
					sp.openPane();
			}
		});
	}

}
