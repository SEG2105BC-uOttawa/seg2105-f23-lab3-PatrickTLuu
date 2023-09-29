package com.example.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator operator = Operator.none;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
    }

    public void btnNumberClick(View view) {
        int pressID = view.getId();
        EditText eText = findViewById(R.id.resultEdit);
        String newText = "";

        if (pressID == R.id.btn00) {
            newText = "0";
        }
        else if (pressID == R.id.btn01) {
            newText = "1";
        }
        else if (pressID == R.id.btn02) {
            newText = "2";
        }
        else if (pressID == R.id.btn03) {
            newText = "3";
        }
        else if (pressID == R.id.btn04) {
            newText = "4";
        }
        else if (pressID == R.id.btn05) {
            newText = "5";
        }
        else if (pressID == R.id.btn06) {
            newText = "6";
        }
        else if (pressID == R.id.btn07) {
            newText = "7";
        }
        else if (pressID == R.id.btn08) {
            newText = "8";
        }
        else if (pressID == R.id.btn09) {
            newText = "9";
        }
        else if (pressID == R.id.btnDot) {
            newText = ".";
        }

        eText.setText(String.format("%s%s", eText.getText(), newText));
    }

    public void btnOperatorClick(View view) {
        int pressID = view.getId();
        EditText eText = findViewById(R.id.resultEdit);

        if (pressID == R.id.btnAdd) {
            operator = Operator.add;
        }
        else if (pressID == R.id.btnMinus) {
            operator = Operator.minus;
        }
        else if (pressID == R.id.btnMultiply) {
            operator = Operator.multiply;
        }
        else if (pressID == R.id.btnDivide) {
            operator = Operator.divide;
        }

        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View view) {
        EditText eText = findViewById(R.id.resultEdit);
        eText.setText("");
    }

    public void btnResultClick(View view) {
        if (operator != Operator.none) {
            EditText eText = findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());

            double result = 0;

            switch (operator) {
                case add:
                    result = data1 + data2;
                    break;

                case minus:
                    result = data1 - data2;
                    break;

                case multiply:
                    result = data1 * data2;
                    break;

                case divide:
                    result = data1 / data2;
                    break;
            }

            operator = Operator.none;
            data1 = result;

            if ((result-(int)result) != 0) {
                eText.setText(String.valueOf(result));
            }
            else {
                eText.setText(String.valueOf((int)result));
            }
        }
    }
}
