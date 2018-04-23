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

public class EmployeeActivity extends AppCompatActivity implements EmployeeView, Serializable{
    private EditText etName, etEmail, etDesignation;
    private Button btnGoNext;
    private ProgressBar progressBar;

    private EmployeeInteractor employeeInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        etName = findViewById(R.id.editText_name);
        etEmail = findViewById(R.id.editText_email);
        etDesignation = findViewById(R.id.editText_designation);
        btnGoNext = findViewById(R.id.button_next_employee);
        progressBar = findViewById(R.id.progressBar_employee);

        employeeInteractor = new EmployeeInteractor();

        btnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String designation = etDesignation.getText().toString();
                if(name.equals(null))
                    setNameError();
                else if (email.equals(null))
                    setEmailError();
                else if (designation.equals(null))
                    setDesignationError();
                else{
                    employeeInteractor.setEmpName(name);
                    employeeInteractor.setEmpEmail(email);
                    employeeInteractor.setEmpDesignation(designation);
                    navigateToAddress();
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
    public void setNameError() {
        etName.setError("Name Cannot be Empty");
    }

    @Override
    public void setEmailError() {
        etEmail.setError("Email cannot be Empty");
    }

    @Override
    public void setDesignationError() {
        etDesignation.setError("Designation cannot be empty");
    }

    @Override
    public void navigateToAddress() {
        Intent addressIntent = new Intent(EmployeeActivity.this, AddressActivity.class);
        addressIntent.putExtra("employeeObject", employeeInteractor);
        startActivity(addressIntent);
    }
}
