package me.bhavyaaggarwal.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bhavyaaggarwal on 27/01/18.
 */

public class BlueFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_blank, null);
        rootview.findViewById(R.id.flBackground).setBackgroundColor(Color.BLUE);
        return rootview;
    }
}
