package josim74.github.com.employeeapp.createEmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.Serializable;

import josim74.github.com.employeeapp.R;

public class AddressActivity extends AppCompatActivity implements AddressView, Serializable{
    private EditText etHouseNo, etRoadNo, etCity, etZipCode, etPhoneNo;
    private Button btnGoNext;
    private ProgressBar progressBar;
    private EmployeeInteractor employeeInteractor;
    private AddressInteractor addressInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        employeeInteractor = (EmployeeInteractor) getIntent().getSerializableExtra("employeeObject");
        addressInteractor = new AddressInteractor();

        etHouseNo = findViewById(R.id.et_house_no);
        etRoadNo = findViewById(R.id.et_road_no);
        etCity = findViewById(R.id.et_city);
        etZipCode = findViewById(R.id.et_zip_code);
        progressBar = findViewById(R.id.progressBar_address);
        etPhoneNo = findViewById(R.id.et_phone_no);
        btnGoNext = findViewById(R.id.btnGoNext_address);

        btnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String houseNo = etHouseNo.getText().toString();
                String roadNo = etRoadNo.getText().toString();
                String city = etCity.getText().toString();
                String zipcode = etZipCode.getText().toString();
                String phlone = etPhoneNo.getText().toString();

                if(houseNo.equals(null))
                    setHouseNoError();
                else if(roadNo.equals(null))
                    setRoadNoError();
                else if(city.equals(null))
                    setCityError();
                else if(zipcode.equals(null))
                    setZipCodeError();
                else if(phlone.equals(null))
                    setPhoneError();
                else {
                    addressInteractor.setHouseNo(houseNo);
                    addressInteractor.setRoadNo(roadNo);
                    addressInteractor.setCity(city);
                    addressInteractor.setZipCode(zipcode);
                    addressInteractor.setPhone(phlone);

                    employeeInteractor.setAddressInteractor(addressInteractor);
                    navigateToProjectActivity();
                }
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setHouseNoError() {
        etHouseNo.setError("House no cannot be empty");
    }

    @Override
    public void setRoadNoError() {
        etRoadNo.setError("Road no cannot be empty");
    }

    @Override
    public void setCityError() {
        etCity.setError("City cannot be empty");
    }

    @Override
    public void setZipCodeError() {
        etZipCode.setError("ZipCode cannot be emtpy");
    }

    @Override
    public void setPhoneError() {
        etPhoneNo.setError("Phone no cannot be empty");
    }

    @Override
    public void navigateToProjectActivity() {
        Intent projgectIntent = new Intent(AddressActivity.this, ProjectActivity.class);
        projgectIntent.putExtra("employeeObject",employeeInteractor);
        startActivity(projgectIntent);
    }
}
