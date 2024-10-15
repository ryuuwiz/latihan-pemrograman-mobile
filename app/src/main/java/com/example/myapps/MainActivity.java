package com.example.myapps;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editNIM;
    private EditText editNama;
    private EditText editProdi;
    private TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editNIM = findViewById(R.id.nim);
        editNama = findViewById(R.id.nama);
        editProdi = findViewById(R.id.prodi);
        textHasil = findViewById(R.id.textHasil);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void simpanData(View view) {
        String nim = editNIM.getText().toString().trim();
        String nama = editNama.getText().toString().trim();
        String prodi = editProdi.getText().toString().trim();
        boolean isEmptyfields = false;

        if (TextUtils.isEmpty(nim))
        {
            isEmptyfields = true;
            editNIM.setError("Textbox NIM tidak boleh kosong");
        }
        else if (TextUtils.isEmpty(nama))
        {
            isEmptyfields = true;
            editNama.setError("Textbox Nama tidak boleh kosong");
        }
        else if (TextUtils.isEmpty(prodi))
        {
            isEmptyfields = true;
            editProdi.setError("Textbox Prodi tidak boleh kosong");
        }
        if (!isEmptyfields)
        {
            textHasil.setText("NIM : " +nim+" Nama : "+nama+" Prodi : "+prodi);
        }
    }
}