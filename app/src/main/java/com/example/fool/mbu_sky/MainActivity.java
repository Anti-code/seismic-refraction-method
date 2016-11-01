package com.example.fool.mbu_sky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
    }

    void populateListView(){
        String[] l = {"Dor Cafe Bistro Lounge", "Beyzade Kafe", "Dünya Kahveleri", "David People Coffee"};
        List<Entry> entryList =new ArrayList<>();
        for(int i=0;i<4;i++){
            Entry e = new Entry();
            e.layer1=new Layer();
            e.layer2=new Layer();
            e.setTitle(l[i]);
            e.setDate(new Date());
            e.setLat(37.7730529);
            e.setLng(30.5422792);
            entryList.add(e);
        }
        EntryAdapter adapter=new EntryAdapter(this, R.layout.entry_item, entryList);
        ListView listView = (ListView)findViewById(R.id.EntryListView);
        listView.setAdapter(adapter);
    }
}
