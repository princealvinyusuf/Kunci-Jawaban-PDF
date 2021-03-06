package com.alvin.percobaanjawaban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alvin.percobaanjawaban.password.PasswordDialog;
import com.alvin.percobaanjawaban.password.PasswordDialog10;
import com.alvin.percobaanjawaban.password.PasswordDialog2;
import com.alvin.percobaanjawaban.password.PasswordDialog3;
import com.alvin.percobaanjawaban.password.PasswordDialog4;
import com.alvin.percobaanjawaban.password.PasswordDialog5;
import com.alvin.percobaanjawaban.password.PasswordDialog6;
import com.alvin.percobaanjawaban.password.PasswordDialog7;
import com.alvin.percobaanjawaban.password.PasswordDialog8;
import com.alvin.percobaanjawaban.password.PasswordDialog9;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PasswordDialog.ExampleDialogListener, PasswordDialog2.ExampleDialogListener, PasswordDialog3.ExampleDialogListener,
        PasswordDialog4.ExampleDialogListener, PasswordDialog5.ExampleDialogListener, PasswordDialog6.ExampleDialogListener, PasswordDialog7.ExampleDialogListener,
        PasswordDialog8.ExampleDialogListener, PasswordDialog9.ExampleDialogListener, PasswordDialog10.ExampleDialogListener{

    private JawabanAdapter adapter;
    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataPdfName;
    private String[] dataPageName;
    private ArrayList<Jawaban> jawabans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lvList);
        adapter = new JawabanAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = jawabans.get(position).getTitle();
                if (title.equals("Teori 1")) {
                    openDialog();
                } if (title.equals("Teori 2")) {
                    openDialog2();
                } if (title.equals("Teori 3")) {
                    openDialog3();
                } if (title.equals("Teori 4")) {
                    openDialog4();
                } if (title.equals("Teori 5")) {
                    openDialog5();
                } if (title.equals("Teori 6")) {
                    openDialog6();
                } if (title.equals("Teori 7")) {
                    openDialog7();
                } if (title.equals("Teori 8")) {
                    openDialog8();
                } if (title.equals("Teori 9")) {
                    openDialog9();
                } if (title.equals("Teori 10")) {
                    openDialog10();
                }

//                Toast.makeText(MainActivity.this, jawabans.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPdfName = getResources().getStringArray(R.array.data_pdf);
        dataPageName = getResources().getStringArray(R.array.data_pageName);
    }

    private void addItem() {
        jawabans = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Jawaban jawaban = new Jawaban();
            jawaban.setTitle(dataTitle[i]);
            jawaban.setDescription(dataDescription[i]);
            jawaban.setPdfName(dataPdfName[i]);
            jawaban.setPageName(dataPageName[i]);
            jawabans.add(jawaban);
        }

        adapter.setJawabans(jawabans);
    }

    public void openDialog() {
        PasswordDialog passwordDialog = new PasswordDialog();
        passwordDialog.show(getSupportFragmentManager(), "password dialog");
    }

    public void openDialog2() {
        PasswordDialog2 passwordDialog2 = new PasswordDialog2();
        passwordDialog2.show(getSupportFragmentManager(), "password dialog2");
    }

    public void openDialog3() {
        PasswordDialog3 passwordDialog3 = new PasswordDialog3();
        passwordDialog3.show(getSupportFragmentManager(), "password dialog3");
    }

    public void openDialog4() {
        PasswordDialog4 passwordDialog4 = new PasswordDialog4();
        passwordDialog4.show(getSupportFragmentManager(), "password dialog4");
    }

    public void openDialog5() {
        PasswordDialog5 passwordDialog5 = new PasswordDialog5();
        passwordDialog5.show(getSupportFragmentManager(), "password dialog5");
    }

    public void openDialog6() {
        PasswordDialog6 passwordDialog6 = new PasswordDialog6();
        passwordDialog6.show(getSupportFragmentManager(), "password dialog6");
    }

    public void openDialog7() {
        PasswordDialog7 passwordDialog7 = new PasswordDialog7();
        passwordDialog7.show(getSupportFragmentManager(), "password dialog7");
    }

    public void openDialog8() {
        PasswordDialog8 passwordDialog8 = new PasswordDialog8();
        passwordDialog8.show(getSupportFragmentManager(), "password dialog8");
    }

    public void openDialog9() {
        PasswordDialog9 passwordDialog9 = new PasswordDialog9();
        passwordDialog9.show(getSupportFragmentManager(), "password dialog9");
    }

    public void openDialog10() {
        PasswordDialog10 passwordDialog10 = new PasswordDialog10();
        passwordDialog10.show(getSupportFragmentManager(), "password dialog10");
    }

    @Override
    public void applyTexts(String password) {
        if (password.equals("111111")){
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample.pdf");
            jawaban.setPageName("Pembahasan Soal Pendahuluan");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts2(String password) {
        if (password.equals("222222")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 2.pdf");
            jawaban.setPageName("Pembahasan Soal Nirmana");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts3(String password) {
        if (password.equals("333333")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 3.pdf");
            jawaban.setPageName("Pembahasan Soal Warna");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts4(String password) {
        if (password.equals("444444")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 4.pdf");
            jawaban.setPageName("Pembahasan Soal Tipografi");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts5(String password) {
        if (password.equals("555555")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 5.pdf");
            jawaban.setPageName("Pembahasan Soal Simbol Dan Ikon");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts6(String password) {
        if (password.equals("666666")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 6.pdf");
            jawaban.setPageName("Pembahasan Soal Logo");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts7(String password) {
        if (password.equals("777777")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 7.pdf");
            jawaban.setPageName("Pembahasan Soal Tata Letak");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts8(String password) {
        if (password.equals("888888")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 8.pdf");
            jawaban.setPageName("Pembahasan Soal Periklanan");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts9(String password) {
        if (password.equals("999999")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 9.pdf");
            jawaban.setPageName("Pembahasan Soal Desain Karakter");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void applyTexts10(String password) {
        if (password.equals("xxxxxx")) {
            Intent intent = new Intent (MainActivity.this, PDFActivity.class);

            Jawaban jawaban = new Jawaban();
            jawaban.setPdfName("sample 10.pdf");
            jawaban.setPageName("Pembahasan Soal Illustrasi");

            intent.putExtra(PDFActivity.SAMPLE_FILE, jawaban);
            startActivity(intent);
        }  else {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        }
    }
}