package tw.com.pcschool.dd2017122801;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv1;
    TextView tv2;
    TextView tv3;
    final int REQUEST_CODE_PAGE2 = 123;
    final int REQUEST_CODE_PAGE3 = 456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView3);
        tv3 = (TextView)findViewById(R.id.textView4);
    }
    public void click1(View v)
    {
        tv1.setText(String.valueOf("Good Morning!"));
    }

    public void click2(View v)
    {
        EditText et = findViewById(R.id.editText);
        Intent it = new Intent(MainActivity.this, SecActivity.class);
        it.putExtra("data",et.getText().toString());
        startActivity(it);
    }

    public void click3(View v)
    {
        Intent it2 = new Intent(MainActivity.this, ThiActivity.class);
        //startActivity(it2);    //只能傳過去不能傳回來
        startActivityForResult(it2, REQUEST_CODE_PAGE2);
    }

    public void click4(View v)
    {
        Intent it3 = new Intent(MainActivity.this, ForActivity.class);
        startActivityForResult(it3, REQUEST_CODE_PAGE3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_PAGE2)
        {
            if (resultCode == RESULT_OK)
            {
                tv2.setText(data.getStringExtra("myResult"));
            }
        }
        if(requestCode == REQUEST_CODE_PAGE3)
        {
            if (resultCode == RESULT_OK)
            {
                tv3.setText(data.getStringExtra("myResult2"));
            }
        }
        /*if (resultCode == RESULT_OK)     //這樣就另外一個textview就會重設
                    {
                         tv2.setText(data.getStringExtra("myResult"));
                         tv3.setText(data.getStringExtra("myResult2"));
                    }*/
    }
}
