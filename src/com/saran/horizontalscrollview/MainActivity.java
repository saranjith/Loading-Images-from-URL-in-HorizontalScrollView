/*
 *@author:saranjith.s 
 * 
 */

package com.saran.horizontalscrollview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

public class MainActivity extends Activity {

	LinearLayout mockGalleryView;
	ArrayList<String> imageList, captionList;
	Intent secondActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageList = new ArrayList<String>();
		captionList = new ArrayList<String>();
		
		/* 
		 * I'm assuming that I've already downloaded the data 
		 * through the API and stored it into two arraylists, 
		 * "captionList" and "imageList".
		 * 
		 */

		captionList.add("Date");
		captionList.add("Time");
		captionList.add("Location");
		captionList.add("Gift");

		imageList.add("http://aswegetmarried.in/images/illustrations/calendar.png");
		imageList.add("http://aswegetmarried.in/images/illustrations/time.png");
		imageList.add("http://aswegetmarried.in/images/illustrations/map.png");
		imageList.add("http://aswegetmarried.in/images/illustrations/gift.png");

		mockGalleryView = (LinearLayout) findViewById(R.id.mockGallery);

		setView(captionList, imageList);
	}

	public void setView(ArrayList<String> captionList, ArrayList<String> imageList) {
		for (int i = 0; i < imageList.size(); i++) {
			LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View v = vi.inflate(R.layout.item_mockgallery, null);
			TextView caption = (TextView) v.findViewById(R.id.textView_caption);
			caption.setText(captionList.get(i));
			ImageView singleImage = (ImageView) v.findViewById(R.id.imageView_mockgalleryItem);
			UrlImageViewHelper.setUrlDrawable(singleImage, imageList.get(i), R.drawable.ic_launcher); //setting the contents for the image, with launcher icon as the stub
			((ViewGroup) mockGalleryView).addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

			v.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Toast.makeText(getApplicationContext(), "Going to next activity by clicking image", Toast.LENGTH_LONG).show();
					secondActivity = new Intent(getApplicationContext(), SecondActivity.class);
					startActivity(secondActivity);
				}
			});

		}
	}
}
