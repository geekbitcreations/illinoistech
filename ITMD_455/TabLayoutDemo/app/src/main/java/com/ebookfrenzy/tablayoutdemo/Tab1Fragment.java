package com.ebookfrenzy.tablayoutdemo;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Tab1Fragment extends Fragment {

     public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        VideoView myVideoView =(VideoView) rootView.findViewById(R.id.vidview);

        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(myVideoView);
        try{//try to fetch vid from sdcard?
            //ex, String SrcPath = "/sdcard/week17boy.avi";//put your video in sdcard
            String vidpath = "android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.my_video;
            myVideoView.setVideoURI(Uri.parse(vidpath));
            //myVideoView.setVideoPath(SrcPath);
            myVideoView.setMediaController(mediaController);
            myVideoView.requestFocus();
            myVideoView.start();
        }
        catch (Exception e){
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        return rootView;
    }

    @Override
    public void onPause() {
        Toast.makeText(getActivity(), "Frag on pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    public void onStart() {
        Toast.makeText(getActivity(), "Frag start", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

}
