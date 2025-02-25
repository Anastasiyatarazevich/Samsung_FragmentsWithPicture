package com.example.samsung_fragmentswithpicture;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FourthFragment extends Fragment {


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        ((TextView) view.findViewById(R.id.textView)).setText("Fourth Fragment");

        Button buttonGoToSecond = view.findViewById(R.id.buttonGoToSecond);
        buttonGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();

                // Выполняем замену фрагмента через FragmentTransaction
                FragmentTransaction transaction = FourthFragment.this.requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, secondFragment); // Заменяем контейнер на новый фрагмент
                transaction.addToBackStack(null); // Добавляем в back stack, чтобы можно было вернуться назад
                transaction.commit(); // Подтверждаем транзакцию
            }
        });


        return view;
    }
}