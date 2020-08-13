package com.example.my_files;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_pdf;
    //RecyclerView.LayoutManager recyclerViewLayoutManager_document;
    public static ArrayList<File> fileList = new ArrayList<File>();
    PDFAdapter obj_adapter;
    public static int REQUEST_PERMISSIONS = 1;
    boolean boolean_permission;
    File dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {


        lv_pdf = (ListView) findViewById(R.id.lv_pdf);
       // recyclerViewLayoutManager_document = new GridLayoutManager(getApplicationContext(), 2);
       // lv_pdf.setLayoutManager(recyclerViewLayoutManager_document);
        dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        fn_permission();

//
//      lv_pdf.setOnClickListener(new AdapterView.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              Toast.makeText(MainActivity.this, "your documents", Toast.LENGTH_SHORT).show();
//          }
//      });

    }


    public ArrayList<File> getfile(File dir) {
        File Listview[] = dir.listFiles();
        if (Listview != null && Listview.length > 0) {
            for (int i = 0; i < Listview.length; i++) {
                if (Listview[i].isDirectory()) {
                    getfile(Listview[i]);

                } else  {

                    boolean booleanpdf = false;
                    if (Listview[i].getName().endsWith(".pdf")) {

                        for (int j = 0; j < fileList.size(); j++) {
                            if (fileList.get(j).getName().equals(Listview[i].getName())) {
                                booleanpdf = true;


                            }
                            else {

                            }
                        }
                        if (booleanpdf) {
                            booleanpdf = false;
                        } else {
                            fileList.add(Listview[i]);
                        }
                    }



                    if (Listview[i].getName().endsWith(".txt")) {

                        for (int k = 0; k < fileList.size(); k++) {
                            if (fileList.get(k).getName().equals(Listview[i].getName())) {
                                booleanpdf = true;
                            }
                            else {

                            }
                        }
                        if (booleanpdf) {
                            booleanpdf = false;
                        } else {
                            fileList.add(Listview[i]);
                        }
                    }

                    if (Listview[i].getName().endsWith(".docx")) {

                        for (int l = 0; l < fileList.size(); l++) {
                            if (fileList.get(l).getName().equals(Listview[i].getName())) {
                                booleanpdf = true;
                            }
                            else {

                            }
                        }
                        if (booleanpdf) {
                            booleanpdf = false;
                        } else {
                            fileList.add(Listview[i]);
                        }
                    }


                    if (Listview[i].getName().endsWith(".pptx")) {

                        for (int m = 0; m < fileList.size(); m++) {
                            if (fileList.get(m).getName().equals(Listview[i].getName())) {
                                booleanpdf = true;
                            }
                            else {

                            }
                        }
                        if (booleanpdf) {
                            booleanpdf = false;
                        } else {
                            fileList.add(Listview[i]);
                        }
                    }


                    if (Listview[i].getName().endsWith(".xlsx")) {

                        for (int n = 0; n < fileList.size(); n++) {
                            if (fileList.get(n).getName().equals(Listview[i].getName())) {
                                booleanpdf = true;
                            }
                            else {

                            }
                        }
                        if (booleanpdf) {
                            booleanpdf = false;
                        } else {
                            fileList.add(Listview[i]);
                        }
                    }






                }
            }
        }



                     return fileList;
                                    }
                                    private void fn_permission () {
                                        if ((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {

                                            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE))) {
                                            } else {
                                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                                        REQUEST_PERMISSIONS);

                                            }
                                        } else {
                                            boolean_permission = true;

                                            getfile(dir);

                                            obj_adapter = new PDFAdapter(getApplicationContext(), fileList );


                                            lv_pdf.setAdapter(obj_adapter);

                                        }
                                    }
                                    @Override
                                    public void onRequestPermissionsResult (
                                    int requestCode, String[] permissions,int[] grantResults){
                                        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                                        if (requestCode == REQUEST_PERMISSIONS) {

                                            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                                                boolean_permission = true;
                                                getfile(dir);

                                                obj_adapter = new PDFAdapter(getApplicationContext(), fileList);
                                                lv_pdf.setAdapter(obj_adapter);

                                            } else {
                                                Toast.makeText(getApplicationContext(), "Please allow the permission", Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    }

                                }







