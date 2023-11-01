package com.example.project_1;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_1.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;
    private TextView et_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        et_nombre = (TextView)findViewById(R.id.TextNombre);

    }
    public void Registrar(View View){
        AdminSQL admin =  new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        if (!nombre.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
           baseDeDatos.insert("tareas",null, registro);
           baseDeDatos.close();
           et_nombre.setText("");
            Toast.makeText(this, "El registro fye exitoso", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

}