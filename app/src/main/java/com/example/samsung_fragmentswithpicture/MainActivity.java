package com.example.samsung_fragmentswithpicture;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализируем нижний бар навигации
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Создаем контейнер, который будет отвечать за переключение фрагментов из навигационного графа
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        //NavController управляет переходами между экранами и обрабатывает нажатия на кнопки BottomNavigationView.
        NavController navController = navHostFragment.getNavController();

        //Автоматически связываем BottomNavigationView с NavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
