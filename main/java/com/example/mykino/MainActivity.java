package com.example.mykino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    myAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitBottomView(R.id.tape);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                serchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Александр Невский", getResources().getString(R.string.firstFilm), "6+", R.drawable.filmfirst, "1938", "\n" +
                "военный, биография, драма, боевик, история", "\n" +
                "111 мин. ", "\n" +
                "Сергей Эйзенштейн");
        dataList.add(androidData);

        androidData = new DataClass("Василиса Прекрасная",getResources().getString(R.string.secondFilm), "6+", R.drawable.filmsecond, "1939", "\n" +
                "фэнтези, приключения, семейный", "\n" +
                "74 мин. / 01:14", "\n" +
                "Александр Роу");
        dataList.add(androidData);

        androidData = new DataClass("Укротительница тигров",getResources().getString(R.string.threeFilm), "6+", R.drawable.filmthree, "1954", "\n" +
                "мелодрама, комедия", "\n" +
                "101 мин.", "\n" +
                "Александр Ивановский, Надежда Кошеверова");
        dataList.add(androidData);

        adapter = new myAdapter(MainActivity.this, dataList);
        recyclerView.setAdapter(adapter);

    }


    private void serchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}