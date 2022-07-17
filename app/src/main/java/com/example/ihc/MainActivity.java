package com.example.ihc;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText my_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_text = (EditText) findViewById(R.id.my_text); // ID from component
        // The activity is created
    }

    public void Send(View view)
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("my_text", my_text.getText().toString());
        startActivity(i);
    }
}
