package my.unimas.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if (isNewOp)
            editText.setText("");
        isNewOp = false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.btnPlusMinus:
                number = "-"+number;
                break;
            case R.id.btnDecimal:
                number += ".";
                break;
            case R.id.btnHundred:
                number += "00";
                break;
            case R.id.btnZero:
                number += "0";
                break;
            case R.id.btnOne:
                number += "1";
                break;
            case R.id.btnTwo:
            number += "2";
            break;
            case R.id.btnThree:
                number += "3";
                break;
            case R.id.btnFour:
                number += "4";
                break;
            case R.id.btnFive:
                number += "5";
                break;
            case R.id.btnSix:
                number += "6";
                break;
            case R.id.btnSeven:
                number += "7";
                break;
            case R.id.btnEight:
                number += "8";
                break;
            case R.id.btnNine:
                number += "9";
                break;
        }
        editText.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.btnDivide: op = "/"; break;
            case R.id.btnMultiply: op = "*"; break;
            case R.id.btnPLus: op = "+"; break;
            case R.id.btnMinus: op = "-"; break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result+"");
    }

    public void clearEvent(View view) {
        editText.setText("0");
        isNewOp = true;
    }

    public void percentageEvent(View view) {
        double no = Double.parseDouble(editText.getText().toString())/100;
        editText.setText(no+"");
        isNewOp = true;
    }
}
