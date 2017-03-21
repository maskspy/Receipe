package com.wael.app.myreceipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {


    ListView listView;
    Button addbtn;
    TextView accNamme;
    String[] list = {"Rosted Chicken", "Rosted Beef", "Turkey", "Bekata"};
    String[] desc = {"Rosted ChickenRosted Chicken Rosted Chicken Rosted Chicken", "Rosted Beef Rosted Beef Rosted Beef Rosted Beef Rosted Beef", "Turkey  Turkey Turkey  Turkey Turkey Turkey Turkey", "Bekata Bekata Bekata Bekata Bekata Bekata Bekata Bekata Bekata"};

    ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        accNamme = (TextView) findViewById(R.id.accName);

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(itemsAdapter);

        addbtn = (Button) findViewById(R.id.Add);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(a);
            }
        });
        Intent r = getIntent();
        Intent login = getIntent();
        accNamme.setText(login.getStringExtra("accName"));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("name", list[position]);
                i.putExtra("desc", desc[position]);
                startActivity(i);
            }
        });

    }
}