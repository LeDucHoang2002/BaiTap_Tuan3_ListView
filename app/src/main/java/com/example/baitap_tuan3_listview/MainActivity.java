package com.example.baitap_tuan3_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnThem,btnCapNhat,btnXoa;
    ListView lvMonHoc;
    ArrayList<String> arrayCourse;
    int vt = -1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem=(Button)findViewById(R.id.buttonThem);
        btnCapNhat=(Button)findViewById(R.id.buttonCapNhat);
        btnXoa=(Button)findViewById(R.id.buttonXoa);
        editText=(EditText)findViewById(R.id.editTextMonHoc) ;
        lvMonHoc = (ListView)  findViewById(R.id.lv_monhoc);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("CSDL");
        arrayCourse.add("Cấu trúc dữ liệu");
        arrayCourse.add("Đồ họa ứng dụng");
        arrayCourse.add("C#");
        arrayCourse.add("IOS");
        ArrayAdapter adapter = new ArrayAdapter <String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lvMonHoc.setAdapter(adapter) ;
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long  l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();editText.setText(arrayCourse.get(i));
                lvMonHoc.setSelector(R.color.purple_200);
                vt = i;
            }

        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vt,editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();String str=lvMonHoc.getAdapter().getItem(i).toString();
                Intent intent=new Intent(getApplicationContext(),Second_Activity.class);
                intent.putExtra("Name",str);
                startActivity(intent);
                lvMonHoc.setSelector(R.color.purple_200);

                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc=editText.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vt);
                adapter.notifyDataSetChanged();
                editText.setText(null);
            }
        });

    }
}