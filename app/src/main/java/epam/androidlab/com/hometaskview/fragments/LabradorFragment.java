package epam.androidlab.com.hometaskview.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import epam.androidlab.com.hometaskview.R;


public class LabradorFragment extends Fragment {


    public LabradorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_labrador, container, false);

        ImageView mImageView = (ImageView) rootView.findViewById(R.id.imageViewLabrador);
        mImageView.setImageResource(R.drawable.labrador);

        return rootView;
    }

}
