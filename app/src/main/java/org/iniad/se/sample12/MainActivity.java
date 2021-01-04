package org.iniad.se.sample12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText etX = findViewById(R.id.etX);
        EditText etY = findViewById(R.id.etY);
        TextView tvResult = findViewById(R.id.tvResult);

        try {
            String x = etX.getText().toString();
            String y = etY.getText().toString();
            double sum = calc(x, y);
            tvResult.setText(String.format("%s + %s = %s", x, y, Double.toString(sum)));
        } catch(NumberFormatException e) {
            tvResult.setText("Invalid format.");
        }
    }

    public double calc(String x, String y) {
        return Double.parseDouble(x) + Double.parseDouble(y);
    }
}
