package com.example.recuperativa_carlos_quezada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HOME_act extends AppCompatActivity {
    private Spinner sp;
    private TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);
        sp=(Spinner)findViewById(R.id.spinner);
        txt1=(TextView)findViewById(R.id.textView2);

        String user=getIntent().getStringExtra("usuario");
        txt1.setText(user);
        String rellenar=getIntent().getStringExtra("rellenar");
        Bundle list=  getIntent().getExtras();
        String[] arrayList= list.getStringArray("rellenar");

        ArrayAdapter adpt = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        sp.setAdapter(adpt);
    }
    public void Call(View view)
    {
        Intent i =new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+"6803906000"));
        startActivity(i);
    }
    public void Web(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://simple.ripley.cl/"));
        startActivity(i);
    }
    public void Enviar(View view)
    {
        if(sp.getSelectedItem().equals("Deudas Pendientes"))
        {
            Intent i = new Intent(getBaseContext(),Deudas_act.class);
            String numeros[]={"1","2"};
            String palabra[] ={"Pagar en Cuotas","Pagar todo"};
            i.putExtra("numero",numeros);
            i.putExtra("palabra",palabra);
            startActivity(i);
        }
        else if(sp.getSelectedItem().equals("Beneficios"))
        {
            String user=getIntent().getStringExtra("usuario");
            Intent i = new Intent(getBaseContext(),Puntos_act.class);
            i.putExtra("usuario",user);
            startActivity(i);
        }
    }
}
