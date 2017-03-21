package com.wael.app.myreceipe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {

    String newName;
    String newDesc;

    EditText n;
    EditText d;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        n = (EditText) findViewById(R.id.addName);
        d = (EditText) findViewById(R.id.addDesc);

        final Intent i = new Intent(getApplicationContext(), MainActivity.class);
        btn = (Button) findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newName = String.valueOf(n.getText());
                newDesc = String.valueOf(d.getText());


                i.putExtra("newName", newName);
                i.putExtra("newDesc", newDesc);

                startActivity(i);
            }
        });
    }
}
