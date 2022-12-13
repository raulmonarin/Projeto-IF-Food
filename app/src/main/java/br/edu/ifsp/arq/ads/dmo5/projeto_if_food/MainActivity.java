package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.ads.dmo5.projeto_if_food.Model.MenuModal;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView txtTitle;
    private TextView txtLogin;

    ListView coursesLV;
    ArrayList<MenuModal> dataModalArrayList;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
*/
        setToolBar();
        setDrawerLayout();
        setNavigationView();
        setTextLogin();
    }

    private void setTextLogin() {
        txtLogin = navigationView.getHeaderView(0)
                .findViewById(R.id.header_profile_name);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        UserLoginActivity.class);
                startActivity(intent);
            }
        });
    }



    private void setNavigationView() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent = null;
                        switch (item.getItemId()){
                            case R.id.nav_home:
                                intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_profile:
                                intent = new Intent(MainActivity.this,
                                        UserProfileActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_menu:
                                intent = new Intent(MainActivity.this, MenuActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_settings:
                                Toast.makeText(MainActivity.this, "Estatísticas", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.nav_logout:
                                /*userViewModel.logout();*/
                                txtLogin.setText(R.string.txt_enter);
                                break;
                            default:
                                Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
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
                            CoursesLVAdapter adapter = new CoursesLVAdapter(MainActivity.this, dataModalArrayList);
                            coursesLV.setAdapter(adapter);
                        } else {
                            Toast.makeText(MainActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setDrawerLayout() {
        drawerLayout = findViewById(R.id.nav_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.toggle_abre,
                R.string.toggle_fecha);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitle = findViewById(R.id.toolbar_title);
        txtTitle.setText(getString(R.string.app_name));
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

}