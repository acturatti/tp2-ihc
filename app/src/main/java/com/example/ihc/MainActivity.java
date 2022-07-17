package com.example.ihc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText first_number;
    private EditText second_number;
    private TextView show_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_number = (EditText) findViewById(R.id.number1); // ID from component
        second_number = (EditText) findViewById(R.id.number2);// ID from component
        show_result = (TextView) findViewById(R.id.show_result);
        // The activity is created
    }

    public void sum (View view){
        int n1 = Integer.parseInt(first_number.getText().toString());
        int n2 = Integer.parseInt(second_number.getText().toString());
        int sum = n1 + n2;

        show_result.setText("Resultado: " + sum);
    }
}

