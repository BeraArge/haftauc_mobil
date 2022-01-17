package com.example.haftauc_mobil.ui.home;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haftauc_mobil.R;
import com.example.haftauc_mobil.adapters.MyAdapter;
import com.example.haftauc_mobil.models.DataModel;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    SQLiteDatabase database;
    TextView name, surname, year;
    RecyclerView recyclerView;
    private static SharedPreferences sharedPreferences;
    TextView email;

    ArrayList<DataModel> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        name = root.findViewById(R.id.name);
        surname = root.findViewById(R.id.surname);
        year = root.findViewById(R.id.year);
        recyclerView = root.findViewById(R.id.recview);
        email = root.findViewById(R.id.email);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        database = this.getContext().openOrCreateDatabase("mydb", this.getContext().MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY ,name VARCHAR,surname VARCHAR, year VARCHAR)");

        String sqlString = "INSERT INTO users (name,surname,year) VALUES (?,?,?)";
        SQLiteStatement sqLiteStatement = database.compileStatement(sqlString);
        sqLiteStatement.bindString(1, "Muhammet");
        sqLiteStatement.bindString(2, "ÇAYLI");
        sqLiteStatement.bindString(3, "1992");
        sqLiteStatement.execute();
        int sayac = 0;
        Cursor cursor = database.rawQuery("SELECT * FROM users",null);
        while(cursor.moveToNext()){

            list.add(new DataModel(
                    cursor.getInt(0), // id
                    cursor.getString(1), // name
                    cursor.getString(2), // surname
                    cursor.getString(3) // year
            ));
        }

        recyclerView.setAdapter(new MyAdapter(list));

        sharedPreferences= this.getContext().getSharedPreferences("register",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("token","ahmetmehmet@gmail.com");
        editor.commit();
        email.setText(sharedPreferences.getString("token",null));
        //Log.e("SHARED ::::: ", sharedPreferences.getString("token",null));

        return root;
    }
}