package com.example.searchviewrec;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.searchviewrec.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Adapter adapter;
    private List<Model> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataList = new ArrayList<>();
        adapter = new Adapter(dataList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        binding.clickHere.setOnClickListener(v -> {
            int number = Integer.parseInt(binding.searchView.getText().toString());
            addItems(number);
        });

        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearItems();
            }
        });

    }

    private void addItems(int number) {
        dataList.clear();
        for (int i = 0; i < number; i++) {
            dataList.add(new Model(i + 1));
        }
        adapter.notifyDataSetChanged();
    }

    private void clearItems(){
        dataList.clear();
        adapter.notifyDataSetChanged();
    }

}