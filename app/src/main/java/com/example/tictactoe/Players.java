package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    private EditText input1, input2;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String X = String.valueOf(input1.getText());
                String O = String.valueOf(input2.getText());
                if (X.equals("") || O.equals("")) {
                    Toast.makeText(Players.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(Players.this, TicTacToe.class);
                    i.putExtra("X", X);
                    i.putExtra("O", O);
                    startActivity(i);
                }
            }
        });
    }
}
