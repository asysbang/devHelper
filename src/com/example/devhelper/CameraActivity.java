package com.example.devhelper;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class CameraActivity extends Activity implements Callback, AnimationListener {

	private SurfaceView preview;

	private SurfaceHolder mSurfaceHolder;

	private Camera mCamera;

	private ImageView image, tag;

	private AnimationSet as;
	private TranslateAnimation ta;

	private ScaleAnimation sa;

	private boolean isAnimating = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera_main);
		preview = (SurfaceView) findViewById(R.id.camera_preview);
		mSurfaceHolder = preview.getHolder();
		mSurfaceHolder.addCallback(this);
		image = (ImageView) findViewById(R.id.camera_image);
		tag = (ImageView) findViewById(R.id.camera_tag);
		as = new AnimationSet(false);

		sa = new ScaleAnimation(1.0f, 0.12f, 1.0f, 0.12f);
		sa.setDuration(1000);
		as.addAnimation(sa);

		ta = new TranslateAnimation(0, 1000, 0, 333);
		ta.setDuration(1000);
		as.addAnimation(ta);
		as.setAnimationListener(this);
	}

	private PictureCallback jpeg = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			image.setImageBitmap(bitmap);
			image.setVisibility(View.VISIBLE);

			image.startAnimation(as);
		}
	};

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	private int cameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		try {
			mCamera = Camera.open(cameraId);
			mCamera.setPreviewDisplay(mSurfaceHolder);
			int degrees = getDisplayOritation(getDispalyRotation(), cameraId);
			mCamera.getParameters().setPreviewSize(640, 480);
			mCamera.setDisplayOrientation(degrees);

			List<Size> list = mCamera.getParameters().getSupportedPictureSizes();
			for (Size s : list) {
				System.out.println("===getSupportedPictureSizes==" + s.width);
				System.out.println("===getSupportedPictureSizes==" + s.height);
			}

			List<Size> list2 = mCamera.getParameters().getSupportedPreviewSizes();
			for (Size s : list2) {
				System.out.println("===getSupportedPreviewSizes==" + s.width);
				System.out.println("===getSupportedPreviewSizes==" + s.height);
			}

			mCamera.startPreview();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		mCamera.stopPreview();
		mCamera.release();
		mCamera = null;
	}

	private int getDispalyRotation() {
		int i = getWindowManager().getDefaultDisplay().getRotation();
		switch (i) {
		case Surface.ROTATION_0:
			return 0;
		case Surface.ROTATION_90:
			return 90;
		case Surface.ROTATION_180:
			return 180;
		case Surface.ROTATION_270:
			return 270;
		}
		return 0;
	}

	private int getDisplayOritation(int degrees, int cameraId) {
		Camera.CameraInfo info = new Camera.CameraInfo();
		Camera.getCameraInfo(cameraId, info);
		int result;
		if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
			result = (info.orientation + degrees) % 360;
			result = (360 - result) % 360;
		} else {
			result = (info.orientation - degrees + 360) % 360;
		}
		return result;
	}

	public void switchCamera(View v) {
		if (cameraId == Camera.CameraInfo.CAMERA_FACING_FRONT) {
			cameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
		} else {
			cameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
		}
		mCamera.stopPreview();
		mCamera.release();
		mCamera = Camera.open(cameraId);
		try {
			mCamera.setPreviewDisplay(mSurfaceHolder);
			int degrees = getDisplayOritation(getDispalyRotation(), cameraId);
			mCamera.getParameters().setPreviewSize(640, 480);
			mCamera.setDisplayOrientation(degrees);
			mCamera.startPreview();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(View v) {
		if (isAnimating) {
			return;
		}
		isAnimating = true;
		mCamera.takePicture(null, null, jpeg);

	}

	@Override
	public void onAnimationStart(Animation animation) {
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		image.setVisibility(View.GONE);
		isAnimating = false;
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

}
