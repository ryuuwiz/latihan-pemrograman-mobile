package com.example.myapps;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NIM = "extra_nim";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PRODI = "extra_prodi";

    private TextView textNIM, textNama, textProdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        textNIM.findViewById(R.id.t_nim);
        textNama.findViewById(R.id.t_nama);
        textProdi.findViewById(R.id.t_prodi);

        String nim = getIntent().getStringExtra(EXTRA_NIM);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String prodi = getIntent().getStringExtra(EXTRA_PRODI);

        textNIM.setText("NIM : "+nim);
        textNama.setText("Nama : "+nama);
        textProdi.setText("Program Studi : "+prodi);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}