package tw.com.pcschool.dd2017122801;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for);
    }

    public void clickOK(View v)
    {
        Intent it = new Intent();
        EditText et3 = findViewById(R.id.editText3);
        it.putExtra("myResult2", et3.getText().toString());
        setResult(RESULT_OK, it);
        finish();
    }

    public void clickCancel(View v)
    {
        finish();
    }
}
