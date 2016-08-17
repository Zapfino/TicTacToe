package com.hvoxincorporated.tictactoebyhvox;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    // 0 = red, 1 = yellow
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winning = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    // 2 means unplayed
    int gameisActive = 0;
    public void dropin (View view) {
        if (gameisActive == 0) {
            ImageView counter = (ImageView) view;

            counter.getTag();

            int tapped = Integer.parseInt(counter.getTag().toString());

            if (gameState[tapped] == 2) {
                gameState[tapped] = activePlayer;
                counter.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    counter.setImageResource(R.drawable.red);
                    activePlayer = 1;
                } else {
                    counter.setImageResource(R.drawable.yellow);
                    activePlayer = 0;
                }
                counter.animate().translationY(0f).rotation(180f).setDuration(500);
                for (int[] winningPosition : winning) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                            gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                            gameState[winningPosition[0]] != 2) {
                        gameisActive = 1;
                        if (gameState[winningPosition[1]] == 0) {
                            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                            layout.setBackgroundColor(Color.argb(226, 255, 23, 68));
                            layout.setVisibility(View.VISIBLE);
                            TextView result = (TextView) findViewById(R.id.textView);
                            result.setText("RED WON!");


                        } else if (gameState[winningPosition[1]] == 1) {
                            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                            layout.setBackgroundColor(Color.parseColor("#E2FFF176"));
                            layout.setVisibility(View.VISIBLE);
                            TextView result = (TextView) findViewById(R.id.textView);
                            result.setText("YELLOW WON!");


                        }
                        break;

                    }
                    else {boolean gameOver = true;
                        for (int counterState : gameState) {
                            if (counterState == 2) gameOver = false;
                        }
                        if (gameOver) {
                            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                            layout.setBackgroundColor(Color.parseColor("#E281D4FA"));
                            layout.setVisibility(View.VISIBLE);
                            TextView result = (TextView) findViewById(R.id.textView);
                            result.setText(" DRAW!");
                        }


                    }


                }


            }


        }
    }

    public void playAgain (View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;

        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }
        gameisActive = 0;
    }

    /* int x = 0;
    int y1 = 0;
    int y2 = 0;
    List<String> red = new ArrayList<String>();
    List<String> yellow = new ArrayList<String>();
    public boolean redwin() {
            return ((red.contains("1") && red.contains("2") && red.contains("3")) |
                    (red.contains("1") && red.contains("4") && red.contains("7")) |
                    (red.contains("1") && red.contains("5") && red.contains("9")) |
                    (red.contains("2") && red.contains("5") && red.contains("8")) |
                    (red.contains("3") && red.contains("6") && red.contains("9")) |
                    (red.contains("3") && red.contains("5") && red.contains("7")) |
                    (red.contains("4") && red.contains("5") && red.contains("6")) |
                    (red.contains("7") && red.contains("8") && red.contains("9")));
    }
    public boolean yellowwin() {
        return ((yellow.contains("1") && yellow.contains("2") && yellow.contains("3")) |
                (yellow.contains("1") && yellow.contains("4") && yellow.contains("7")) |
                (yellow.contains("1") && yellow.contains("5") && yellow.contains("9")) |
                (yellow.contains("2") && yellow.contains("5") && yellow.contains("8")) |
                (yellow.contains("3") && yellow.contains("6") && yellow.contains("9")) |
                (yellow.contains("3") && yellow.contains("5") && yellow.contains("7")) |
                (yellow.contains("4") && yellow.contains("5") && yellow.contains("6")) |
                (yellow.contains("7") && yellow.contains("8") && yellow.contains("9")));
    }


    public void b1(View view) {
        y1++;
        if (y1 > 1) {
            Toast.makeText(getApplicationContext(), "OCCUPIED SQUARE!", Toast.LENGTH_LONG).show();
        } else {
            x++;
            if (x % 2 == 0) {
                ImageView red1 = (ImageView) findViewById(R.id.red1);
                red1.setAlpha(1f);
                red.add("1");
                red.add("3");
            } else {
                ImageView yellow1 = (ImageView) findViewById(R.id.yellow1);
                yellow1.setAlpha(1f);
                yellow.add("1");
            }
            if (redwin()) {
                Toast.makeText(getApplicationContext(), "RED WIN!", Toast.LENGTH_LONG).show();
            }
            else
            if (yellowwin()) {
                Toast.makeText(getApplicationContext(), "YELLOW WIN!", Toast.LENGTH_LONG).show();
            }
            else if (x == 9) {
                Toast.makeText(getApplicationContext(), "DRAW!", Toast.LENGTH_LONG).show();
            }
            }
        }


    public void b2(View view) {
        y2++;
        if (y2 > 1) {
            Toast.makeText(getApplicationContext(), "OCCUPIED SQUARE!", Toast.LENGTH_LONG).show();
        } else {
            x++;
            if (x % 2 == 0) {
                ImageView red2 = (ImageView) findViewById(R.id.red2);
                red2.setAlpha(1f);
                red.add("2");
            } else {
                ImageView yellow2 = (ImageView) findViewById(R.id.yellow2);
                yellow2.setAlpha(1f);
            }


        }
    }
    */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
