package info.duhovniy.maxim.myaccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    final int MENU_CLEAR_ID = 1;
    final int MENU_EXIT_ID = 2;
    final int MAX_RESULT_LENGTH = 12;
    final String KEY_RESULT_VALUE = "resultValue";
    final String KEY_NUM1_VALUE = "num1Value";
    final String KEY_INPUT_LIST = "inputList";

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button but0;
    private Button butDot;
    private Button butEqual;
    private Button butAdd;
    private Button butMult;
    private Button butDiv;
    private Button butSub;
    private Button butDel;

    private TextView textInput;
    private TextView textResult;

    private LinkedList oper = new LinkedList<>();
    private double num1 = 0;
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        but1 = (Button) findViewById(R.id.button1);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);
        but4 = (Button) findViewById(R.id.button4);
        but5 = (Button) findViewById(R.id.button5);
        but6 = (Button) findViewById(R.id.button6);
        but7 = (Button) findViewById(R.id.button7);
        but8 = (Button) findViewById(R.id.button8);
        but9 = (Button) findViewById(R.id.button9);
        but0 = (Button) findViewById(R.id.button0);
        butDel = (Button) findViewById(R.id.buttonDel);
        butEqual = (Button) findViewById(R.id.buttonEqual);
        butDot = (Button) findViewById(R.id.buttonDot);
        butAdd = (Button) findViewById(R.id.buttonAdd);
        butMult = (Button) findViewById(R.id.buttonMult);
        butSub = (Button) findViewById(R.id.buttonSub);
        butDiv = (Button) findViewById(R.id.buttonDiv);

        textInput = (TextView) findViewById(R.id.textView);
        textResult = (TextView) findViewById(R.id.resultView);

        if(savedInstanceState != null){
            oper = (LinkedList) savedInstanceState.getSerializable(KEY_INPUT_LIST);
            result = savedInstanceState.getDouble(KEY_RESULT_VALUE, 0);
            num1 = savedInstanceState.getDouble(KEY_NUM1_VALUE, 0);

            textInput.setText(listToString(oper));
            textResult.setText(String.valueOf(result));
        }

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but0.setOnClickListener(this);
        butDel.setOnClickListener(this);
        butEqual.setOnClickListener(this);
        butDot.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butMult.setOnClickListener(this);
        butSub.setOnClickListener(this);
        butDiv.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_CLEAR_ID, 0, "Clear");
        menu.add(0, MENU_EXIT_ID, 0, "Exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case MENU_CLEAR_ID:
                oper.clear();
                result = 0;
                num1 = 0;
                textInput.setText(listToString(oper));
                textResult.setText(String.valueOf(result));
                break;
            case MENU_EXIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        char newChar = ' ';

        switch(v.getId()) {
            case R.id.button1:
                newChar = '1';
                break;
            case R.id.button2:
                newChar = '2';
                break;
            case R.id.button3:
                newChar = '3';
                break;
            case R.id.button4:
                newChar = '4';
                break;
            case R.id.button5:
                newChar = '5';
                break;
            case R.id.button6:
                newChar = '6';
                break;
            case R.id.button7:
                newChar = '7';
                break;
            case R.id.button8:
                newChar = '8';
                break;
            case R.id.button9:
                newChar = '9';
                break;
            case R.id.button0:
                newChar = '0';
                break;
            case R.id.buttonDot:
                newChar = '.';
                break;
            case R.id.buttonEqual:
                if (!oper.isEmpty() && (oper.contains('/') || oper.contains('+')
                        || oper.contains('x') || oper.contains('-'))) {
                    calculateResult();
                    num1 = 0;
                    oper.clear();
                    for(int i = 0; i < String.valueOf(result).length(); i++) {
                        oper.add(String.valueOf(result).charAt(i));
                    }
                    result = 0;
                }
                break;
            case R.id.buttonDel:
                if (!oper.isEmpty())
                    oper.removeLast();
                break;
            case R.id.buttonAdd:
                if (!oper.isEmpty()) {
                    newChar = '+';
                    if(num1 == 0) {
                        num1 = Double.valueOf(listToString(oper));
                    }
                }
                break;
            case R.id.buttonMult:
                if (!oper.isEmpty()) {
                    newChar = 'x';
                    if(num1 == 0) {
                        num1 = Double.valueOf(listToString(oper));
                    }
                }
                break;
            case R.id.buttonSub:
                if (!oper.isEmpty()) {
                    newChar = '-';
                    if(num1 == 0) {
                        num1 = Double.valueOf(listToString(oper));
                    }
                }
                break;
            case R.id.buttonDiv:
                if(!oper.isEmpty()) {
                    newChar = '/';
                    if(num1 == 0) {
                        num1 = Double.valueOf(listToString(oper));
                    }
                }
                break;
            default:
                break;
        }
        if((oper.size() < MAX_RESULT_LENGTH) && (newChar != ' ')) {
            oper.add(newChar);
        }

        calculateResult();

        textResult.setText(String.valueOf(result));

        textInput.setText(listToString(oper));
    }

    String listToString(LinkedList l) {
        String res = "";

        for(int i = 0; i < l.size(); i++) {
            res += l.get(i);
        }
        return res;
    }

    void calculateResult() {
        String res = "";
        boolean start = false;
        Character operName = ' ';
        double num2;

        for(int i = 0; i < oper.size(); i++) {
            if(start) if ((Character) oper.get(i) == '+' || (Character) oper.get(i) == '/'
                    || (Character) oper.get(i) == 'x' || (Character) oper.get(i) == '-') {
                //    oper.clear();
//                    for(int j = 0; j < res.length(); j++)
//                        oper.add(res.charAt(j));
            } else
                res += oper.get(i);
            if((Character)oper.get(i) == '+' || (Character)oper.get(i) == '/'
                    || (Character)oper.get(i) == 'x' || (Character)oper.get(i) == '-') {
                start = true;
                operName = (Character) oper.get(i);
            }
        }
        if(!res.equals("")) {

            num2 = Double.valueOf(res);
            switch (operName) {
                case '+':
                    result = num1 + num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    }
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                default:

                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(KEY_RESULT_VALUE, result);
        outState.putSerializable(KEY_INPUT_LIST, oper);
        outState.putDouble(KEY_NUM1_VALUE, num1);
    }
}
