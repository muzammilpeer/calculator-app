package com.salary.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tvResult = (TextView)findViewById(R.id.tvResult);
        tvResult.setText("");

    }


    //Click listner for all buttons // identify it by ID
    public void onClickCalculator(View view)
    {
        Button button = (Button)view;
        switch (view.getId())
        {
            case R.id.b_7 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_8 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_9 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_4 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_5 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_6 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_1 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_2 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_3 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;
            case R.id.b_dot :
            {
                if (isTwoOperandOperator(tvResult.getText().toString()))
                {
                    if (countSubstring(".",getTwoOperands(tvResult.getText().toString())[1] ) < 1)
                    {
                        tvResult.setText(tvResult.getText() + button.getText().toString());
                    }

                }else
                {
                    if (countSubstring(".",tvResult.getText().toString()) < 1)
                    {
                        tvResult.setText(tvResult.getText() + button.getText().toString());
                    }  //else ignore the dots
                }
            }break;
            case R.id.b_0 :
            {
                tvResult.setText(tvResult.getText() + button.getText().toString());
            }break;


            //operations
            case R.id.b_equal :
            {
                tvResult.setText(performCalculation(tvResult.getText().toString()));
            }break;

            case R.id.b_del :
            {
                //clear the screen
                tvResult.setText("");
            }break;
            case R.id.b_divide :
            {
                if (hasOperator(tvResult.getText().toString()) == false)
                {
                    tvResult.setText(tvResult.getText().toString() + button.getText().toString() +"");
                }else if (hasOperator(tvResult.getText().toString()) == true && isTwoOperandOperator(tvResult.getText().toString())){
                    tvResult.setText(performCalculation(tvResult.getText().toString()) + button.getText().toString() +"");
                }


            }break;
            case R.id.b_multiply :
            {
                if (hasOperator(tvResult.getText().toString()) == false)
                {
                    tvResult.setText(tvResult.getText().toString() + button.getText().toString() +"");
                }else if (hasOperator(tvResult.getText().toString()) == true && isTwoOperandOperator(tvResult.getText().toString())){
                    tvResult.setText(performCalculation(tvResult.getText().toString()) + button.getText().toString() +"");
                }


            }break;
            case R.id.b_minus :
            {
                if (hasOperator(tvResult.getText().toString()) == false)
                {
                    tvResult.setText(tvResult.getText().toString() + button.getText().toString() +"");
                }else if (hasOperator(tvResult.getText().toString()) == true && isTwoOperandOperator(tvResult.getText().toString())){
                    tvResult.setText(performCalculation(tvResult.getText().toString()) + button.getText().toString() +"");
                }

            }break;
            case R.id.b_plus :
            {
                if (hasOperator(tvResult.getText().toString()) == false)
                {
                    tvResult.setText(tvResult.getText().toString() + button.getText().toString() +"");
                }else if (hasOperator(tvResult.getText().toString()) == true && isTwoOperandOperator(tvResult.getText().toString())){
                    tvResult.setText(performCalculation(tvResult.getText().toString()) + button.getText().toString() +"");
                }

            }break;

        }




    }

    private  int countSubstring(String subStr, String str){
        return (str.length() - str.replace(subStr, "").length()) / subStr.length();
    }

    private boolean hasOperator(String result)
    {
        if(countSubstring("÷",tvResult.getText().toString())  >= 1)
        {
            return true;
        }else if (countSubstring("x",tvResult.getText().toString())  >= 1)
        {
            return true;
        }else if (countSubstring("-",tvResult.getText().toString())  >= 1)
        {
            return true;
        }else if (countSubstring("+",tvResult.getText().toString())  >= 1)
        {
            return true;
        }

        return false;
    }

    private String performCalculation(String result)
    {
        if (result != null && result.length() > 0)
        {
            //if operator has only one operand then do allow typing
            //if operator have 2 operands then perform calculation and show the result to screen

           if (isTwoOperandOperator(result))
           {
               //do perform calculation
               String operator = getOperatorFromTwoOperands(result);
               String[] operands = getTwoOperands(result);

               if (operator != null)
               {
                   if (operator == "\\÷") {
                    return Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]) +"";
                   }else if (operator == "x") {
                       return Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]) +"";
                   }else if (operator == "\\-") {
                       return Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]) +"";
                   }else if (operator == "\\+") {
                       return Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]) +"";
                   }
               }
           }
        }

        return result +"";
    }

    private boolean isTwoOperandOperator(String result)
    {
        if (result.split("\\÷").length == 2 )
            return true;
        if (result.split("x").length == 2 )
            return true;
        if (result.split("\\-").length == 2 )
            return true;
        if (result.split("\\+").length == 2 )
            return true;

        return false;
    }



    private String getOperatorFromTwoOperands(String result)
    {
        if (result.split("\\÷").length == 2 )
            return "\\÷";
        if (result.split("x").length == 2 )
            return "x";
        if (result.split("\\-").length == 2 )
            return "\\-";
        if (result.split("\\+").length == 2 )
            return "\\+";

        return null;
    }

    private String[] getTwoOperands(String result)
    {
        if (result.split("\\÷").length == 2 )
            return result.split("\\÷");
        if (result.split("x").length == 2 )
            return result.split("x");
        if (result.split("\\-").length == 2 )
            return result.split("\\-");
        if (result.split("\\+").length == 2 )
            return result.split("\\+");

        return null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
