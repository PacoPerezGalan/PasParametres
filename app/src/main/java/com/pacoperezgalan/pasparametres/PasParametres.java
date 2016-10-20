package com.pacoperezgalan.pasparametres;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PasParametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pas_parametres);

        Button enviar=(Button) findViewById(R.id.btn_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                EditText n=(EditText)findViewById(R.id.et_nom);
                b.putString("nom",n.getText().toString());

                Intent sa = new Intent(getApplicationContext(), Subactivity.class);
                sa.putExtras(b);

                startActivityForResult(sa, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b=data.getExtras();
        int edat=b.getInt("edat");
        TextView dades=(TextView)findViewById(R.id.tv_dades);

        if(edat<18){
            dades.setText("Com tens "+edat+" anys, eres menor de edat");
        }else if(edat>=18 && edat<25){
            dades.setText("Com tens "+edat+" anys, ja eres major de edat");
        }else if(edat>=25 && edat<35){
            dades.setText("Com tens "+edat+" anys, estas en la flor de la vida");
        }else{
            dades.setText("Com tens "+edat+" anys, ai, ai, ai....");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView dades=(TextView) findViewById(R.id.tv_dades);
        outState.putString("dades", dades.getText().toString());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView dades=(TextView) findViewById(R.id.tv_dades);
        dades.setText(savedInstanceState.getString("dades"));
    }
}
