package com.example.samsung_fragmentswithpicture;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private ImageView imageView;
    private ExecutorService executorService; //Пул потоков для загрузки изображения в фоновом потоке
    private Handler mainHandler; //Handler для выполнения действий в главном потоке

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        imageView = view.findViewById(R.id.imageView);

        //Создание пулов потоков для выполнения фоновых задач
        executorService = Executors.newSingleThreadExecutor();

        //Создание обработчика для взаимодействия с UI в главном потоке
        mainHandler = new Handler(Looper.getMainLooper());

        loadImage("https://www.meme-arsenal.com/memes/78a26e460feacdb80ef3d50abf42f5a2.jpg");

        return view;
    }

    private void loadImage(String imageUrl) {
        executorService.execute(() -> {
            try {
                Bitmap bitmap = Picasso.get().load(imageUrl).get();

                //Можно переписать при помощи лямбды  mainHandler.post(() -> imageView.setImageBitmap(bitmap));
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}
