package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TicTacToe extends AppCompatActivity {

    private Button[][] board;
    private String turn;
    private boolean winner;
    private int count;
    private Button reset;
    private TextView player1, player2;
    private TextView player1Score, player2Score;
    private int score1, score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        player1 = findViewById(R.id.X);
        player2 = findViewById(R.id.O);

        String X = getIntent().getStringExtra("X");
        String O = getIntent().getStringExtra("O");

        player1.setText(X + ":");
        player2.setText(O + ":");

        score1 = 0;
        score2 = 0;
        player1Score = findViewById(R.id.XScore);
        player2Score = findViewById(R.id.OScore);

        count = 0;
        turn = "X";
        winner = false;

        board = new Button[][] {
                {findViewById(R.id.btn1), findViewById(R.id.btn2), findViewById(R.id.btn3)},
                {findViewById(R.id.btn4), findViewById(R.id.btn5), findViewById(R.id.btn6)},
                {findViewById(R.id.btn7), findViewById(R.id.btn8), findViewById(R.id.btn9)}
        };

        reset = findViewById(R.id.btn0);

        game();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });



    }

    private void reset() {
        turn = "X";
        count = 0;
        winner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }

        Toast.makeText(TicTacToe.this, "New Game", Toast.LENGTH_SHORT).show();
    }

    private void togglePlayer() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }

    private void game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button btn = (Button)view;
                        String btnText = btn.getText().toString();
                        if (btnText.equals("") && winner == false) {
                            btn.setText(turn);
                            if (turn.equals("X")) {
                                btn.setTextColor(Color.RED);
                            } else {
                                btn.setTextColor(Color.BLUE);
                            }
                            count++;
                            win();
                            togglePlayer();
                        }
                    }
                });
            }
        }
    }

    private void win() {
        if (board[0][0].getText().equals(turn) && board[1][0].getText().equals(turn) && board[2][0].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }

            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[0][1].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][1].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[0][2].getText().equals(turn) && board[1][2].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[0][0].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[0][2].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][0].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[0][0].getText().equals(turn) && board[0][1].getText().equals(turn) && board[0][2].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[1][0].getText().equals(turn) && board[1][1].getText().equals(turn) && board[1][2].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (board[2][0].getText().equals(turn) && board[2][1].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            winner = true;
            if (turn.equals("X")) {
                score1++;
                String name = (String) player1.getText();
                Toast.makeText(TicTacToe.this,  name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            } else {
                score2++;
                String name = (String) player2.getText();
                Toast.makeText(TicTacToe.this, name.substring(0, name.length() - 1) + " won", Toast.LENGTH_SHORT).show();
            }
            player1Score.setText(String.valueOf(score1));
            player2Score.setText(String.valueOf(score2));
        }
        else if (count == 9) {
            Toast.makeText(TicTacToe.this, "draw", Toast.LENGTH_SHORT).show();
        }
    }
}
