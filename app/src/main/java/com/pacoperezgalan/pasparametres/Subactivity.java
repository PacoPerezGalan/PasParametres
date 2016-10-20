package com.pacoperezgalan.pasparametres;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Subactivity extends AppCompatActivity {



    @Override
    protected void onCreate( Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        final Bundle b=getIntent().getExtras();
        setContentView(R.layout.activity_subactivity);

        TextView msg=(TextView) findViewById(R.id.tv_dades);
        msg.setText("Hola "+b.getString("nom")+" , indica'ns les seguents dades:");

        Button cont=(Button) findViewById(R.id.btn_continuar);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edat=(EditText) findViewById(R.id.et_edat);
                b.putInt("edat",Integer.parseInt(edat.getText().toString()));

                Intent i=new Intent();
                i.putExtras(b);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }


}
