package com.ebookfrenzy.tablayoutdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private Button button;
    public Tab2Fragment() {

        // Inflate the layout for this fragment
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Required empty public constructor

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        button =(Button) rootView.findViewById(R.id.buttonUrl);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                startActivity(intent);
            }

        });
        return rootView;
    }

}
