package cn.wsy.photolib;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

;

/**
 * 浏览图片
 * Created by Qiuh on 2015/5/27 13:57
 */
public class BrowserPhotoActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static void browserMultiPhotos(Context context, int startindex, ArrayList<String> photolist) {
        Intent intent = new Intent(context, BrowserPhotoActivity.class);
        intent.putExtra(PHOTO_LIST, photolist);
        intent.putExtra(PHOTO_START_INDEX, startindex);
        context.startActivity(intent);
    }

    public static void browserSimplePhoto(Context context, String photouri) {
        ArrayList<String> arr = new ArrayList<String>(1);
        arr.add(photouri);
        browserMultiPhotos(context, 0, arr);
    }

    public static final String PHOTO_LIST = "photo_list";
    public static final String PHOTO_START_INDEX = "photo_start_index";

    private ViewPager vPhotoPager;
    private TextView vIndexTips;

    private PhotoViewPagerAdapter mAdapter;
    private ArrayList<String> mPhotoUriList = new ArrayList<String>();
    private int mCurIndex;
    private int mTotalSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_imgs);
        vPhotoPager = (ViewPager) findViewById(R.id.photo_browser_viewpager);
        vIndexTips = (TextView) findViewById(R.id.photo_browser_index);
        parseData();
        if (mTotalSize <= 0) {
            finish();
        } else {
            initViews();
        }
    }

    private void parseData() {
        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> arr = intent.getStringArrayListExtra(PHOTO_LIST);
            if(arr != null){
                mPhotoUriList.addAll(arr);
            }
            mCurIndex = intent.getIntExtra(PHOTO_START_INDEX, 0);
            mTotalSize = mPhotoUriList.size();
        }
    }

    private void initViews() {
        mAdapter = new PhotoViewPagerAdapter(getSupportFragmentManager());
        vPhotoPager.setAdapter(mAdapter);
        vPhotoPager.setOnPageChangeListener(this);
        vPhotoPager.setCurrentItem(mCurIndex);
        showIndexTips();
    }

    private void showIndexTips(){
        vIndexTips.setText((mCurIndex + 1) + "/" + mTotalSize);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mCurIndex = position;
        showIndexTips();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class PhotoViewPagerAdapter extends FragmentStatePagerAdapter {

        public PhotoViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PhotoFragment fragment = new PhotoFragment();
            Bundle data = new Bundle();
            data.putString(PhotoFragment.PHOTO_URI_KEY, mPhotoUriList.get(position));
            fragment.setArguments(data);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTotalSize;
        }
    }
}
