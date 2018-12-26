package hrco.dietapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearlayout;
    Handler handler=new Handler();
    private static  int splash_time=2000;
    EditText e1;
    TextView tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,Homeactivity.class);
                startActivity(i);
                finish();
            }
        },splash_time);
    }
}
