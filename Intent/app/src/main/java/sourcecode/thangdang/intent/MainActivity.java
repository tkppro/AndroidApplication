package sourcecode.thangdang.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnKetQua;
    EditText txta, txtb;
    int a,b;
    private static final int REQ_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta = (EditText)findViewById(R.id.edtSoA);
        txtb = (EditText)findViewById(R.id.edtSoB);
        btnKetQua = (Button)findViewById(R.id.btnKetQua);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(txta.getText().toString());
                    int b = Integer.parseInt(txtb.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("soA",a);
                    bundle.putInt("soB",b);

                    myIntent.putExtra("MyPackage",bundle);
                    startActivityForResult(myIntent,REQ_CODE);
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(this.getIntent().getExtras() != null){
            txta.setText("0");
            txtb.setText("0");
            Toast.makeText(this,this.getIntent().getExtras().getString("value")
                    ,Toast.LENGTH_LONG).show();
        }
    }


}
