package com.example.samsung_fragmentswithpicture;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class SecondFragment extends Fragment {

    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        imageView = view.findViewById(R.id.imageView);
        loadImage("https://www.meme-arsenal.com/memes/15879c13cb0fd2ef0c3e2548c0ef36a8.jpg");

        return view;
    }

    private void loadImage(String imageUrl) {
        //Загружаем изображение с URL в ImageView с помощью библиотеки Picasso
        Picasso.get()
                .load(imageUrl)  //URL изображения
                .into(imageView); //Устанавливаем изображение в ImageView
    }
}
