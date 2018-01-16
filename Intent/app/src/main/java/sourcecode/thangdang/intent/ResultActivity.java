package sourcecode.thangdang.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView txtKetQua;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKetQua = (TextView)findViewById(R.id.txtKetQua);
        btnBack = (Button)findViewById(R.id.btnBack);

        Intent callerIntent = getIntent();

        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
        final int a = packBundle.getInt("soA");
        final int b = packBundle.getInt("soB");

        giaiPTBN(a,b);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentData = new Intent(ResultActivity.this,MainActivity.class);
                String toast = "Welcome back to MainActivity! Your last edit text : a = "+ a + ", b = " + b;
                Bundle bundle = new Bundle();
                bundle.putString("value", toast);
                startActivityForResult(intentData.putExtras(bundle),1);
                finish();

            }
        });
    }

    public void giaiPTBN(int a, int b){
        if(a == 0) {
            if (b == 0) {
                txtKetQua.setText("Phương trình vô số nghiệm");
                return;
            }else
                txtKetQua.setText("Phương trình vô nghiệm");
        }
        else
            txtKetQua.setText("Kết quả: " + String.valueOf((float)-b/a));
    }


}
