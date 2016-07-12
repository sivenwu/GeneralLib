package cn.wsy.photolib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.wsy.photolib.utils.PhotoUtils;
import cn.wsy.photolib.widget.PhotoView;
import cn.wsy.photolib.widget.PhotoViewAttacher;


/**
 * Created by wsy on 2016/1/18.
 */
public class PhotoFragment extends Fragment implements PhotoViewAttacher.OnPhotoTapListener {

    public static final String PHOTO_URI_KEY = "photo_uri";

    private PhotoView vPhoto;
    private String mPhotoUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.frag_display_img, container, false);
        vPhoto = (PhotoView)view;
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vPhoto.setOnPhotoTapListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle data = getArguments();
            mPhotoUri = data.getString(PHOTO_URI_KEY);
        } else {
            mPhotoUri = savedInstanceState.getString(PHOTO_URI_KEY);
        }
        if (mPhotoUri != null) {
            PhotoUtils.showImage(vPhoto, mPhotoUri);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null && mPhotoUri != null) {
            outState.putString(PHOTO_URI_KEY, mPhotoUri);
        }
    }

    @Override
    public void onPhotoTap(View view, float v, float v1) {
        getActivity().finish();
    }

}

