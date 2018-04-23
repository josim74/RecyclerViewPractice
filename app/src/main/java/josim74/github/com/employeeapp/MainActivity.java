package josim74.github.com.employeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import josim74.github.com.employeeapp.createEmp.EmployeeInteractor;
import josim74.github.com.employeeapp.createEmp.ProjectInteractor;

public class MainActivity extends AppCompatActivity {
    private TextView name, email, designation, phone, house, road, city, zipcode;
    private RecyclerView recyclerView;
    private ArrayList<ProjectInteractor> projectList;
    private ProjectInteractor projectInteractor;
    private EmployeeInteractor employeeInteractor;
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeInteractor = (EmployeeInteractor) getIntent().getSerializableExtra("employeeObject");

        name = findViewById(R.id.tvName);
        email = findViewById(R.id.tvEmail);
        designation = findViewById(R.id.tvDesignation);
        phone = findViewById(R.id.tvphone);
        house = findViewById(R.id.tvHouse);
        road = findViewById(R.id.tvRoad);
        city = findViewById(R.id.tvCity);
        zipcode = findViewById(R.id.tvZip);
        recyclerView = findViewById(R.id.recycler_view);

        name.setText(employeeInteractor.getEmpName());
        email.setText(employeeInteractor.getEmpEmail());
        designation.setText(employeeInteractor.getEmpDesignation());
        phone.setText(employeeInteractor.getAddressInteractor().getPhone());
        house.setText(employeeInteractor.getAddressInteractor().getHouseNo());
        road.setText(employeeInteractor.getAddressInteractor().getRoadNo());
        city.setText(employeeInteractor.getAddressInteractor().getCity());
        zipcode.setText(employeeInteractor.getAddressInteractor().getZipCode());

        projectList = employeeInteractor.getProjets();

        myRecyclerAdapter = new MyRecyclerAdapter(projectList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myRecyclerAdapter);
        myRecyclerAdapter.notifyDataSetChanged();


    }
}
