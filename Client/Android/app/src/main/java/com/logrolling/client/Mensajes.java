package com.logrolling.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Mensajes extends AppCompatActivity {
    private ListView listaChat;
    private String[]chats={"Luis","Felipe","Olga","Luis","Felipe","Luis","Felipe","Luis","Felipe","Luis","Felipe",
            "Luis","Felipe","Luis","Felipe","Olga","Luis","Felipe","Luis","Felipe","Luis","Felipe","Luis","Felipe","Luis","Felipe","Luis","Felipe"};
    private TextView numGrollies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);
        listaChat=(ListView)findViewById(R.id.ListaMensajes);

        numGrollies=(TextView)findViewById(R.id.grollies);
        numGrollies.setText("");//Pedir el número de grollies a quien sea

        ArrayAdapter<String> adapter=new ArrayAdapter(this,R.layout.list_favores, chats);
        listaChat.setAdapter(adapter);
        listaChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Lo que sea
                Intent i = new Intent(Mensajes.this, ChatPersona.class);
                startActivity(i);
            }
        });
    }

    //Panel Inferior
    public void regalos(View view) {
        Intent i = new Intent(this, Regalos.class);
        startActivity(i);
    }
    public void misFavores(View view) {
        Intent i = new Intent(this, MisFavores.class);
        startActivity(i);
    }
    public void favores(View view) {
        Intent i = new Intent(this, Favores.class);
        startActivity(i);

    }
    public void configuracion(View view) {
        Intent i = new Intent(this, Configuracion.class);
        startActivity(i);
    }



    public void comprarGrollies(View view) {
        Intent i = new Intent(this, Tienda.class);
        startActivity(i);
    }


}
