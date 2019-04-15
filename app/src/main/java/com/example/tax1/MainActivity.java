package com.example.tax1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText amt;
    private Button btnperform;
    private TextView show, txtAnnual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amt = findViewById(R.id.amt);
        btnperform = findViewById(R.id.btnperform);
        show = findViewById(R.id.show);
        txtAnnual = findViewById(R.id.txtAnnual);
        btnperform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double cal = Double.parseDouble(amt.getText().toString());
                double amount = cal * 12;
                txtAnnual.setText(Double.toString(amount));

                Main_Tax ta = new Main_Tax();
                ta.setAmount(amount);

                if (amount < 200000) {
                    double res = ta.lowTax();
                    show.setText(Double.toString(res));
                } else if (amount >= 200000 && cal < 350000) {
                    double res = ta.mediumTax();
                    show.setText(Double.toString(res));
                } else if (amount >= 350000) {
                    double res = ta.highTax();
                    show.setText(Double.toString(res));
                }

            }
        });


    }
}

