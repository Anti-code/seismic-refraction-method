package com.example.fool.mbu_sky;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper entry_db = new DatabaseHelper(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });



        List<Entry> entryList =new ArrayList<>();
        EntryAdapter adapter=new EntryAdapter(this, R.layout.entry_item, entryList);
        ListView listView = (ListView)findViewById(R.id.EntryListView);

        String[] l = {"Dor Cafe Bistro Lounge", "Beyzade Kafe", "Dünya Kahveleri", "David People Coffee"};

        for(int i=0;i<4;i++){

            Entry e = new Entry();
            e.layer1=new Layer();
            e.layer2=new Layer();
            e.setTitle(l[i]);
            System.out.println(l[i]);
            e.setDate(new Date());
            e.setLat(37.7730529);
            e.setLng(30.5422792);
            entryList.add(e);
        }

        listView.setAdapter(adapter);
        System.out.println(entry_db.getDatabaseName());
    }
}
