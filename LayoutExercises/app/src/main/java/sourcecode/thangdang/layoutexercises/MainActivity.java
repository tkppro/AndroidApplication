package sourcecode.thangdang.layoutexercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnNumber1;
    private Button mBtnNumber2;
    private Button mBtnNumber3;
    private Button mBtnNumber4;
    private Button mBtnNumber5;
    private Button mBtnNumber6;
    private Button mBtnNumber7;
    private Button mBtnNumber8;
    private Button mBtnNumber9;
    private Button mBtnNumber0;

    private Button mBtnPlus;
    private Button mBtnMinus;
    private Button mBtnMultiple;
    private Button mBtnDevide;
    private Button mBtnEqual;
    private Button mBtnDot;
    private Button mBtnSqrt;
    private Button mBtnClear;
    private Button mBtnBack;
    private EditText mEdtInput;
    private TextView mTvResult;

    double a = Double.NaN;
    double b = Double.NaN;
    private boolean mAddition,mSubtraction,mDivision,mMultiplication,mSqrt;
    StringBuilder str = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        mBtnNumber1 = (Button) findViewById(R.id.btn_1);
        mBtnNumber2 = (Button) findViewById(R.id.btn_2);
        mBtnNumber3 = (Button) findViewById(R.id.btn_3);
        mBtnNumber4 = (Button) findViewById(R.id.btn_4);
        mBtnNumber5 = (Button) findViewById(R.id.btn_5);
        mBtnNumber6 = (Button) findViewById(R.id.btn_6);
        mBtnNumber7 = (Button) findViewById(R.id.btn_7);
        mBtnNumber8 = (Button) findViewById(R.id.btn_8);
        mBtnNumber9 = (Button) findViewById(R.id.btn_9);
        mBtnNumber0 = (Button) findViewById(R.id.btn_0);

        mBtnPlus = (Button) findViewById(R.id.btn_plus);
        mBtnMinus = (Button) findViewById(R.id.btn_minus);
        mBtnMultiple = (Button) findViewById(R.id.btn_multiple);
        mBtnDevide = (Button) findViewById(R.id.btn_devide);
        mBtnEqual = (Button) findViewById(R.id.btn_equal);
        mBtnDot = (Button) findViewById(R.id.btn_dot);
        mBtnSqrt = (Button) findViewById(R.id.btn_sqrt);
        mBtnClear = (Button) findViewById(R.id.btn_C);
        mEdtInput = (EditText) findViewById(R.id.edt_input);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mBtnBack = (Button) findViewById(R.id.btn_back);
        setClickListener();
    }

    public void setClickListener(){
        mBtnNumber1.setOnClickListener(this);
        mBtnNumber2.setOnClickListener(this);
        mBtnNumber3.setOnClickListener(this);
        mBtnNumber4.setOnClickListener(this);
        mBtnNumber5.setOnClickListener(this);
        mBtnNumber6.setOnClickListener(this);
        mBtnNumber7.setOnClickListener(this);
        mBtnNumber8.setOnClickListener(this);
        mBtnNumber9.setOnClickListener(this);
        mBtnNumber0.setOnClickListener(this);

        mBtnPlus.setOnClickListener(this);
        mBtnMinus.setOnClickListener(this);
        mBtnMultiple.setOnClickListener(this);
        mBtnDevide.setOnClickListener(this);
        mBtnEqual.setOnClickListener(this);
        mBtnDot.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
        mBtnSqrt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      //  StringTokenizer strT = new StringTokenizer(str.toString(), "+");
        Toast toast= Toast.makeText(MainActivity.this, "Nhập lại",Toast.LENGTH_SHORT);
        try {
        switch (view.getId()) {
            case R.id.btn_1:
                mEdtInput.append("1");
                break;
            case R.id.btn_2:
                mEdtInput.append("2");
                break;
            case R.id.btn_3:
                mEdtInput.append("3");
                break;
            case R.id.btn_4:
                mEdtInput.append("4");
                break;
            case R.id.btn_5:

                mEdtInput.append("5");
                break;
            case R.id.btn_6:
                mEdtInput.append("6");
                break;
            case R.id.btn_7:

                mEdtInput.append("7");
                break;
            case R.id.btn_8:
                mEdtInput.append("8");
                break;
            case R.id.btn_9:
                mEdtInput.append("9");
                break;
            case R.id.btn_0:
                mEdtInput.append("0");
                break;
            case R.id.btn_plus :
                mAddition = true;
                if(!Double.isNaN(a)){
                    b = Double.parseDouble(mEdtInput.getText().toString());
                    a = a + b;
                }
                else
                    a = Double.parseDouble(mEdtInput.getText().toString());
                mTvResult.setText(a + " + ");
                mEdtInput.setText(null);
                break;

            case R.id.btn_minus:
                mSubtraction = true;
                if(!Double.isNaN(a)){
                    b = Double.parseDouble(mEdtInput.getText().toString());
                    a = a - b;
                }
                else
                    a = Double.parseDouble(mEdtInput.getText().toString());
                mTvResult.setText(a + " - ");
                mEdtInput.setText(null);
                break;
            case R.id.btn_multiple:
                mMultiplication = true;
                if(!Double.isNaN(a)){
                    b = Double.parseDouble(mEdtInput.getText().toString());
                    a = a * b;
                }
                else
                    a = Double.parseDouble(mEdtInput.getText().toString());
                mTvResult.setText(a + " * ");
                mEdtInput.setText(null);
                break;
            case R.id.btn_devide:
                mDivision = true;
                if(!Double.isNaN(a)){
                    b = Double.parseDouble(mEdtInput.getText().toString());
                    a = a / b;
                }
                else
                    a = Double.parseDouble(mEdtInput.getText().toString());
                mTvResult.setText(a + " / ");
                mEdtInput.setText(null);
                break;
            case R.id.btn_equal:
                if(mAddition == true){
                    mTvResult.setText(null);
                    double b = Double.parseDouble(mEdtInput.getText().toString());
                    double result = a + b;
                    mTvResult.setText(a + " + " + b + " = ");
                    mEdtInput.setText(String.valueOf(result));
                    mAddition = false;
                }
                if(mSubtraction == true){
                    mTvResult.setText(null);
                    double b = Double.parseDouble(mEdtInput.getText().toString());
                    double result = a - b;
                    mTvResult.setText(a + " - " + b + " = ");
                    mEdtInput.setText(String.valueOf(result));
                    mSubtraction = false;
                }
                if(mMultiplication == true){
                    mTvResult.setText(null);
                    double b = Double.parseDouble(mEdtInput.getText().toString());
                    double result = a * b;
                    mEdtInput.setText(String.valueOf(result));
                    mTvResult.setText(a + " * " + b + " = ");
                    mMultiplication = false;
                }
                if(mDivision == true){
                    mTvResult.setText(null);
                    try {
                        double b = Double.parseDouble(mEdtInput.getText().toString());
                        double result = a / b;
                        mTvResult.setText(a + " / " + b + " = ");
                        mEdtInput.setText(String.valueOf(result));
                        mDivision = false;
                    }catch (ArithmeticException e){
                    }
                }
                if (mSqrt == true && !Double.isNaN(a)){
                    double result = Math.sqrt(a);
                    mEdtInput.setText(String.valueOf(result));
                    mTvResult.setText(null);
                    mSqrt = false;
                }
                a = Double.NaN;
                mEdtInput.setSelection(mEdtInput.getText().length());
                break;
            case R.id.btn_sqrt :
                mEdtInput.append("√");
                mSqrt = true;

                break;
            case R.id.btn_one_devide_x :
                break;
            case R.id.btn_percent :
                break;

            case R.id.btn_dot :
                mEdtInput.append(".");
                break;
            case R.id.btn_C :
                a = Double.NaN;
                mTvResult.setText("");
                mEdtInput.setText("");
                break;
            case R.id.btn_CE :
                mEdtInput.setText(null);
                break;
            case R.id.btn_back :
                if(mEdtInput.getText().toString().length()!=0){
                    StringBuilder strB = new StringBuilder(mEdtInput.getText().toString());
                    strB.deleteCharAt(mEdtInput.getText().toString().length() - 1);
                    mEdtInput.setText(strB.toString());
                }
                else
                   break;
        }
        }catch (NumberFormatException e){
            toast.show();
        }
    }

//    public float convertStringToNumber(StringBuilder string){
//        float numberC = 0;
//        String save; // luu dau
//        StringTokenizer st=new StringTokenizer(string.toString());
//        while(st.hasMoreTokens())
//        {
//            String token = st.nextToken().trim();
//            if(!token.equals("+")) {
//                mNumberA = Integer.parseInt(token);
//                numberC = numberC + mNumberA;
//            }
//        }
//
//        return numberC;
//    }
}





