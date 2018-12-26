package hrco.dietapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Homeactivity extends AppCompatActivity {
    private static  int splash_time=3000;
    LinearLayout linearlayout;
    int l=0;

    EditText e1,e2;
    TextView tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        linearlayout=findViewById(R.id.linearlayout);
        e1 =(EditText) findViewById(R.id.et1);
        e2=(EditText) findViewById(R.id.et2);
        tv5=(TextView) findViewById(R.id.tv5);
        Button ib1=findViewById(R.id.ib1);
        Button ib2=findViewById(R.id.ib2);

      ib1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              hideKeyboard(getApplicationContext(),v);
          }
      });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(l==0)
                {

                    Toast.makeText(Homeactivity.this,"Please enter your parametres",Toast.LENGTH_LONG).show();
                }
                if(l==1) {
                    e1.setText("");
                    e2.setText("");
                    tv5.setText("");
                    Intent i = new Intent(getApplicationContext(), Severe_underweight.class);
                    startActivity(i);
                    l=0;

                    e1.setHint("IN KGs");
                    e2.setHint("IN cm ");

                }
                else if(l==2)
                {
                    e1.setText("");
                    e2.setText("");
                    tv5.setText("");
                    Intent i=new Intent(getApplicationContext(),Normal.class);
                    startActivity(i);
                    l=0;
                    e1.setHint("IN KGs");
                    e2.setHint("IN cm ");

                }
                else if(l==3)
                {
                    e1.setText("");
                    e2.setText("");
                    tv5.setText("");
                    Intent i=new Intent(getApplicationContext(),obese_plan.class);
                    startActivity(i);
                    l=0;
                    e1.setHint("IN KGs");
                    e2.setHint("IN cm ");
                }
            }
        });
    }
    public void calculate()
    {
        String str1=e1.getText().toString();
        String str2=e2.getText().toString();

        if(TextUtils.isEmpty(str1))
        {
            e1.setError("Please enter your weight");
            e1.requestFocus();
            return;
        }
        if(TextUtils.isEmpty((str2)))
        {
            e2.setError("Please enter your hight");
            e2.requestFocus();
            return;
        }
        float weight=Float.parseFloat(str1);
        float height=Float.parseFloat(str2)/100;

        float bmi=calculateBMI(weight,height);
        if(bmi<18.5)
        {
            l=1;
        }
        else if(bmi>=18.5 && bmi<25)
        {
            l=2;
        }
        else
        {
            l=3;
        }

        String bmiinterpret=interpretBMI(bmi);

        tv5.setText(String.valueOf(bmi +"-"+bmiinterpret));
    }

    private float calculateBMI(float weight,float height)
    {
        return (float)(weight/(height*height));
    }
    private String interpretBMI(float bmivalue)
    {
        if(bmivalue <18.5)
        {
            return "Underweight";
        }
        else if(bmivalue <25)
        {
            return "Normal";
        }
        else if(bmivalue <30)
        {
            return "Overweight";
        }
        else
        {
            return "Obese";
        }
    }

    public void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        calculate();
    }

}
