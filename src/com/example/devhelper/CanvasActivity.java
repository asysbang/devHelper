package com.example.devhelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
		
	}

	private class DrawView extends View {

		private Paint textPaint;

		private MaskFilter embossMaskFilter;

		public DrawView(Context context) {
			super(context);
			textPaint = new Paint();
			textPaint.setColor(Color.RED);
			textPaint.setTypeface(Typeface.DEFAULT_BOLD);
			textPaint.setTextSize(30);
			embossMaskFilter = new EmbossMaskFilter(new float[] { 1, 1, 1 }, 0.4f, 6, 3.5f);
			textPaint.setMaskFilter(embossMaskFilter);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawText("ABC", 100, 100, textPaint);
		}
	}

}
