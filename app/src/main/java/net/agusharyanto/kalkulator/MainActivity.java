package net.agusharyanto.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBil1;
    private EditText editTextBil2;
    private EditText editTextBilHasil;
    private Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextBil1 = (EditText) findViewById(R.id.editTextBil1);
        editTextBil2 = (EditText) findViewById(R.id.editTextBil2);
        editTextBilHasil = (EditText) findViewById(R.id.editTextHasil);
        buttonTambah = (Button) findViewById(R.id.buttonTambah);
        buttonKurang = (Button) findViewById(R.id.buttonKurang);
        buttonBagi = (Button) findViewById(R.id.buttonBagi);
        buttonKali = (Button) findViewById(R.id.buttonKali);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("+");
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("-");
            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("x");
            }
        });
        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("/");
            }
        });
    }

    private void hitung(String arg) {
        //haloskkks
        if (isValidInput()) {
            float bil1 = Float.parseFloat(editTextBil1.getText().toString());
            float bil2 = Float.parseFloat(editTextBil2.getText().toString());
            float hasil = 0;
            if (arg.equals("+")) {
                hasil = bil1 + bil2;
            } else if (arg.equals("-")) {
                hasil = bil1 - bil2;
            } else if (arg.equals("x")) {
                hasil = bil1 * bil2;
            } else if (arg.equals("/")) {
                hasil = bil1 / bil2;
            }
            editTextBilHasil.setText(String.valueOf(hasil));
        }

    }

    private boolean isValidInput(){
        boolean bret = true;
        if (editTextBil1.getText().toString().equals("")){
            Toast.makeText(getBaseContext(),"Bilangan 1 harus diisi", Toast.LENGTH_SHORT).show();
            bret = false;
        }else if (editTextBil2.getText().toString().equals("")){
            editTextBil2.setError("Bilangan 2 harus diisi");
            bret = false;
        }
        return bret;

    }

}
