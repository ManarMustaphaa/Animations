package com.example.manar_000.animations;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main2ActivityFragment extends Fragment {

    ImageView letter;
    ImageView word;
    Timer myTimer;

    public Main2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main2, container, false);

//        clockwise(view);
//        zoom(view);
        final MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.letter);
        final MediaPlayer mediaPlayerword = MediaPlayer.create(getActivity(), R.raw.word);
        letter = (ImageView) view.findViewById(R.id.letter);
        word = (ImageView) view.findViewById(R.id.word);
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                clockwise(v);
                mediaPlayer.start();
                v.animate().alpha(0).setDuration(2000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        v.setVisibility(View.GONE);
                        word.setVisibility(View.VISIBLE);
                    }
                });
        }});

        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mediaPlayerword.start();
                moveword(v);
            }
        });

        return view;
    }

    public void clockwise(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.letter);
        Animation animation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.myanimation);
        image.startAnimation(animation);
    }

    public void zoom(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.word);
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(),
                R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.word);
        Animation animation1 =
                AnimationUtils.loadAnimation(getActivity(),
                        R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.word);
        Animation animation1 =
                AnimationUtils.loadAnimation(getActivity(),
                        R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.letter);
        Animation animation1 =
                AnimationUtils.loadAnimation(getActivity(), R.anim.move);
        image.startAnimation(animation1);
    }

    public void moveword(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.word);
        Animation animation1 =
                AnimationUtils.loadAnimation(getActivity(), R.anim.move);
        image.startAnimation(animation1);
    }

    public void slide(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.letter);
        Animation animation1 =
                AnimationUtils.loadAnimation(getActivity(), R.anim.slide);
        image.startAnimation(animation1);
    }
}