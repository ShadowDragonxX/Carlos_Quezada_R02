package com.example.recuperativa_carlos_quezada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ProgressBar pbr;
    private EditText txt1;
    private EditText txt2;
    private TextView txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbr=(ProgressBar)findViewById(R.id.progressBar);
        txt1=(EditText)findViewById(R.id.editText);
        txt2=(EditText)findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.button4) ;
        txt3=(TextView)findViewById(R.id.textView);
        txt3.setVisibility(View.INVISIBLE);
        pbr.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(txt1.getText().toString());
            }
        });
    }
    class Task extends AsyncTask<String, Void,String>
    {
        protected void onPreExecute()
        {
            pbr.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }
        protected String doInBackground(String...String)
        {
            try
            {
                for(int i =0;i>10; i++)
                {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String s)
        {
            pbr.setVisibility(View.VISIBLE);
            Toast.makeText(getBaseContext(), "Acceso garantizado", Toast.LENGTH_SHORT).show();

            btn.setEnabled(true);

            String user = txt1.getText().toString();
            String pass = txt2.getText().toString();

            if(user.equals("114418455")&& pass.equals("123")||user.equals("183593897")&& pass.equals("123")) {
                Intent i = new Intent(getBaseContext(), HOME_act.class);
                String rellenar[] = {"Deudas Pendientes","Beneficios"};
                i.putExtra("usuario", user);
                i.putExtra("pass", pass);
                i.putExtra("rellenar",rellenar);
                startActivity(i);
            }
            else{
                Toast.makeText(getBaseContext(), "Usuario o contraseña ingresado incorrectamente", Toast.LENGTH_SHORT).show();
                if(pass.equals("123")) {
                    txt3.setVisibility(View.INVISIBLE);
                }
                else
                {
                    txt3.setVisibility(View.VISIBLE);
                }
            }

        }
    }
}
