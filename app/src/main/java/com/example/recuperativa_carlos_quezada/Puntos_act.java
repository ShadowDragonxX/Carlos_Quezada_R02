package com.example.recuperativa_carlos_quezada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Puntos_act extends AppCompatActivity {
    private EditText txt1;
    private CheckBox ch1,ch2;
    private TextView etxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_act);
        txt1=(EditText) findViewById(R.id.editText5);
        ch1=(CheckBox)findViewById(R.id.checkBox);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        etxt1=(TextView)findViewById(R.id.textView7);

        String user=getIntent().getStringExtra("usuario");
        txt1.setText(user);
    }
    public void Calcular(View view)
    {
        String rut = txt1.getText().toString();
        if(rut.equals("183593897"))
            {
                if(ch1.isChecked() && ch2.isChecked())
                {
                    etxt1.setText("No puede seleccionar los dos");
                }
                else if(!ch1.isChecked()&&!ch2.isChecked())
                {
                    etxt1.setText("Tiene que seleccionar solo uno");
                }

            else if(ch2.isChecked())
            {
                int deuda= 78000;
                int resultado= deuda*2;
                etxt1.setText("No tiene ningun benficio su deuda final es de: "+"\n"+resultado);
            }
            else if(ch1.isChecked())
                {
                    int deuda = 78000;
                    int resultado= deuda/2;
                    etxt1.setText("Tiene beneficio su deuda final es de: "+"\n"+resultado);

                }
        }
        else if (rut.equals("114418455"))
        {
            if(ch1.isChecked() && ch2.isChecked())
            {
                etxt1.setText("No puede seleccionar los dos");
            }
            else if(!ch1.isChecked()&&!ch2.isChecked())
            {
                etxt1.setText("Tiene que seleccionar solo uno");
            }

            else if(ch2.isChecked())
            {
                int deuda= 222000;
                int resultado = deuda*2;
                etxt1.setText("No tiene ningun benficio su deuda final es de: "+"\n"+resultado);
            }
            else if(ch1.isChecked())
            {
                int deuda=222000;
                int resultado= deuda/3;
                etxt1.setText("Tiene beneficio su deuda final es de: "+"\n"+resultado);
            }
        }
    }
}
