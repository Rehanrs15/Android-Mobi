package com.examples.rehan.rehan.Activities.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;

import com.examples.rehan.rehan.Activities.Activities.ViewpagerActivity;
import com.examples.rehan.rehan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Viewpager1 extends Fragment {

    RelativeLayout pagerLayout;

    public Viewpager1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_viewpager1, container, false);
        pagerLayout = (RelativeLayout)view.findViewById(R.id.viewpagerlayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pagerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.animate(v)
                        .setDuration(1000)
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .setInterpolator(new Interpolation())
                        .setListener(new ViewPropertyAnimatorListener() {
                            @Override
                            public void onAnimationStart(View view) {

                            }

                            @Override
                            public void onAnimationEnd(View view) {
                                startActivity(new Intent(getActivity(), ViewpagerActivity.class));
                            }

                            @Override
                            public void onAnimationCancel(View view) {

                            }
                        })
                        .withLayer()
                        .start();
            }
        });
    }

    private class Interpolation implements Interpolator {
        private final float mCycles = 0.5f;

        @Override
        public float getInterpolation(final float input) {
            return (float) Math.sin(2.0f * mCycles * Math.PI * input);
        }
    }
}
