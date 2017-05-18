package epam.androidlab.com.hometaskview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import epam.androidlab.com.hometaskview.R;


public class HuskyFragment extends Fragment {


    public HuskyFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_husky, container, false);

        ImageView mImageView = (ImageView) rootView.findViewById(R.id.imageViewHusky);
        mImageView.setImageResource(R.drawable.husky);

        return rootView;
    }


}
