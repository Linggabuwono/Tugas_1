package com.example.pendaftaran;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup ;
    RadioButton radioButton;

    TextView Hasil;
    AlertDialog dialog;
    LayoutInflater inflater;
    View dialogView;

    Button bttnDaftar, bttnKembali;

    Calendar calendar;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener setListener;

    EditText NamaDepan, NamaBelakang, Tempatlahir, Tanggallahir,
            Alamat, Telephone, Email, Password, RePassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttnDaftar = findViewById(R.id.Daftar);
        bttnKembali = findViewById(R.id.Kembali);
        NamaDepan = findViewById(R.id.namadepan);
        NamaBelakang = findViewById(R.id.namabelakang);
        Tempatlahir = findViewById(R.id.tempatlahir);
        Tanggallahir = findViewById(R.id.date);
        Alamat = findViewById(R.id.alamat);
        Telephone = findViewById(R.id.telephon);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        RePassword = findViewById(R.id.repassword);


//------------------------------------------------------------------------------------
        radioGroup = findViewById(R.id.radgrJK);
        radioGroup = findViewById(R.id.radgr1);
        radioGroup = findViewById(R.id.radgr2);
        radioGroup = findViewById(R.id.radgr3);


//------------------------------------------------------------------------------------
        radioButton = findViewById(R.id.radbu1);
        radioButton = findViewById(R.id.radbu2);
        radioButton = findViewById(R.id.radbu3);
        radioButton = findViewById(R.id.radbu4);
        radioButton = findViewById(R.id.radbu5);
        radioButton = findViewById(R.id.radbu6);
        radioButton = findViewById(R.id.radbu7);
        radioButton = findViewById(R.id.radbu8);


//------------------------------------------------------------------------------------
        Tanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year=calendar.get(Calendar.YEAR);
                final int month=calendar.get(Calendar.MONTH);
                final int day=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Tanggallahir.setText(dayOfMonth+"-"+(month+1)+"-"+year);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


//------------------------------------------------------------------------------------
        bttnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NamaDepan.getText().toString().equals("") && NamaBelakang.getText().toString().equals("")
                        && Tempatlahir.getText().toString().equals("") && Tanggallahir.getText().toString().equals("")
                        && Alamat.getText().toString().equals("") && Telephone.getText().toString().equals("")
                        && Email.getText().toString().equals("") && Password.getText().toString().equals("")
                        && RePassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_LONG).show();
                } else if (NamaDepan.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nama Depan Wajib Diisi Kosong!", Toast.LENGTH_LONG).show();
                } else if (NamaBelakang.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nama Belakang Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
                } else if (Tempatlahir.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Tempat Lahir Wajib Diisi!", Toast.LENGTH_LONG).show();
                } else if (Tanggallahir.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Tanggal Lahir Wajib Diisi!", Toast.LENGTH_LONG).show();
                } else if (Alamat.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Alamat Wajib Diisi!", Toast.LENGTH_LONG).show();
                } else if (Telephone.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Telephone Wajib Diisi!", Toast.LENGTH_LONG).show();
                } else if (Email.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Email Wajib Diisi!", Toast.LENGTH_LONG).show();
                } else if (Password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Password Wajib diisi!", Toast.LENGTH_LONG).show();
                } else if (RePassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Silahkan Ulangi Password Anda!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
                }
            }
        });

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    //------------------------------------------------------------------------------------
    public void ButtonClick(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
    //------------------------------------------------------------------------------------

    private void DialogForm() {
        dialog = new AlertDialog.Builder(MainActivity.this).create();
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.hasil,null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Detail Pendaftaran");

        TextView NamaDepan2 = dialogView.findViewById(R.id.NamaDepan2);
        TextView NamaBelakang2 = dialogView.findViewById(R.id.NamaBelakang2);
        TextView TTL2 = dialogView.findViewById(R.id.TTL2);
        TextView Alamat2 = dialogView.findViewById(R.id.Alamat2);
        TextView JK2 = dialogView.findViewById(R.id.JK2);
        TextView Agama = dialogView.findViewById(R.id.Agama);
        TextView Telephone = dialogView.findViewById(R.id.Telephone2);
        TextView Email2 = dialogView.findViewById(R.id.Email2);


        Button bttnkeluar = dialogView.findViewById(R.id.keluar);
        Button bttnlanjut = dialogView.findViewById(R.id.lanjut);

        NamaDepan2.setText(NamaDepan.getText());
        NamaBelakang2.setText(NamaBelakang.getText());
        TTL2.setText(Tanggallahir.getText());
        Alamat2.setText(Alamat.getText());
        JK2.setText(radioButton.getText().toString());
        Agama.setText(radioButton.getText().toString());
        Telephone.setText(Telephone.getText());
        Email2.setText(Email.getText());
        dialog.setView(dialogView);
        dialog.show();

        bttnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            }
        });

        bttnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }
}