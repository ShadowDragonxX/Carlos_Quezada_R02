package com.example.recuperativa_carlos_quezada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Deudas_act extends AppCompatActivity {
    private Spinner sp,sp2;
    private EditText txt1,txt2;
    private TextView etxt1,etxt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudas_act);
        sp=(Spinner)findViewById(R.id.spinner2);
        sp2=(Spinner)findViewById(R.id.spinner3);
        txt1=(EditText)findViewById(R.id.editText3);
        txt2=(EditText)findViewById(R.id.editText4);
        etxt1=(TextView)findViewById(R.id.textView5);
        etxt2=(TextView)findViewById(R.id.textView6);


        String arrayNumeros= getIntent().getStringExtra("numero");
        String arrayPalabra=getIntent().getStringExtra("palabra");

        Bundle list=  getIntent().getExtras();
        String[] arrayList= list.getStringArray("numero");
        Bundle list2=  getIntent().getExtras();
        String[] arrayList2= list2.getStringArray("palabra");

        ArrayAdapter adpt = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        sp.setAdapter(adpt);

        ArrayAdapter adpt2 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList2);
        sp2.setAdapter(adpt2);

    }
    public void Calcular(View view)
    {
        if(sp.getSelectedItem().equals("1")&& sp2.getSelectedItem().equals("Pagar en Cuotas"))
        {
            int deuda = Integer.parseInt(txt1.getText().toString());
            int saldo = Integer.parseInt(txt2.getText().toString());
            int resultado = saldo-deuda;
            int resultado2 = resultado-deuda;
            if(resultado>0) {
                etxt1.setText("Deuda base: " + deuda + "\n" +
                        "Deuda final 1 cuota: " + deuda + "\n" +
                        "Si posee saldo para pagar la deuda"+"\n"+
                        "quedando su saldo en: "+resultado2);
            }
            else
            {
                etxt1.setText("Deuda base: " + deuda + "\n" +
                        "Deuda final 1 cuota: " + resultado + "\n" +
                        "No posee saldo para pagar la deuda"+"\n"+
                        "quedando su saldo en: "+resultado2);
            }


        }
        else if(sp.getSelectedItem().equals("2") && sp2.getSelectedItem().equals("Pagar en Cuotas"))
        {
            int deuda = Integer.parseInt(txt1.getText().toString());
            int deuda2= deuda/2;
            int saldo = Integer.parseInt(txt2.getText().toString());
            int resultado= saldo-deuda;
            int resultado2= saldo-deuda;
            if(resultado>0) {
                etxt1.setText("Deuda base: " + deuda + "\n" +
                        "Deuda final 2 cuota: " + deuda2 + "\n" +
                        "Si posee saldo para pagar la deuda"+"\n"+
                        "quedando su saldo en: "+resultado2);
            }
            else
            {
                etxt1.setText("Deuda base: " + deuda + "\n" +
                        "Deuda final 2 cuota: " + deuda2 + "\n" +
                        "No posee saldo para pagar la deuda"+"\n"+
                        "quedando su saldo en: "+resultado2);
            }
        }
        else if(sp2.getSelectedItem().equals("Pagar todo"))
        {
            txt1.setText("640000");
            int saldo = Integer.parseInt(txt2.getText().toString());
            int deuda = 64000;
            int resultado=saldo - deuda;
            int resultado2 = saldo - deuda;
            if(saldo<deuda)
            {
                etxt1.setText("Saldo insuficiente, quedando su saldo en: "+"\n"+ resultado2);
            }
            else
            {
                etxt1.setText("El saldo restante es de: "+resultado2);
            }

        }
    }
}
