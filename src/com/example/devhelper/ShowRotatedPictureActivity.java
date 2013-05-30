package com.example.devhelper;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class ShowRotatedPictureActivity extends Activity {

	private ImageView imageBefore, imageAfter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_rotated_picture_main);
		imageBefore = (ImageView) findViewById(R.id.before);
		imageAfter = (ImageView) findViewById(R.id.after);
		loadBitmap();
	}

	private void loadBitmap() {
		Cursor c = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
		System.out.println("==============" + c.getColumnCount());
		System.out.println(c.getCount());
		// just show the first rotated picture
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			String path = c.getString(c.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
			int rotation = c.getInt(c.getColumnIndex(MediaStore.Images.ImageColumns.ORIENTATION));
			if (rotation != 0) {
				Bitmap bitmap = BitmapFactory.decodeFile(path);
				imageBefore.setImageBitmap(bitmap);
				Matrix m = new Matrix();
				m.setRotate(rotation);
				Bitmap transformed = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
				imageAfter.setImageBitmap(transformed);
				return;
			}
		}

	}

}
