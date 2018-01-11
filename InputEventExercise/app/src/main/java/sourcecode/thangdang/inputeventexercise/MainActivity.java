package sourcecode.thangdang.inputeventexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = (Button)findViewById(R.id.btn_calculate);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText edtFirstNumber = (EditText) findViewById(R.id.edt_first_number);
        EditText edtSecondNumber = (EditText) findViewById(R.id.edt_second_number);
        int numberA;
        int numberB;
        Toast toast= Toast.makeText(MainActivity.this, "Nhập lại",Toast.LENGTH_SHORT);

        try {
            numberA = Integer.parseInt(edtFirstNumber.getText().toString());
            numberB =  Integer.parseInt(edtSecondNumber.getText().toString());
            int result = numberA + numberB;
            EditText edtResult = (EditText) findViewById(R.id.edt_result);
            edtResult.setText(String.valueOf(result));
        }catch (NumberFormatException e){
            e.getMessage();
            toast.show();
        }catch (NullPointerException e) {
            Log.e("error:anh",e.getMessage());
            toast.show();
        }
    }
}
