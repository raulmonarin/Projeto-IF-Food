package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.ads.dmo5.projeto_if_food.Model.MenuModal;

public class MenuActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private ListView listview;
    private Button btnPayment;

    ListView coursesLV;
    ArrayList<MenuModal> dataModalArrayList;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setToolBar();
        setBtnPayment();

        coursesLV = findViewById(R.id.idLVCourses);
        dataModalArrayList = new ArrayList<>();

        db = FirebaseFirestore.getInstance();

        loadDatainListview();
    }

    private void loadDatainListview() {

        db.collection("Itens").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                MenuModal dataModal = d.toObject(MenuModal.class);
                                dataModalArrayList.add(dataModal);
                            }
                            CoursesLVAdapter adapter = new CoursesLVAdapter(MenuActivity.this, dataModalArrayList);
                            coursesLV.setAdapter(adapter);
                        } else {
                            Toast.makeText(MenuActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MenuActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setBtnPayment() {
        btnPayment = findViewById(R.id.btn_menu);
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,
                        PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitle = findViewById(R.id.toolbar_title);
        txtTitle.setText(getString(R.string.cardapio_titulo));
    }
}