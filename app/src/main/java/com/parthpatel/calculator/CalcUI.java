package com.parthpatel.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static java.lang.Character.isDefined;

public class CalcUI extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button dot;
    private Button mul;
    private Button add;
    private Button sub;
    private Button div;
    private ImageButton back;
    private Button eql;
    private TextView info;
    private TextView result;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQUAL='=';
    private double val1=Double.NaN;
    private double val2;
    private double val3;
    private char ACTION;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
      // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide(); //hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_ui);
        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!info.getText().toString().contains(".")){
                    info.setText(info.getText().toString()+".");
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name=info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                info.setText(null);
                result.setText(null);
                return false;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals(".")){
                    //do nothing

                }
                else if(!info.getText().equals("")&&result.getText().toString().equals("")){
                    ACTION=ADDITION;
                    val1=Double.parseDouble(info.getText().toString());
                    result.setText(info.getText().toString()+"+");
                    info.setText(null);
                }else if(!result.getText().toString().equals("")&&info.getText().toString().equals("")&&checkSymbol(result)){
                    String s=result.getText().toString();
                    s=s.substring(0,s.length()-1);
                    ACTION=ADDITION;
                    val1=Double.parseDouble(s);
                    info.setText(null);
                    result.setText(s+"+");

                }else if(!result.getText().toString().equals("")&&!checkSymbol(result)){
                    String s=result.getText().toString();
                    result.setText(s+"+");
                    ACTION=ADDITION;
                    val1=Double.parseDouble(s);
                }else if(checkSymbol(result)){
                    result.setText(info.getText().toString()+"+");
                    info.setText(null);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals(".")){
                    //do nothing

                }
                else if(!info.getText().equals("")&&result.getText().toString().equals("")){
                    ACTION=SUBTRACTION;
                    val1=Double.parseDouble(info.getText().toString());
                    result.setText(info.getText().toString()+"-");
                    info.setText("");
                }else if(!result.getText().toString().equals("")&&info.getText().toString().equals("")&&checkSymbol(result)){
                    String s=result.getText().toString();
                    s=s.substring(0,s.length()-1);
                    ACTION=SUBTRACTION;
                    val1=Double.parseDouble(s);
                    info.setText(null);
                    result.setText(s+"-");
                }else if(!result.getText().toString().equals("")&&!checkSymbol(result)){
                    String s=result.getText().toString();
                    result.setText(s+"-");
                    ACTION=SUBTRACTION;
                    val1=Double.parseDouble(s);
                }else if(checkSymbol(result)){
                    result.setText(info.getText().toString()+"-");
                    info.setText(null);
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals(".")){
                    //do nothing

                }
                else if(!info.getText().equals("")&&result.getText().toString().equals("")){
                    ACTION=MULTIPLICATION;
                    val1=Double.parseDouble(info.getText().toString());
                    result.setText(info.getText().toString()+"×");
                    info.setText("");
                }else if(!result.getText().toString().equals("")&&info.getText().toString().equals("")&&checkSymbol(result)){
                    String s=result.getText().toString();
                    s=s.substring(0,s.length()-1);
                    ACTION=MULTIPLICATION;
                    val1=Double.parseDouble(s);
                    info.setText(null);
                    result.setText(s+"×");
                }else if(!result.getText().toString().equals("")&&!checkSymbol(result)){
                    String s=result.getText().toString();
                    result.setText(s+"×");
                    ACTION=MULTIPLICATION;
                    val1=Double.parseDouble(s);
                }else if(checkSymbol(result)){
                    result.setText(info.getText().toString()+"×");
                    info.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals(".")){
                    //do nothing

                }
                else if(!info.getText().equals("")&&result.getText().toString().equals("")){
                    ACTION=DIVISION;
                    val1=Double.parseDouble(info.getText().toString());
                    result.setText(info.getText().toString()+"÷");
                    info.setText("");
                }else if(!result.getText().toString().equals("")&&info.getText().toString().equals("")&&checkSymbol(result)){
                    String s=result.getText().toString();
                    s=s.substring(0,s.length()-1);
                    ACTION=DIVISION;
                    val1=Double.parseDouble(s);
                    info.setText(null);
                    result.setText(s+"÷");
                }else if(!result.getText().toString().equals("")&&!checkSymbol(result)){
                    String s=result.getText().toString();
                    result.setText(s+"÷");
                    ACTION=DIVISION;
                    val1=Double.parseDouble(s);
                }else if(checkSymbol(result)){
                    result.setText(info.getText().toString()+"÷");
                    info.setText(null);
                }

            }
        });
        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals(".")){
                    //do nothing

                }
                else if(!info.getText().equals("")&&(!checkSymbol(result)||result.getText().toString().equals(""))){
                   result.setText(info.getText().toString());
                    info.setText(null);
                }

                else if(!info.getText().equals(""))
                {
                    val2=Double.parseDouble(info.getText().toString());
                    switch(ACTION)
                    {
                        case ADDITION:
                            val3=val1+val2;
                            break;


                        case SUBTRACTION:
                            val3=val1-val2;
                            break;

                        case MULTIPLICATION:
                            val3=val1*val2;
                            break;

                        case '/':
                            val3=val1/val2;
                            break;

                            default:
                                break;
                    }
                    if((val3-(int)val3)==0){
                        int r=(int)val3;
                        info.setText(null);
                        result.setText(String.valueOf(r));
                        ACTION='0';
                    }else if(String.valueOf(val3).length()<=15){

                        info.setText(null);
                        result.setText(String.format("%.6f",val3));
                        ACTION='0';
                    }else{
                        info.setText(null);
                        result.setText(String.valueOf(val3));
                        ACTION='0';
                    }
                }

            }
        });
       /* eql.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    eql.setBackground();

                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    eql.setBackground();
                }
                return false;
            }
        });*/



    }

    private void setupUIViews(){
        zero=(Button)findViewById(R.id.btnZero);
        one=(Button)findViewById(R.id.btnOne);
        two=(Button)findViewById(R.id.btnTwo);
        three=(Button)findViewById(R.id.btnThree);
        four=(Button)findViewById(R.id.btnFour);
        five=(Button)findViewById(R.id.btnFive);
        six=(Button)findViewById(R.id.btnSix);
        seven=(Button)findViewById(R.id.btnSeven);
        eight=(Button)findViewById(R.id.btnEight);
        nine=(Button)findViewById(R.id.btnNine);
        back=(ImageButton)findViewById(R.id.btnBack);
        add=(Button)findViewById(R.id.btnAdd);
        sub=(Button)findViewById(R.id.btnSub);
        mul=(Button)findViewById(R.id.btnMul);
        div=(Button)findViewById(R.id.btnDiv);
        dot=(Button)findViewById(R.id.btnDot);
        eql=(Button)findViewById(R.id.btnEql);
        info=(TextView)findViewById(R.id.tvInfo);
        result=(TextView)findViewById(R.id.tvResult);
    }
    private boolean checkSymbol(TextView t){
        if(t.getText().toString().contains("+")){
            return true;
        }
        else if(t.getText().toString().contains("-")){
            return true;
        }
        else if(t.getText().toString().contains("×")){
            return true;
        }
        else if(t.getText().toString().contains("÷")){
            return true;
        }
        else{
            return false;
        }
    }


}
