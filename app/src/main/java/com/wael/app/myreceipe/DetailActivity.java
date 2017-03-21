package com.wael.app.myreceipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView Name;
    TextView Desc;
    Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Name = (TextView) findViewById(R.id.itemName);
        Desc = (TextView) findViewById(R.id.itemDesc);
        Home = (Button) findViewById(R.id.back);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(DetailActivity.this, MainActivity.class);
                DetailActivity.this.startActivity(home);
            }
        });
        Intent i = getIntent();

        String nametmp = i.getStringExtra("name");
        String desctmp = i.getStringExtra("desc");

        Name.setText(nametmp);
        Desc.setText(desctmp);

    }
}
