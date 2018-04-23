package josim74.github.com.employeeapp.createEmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import josim74.github.com.employeeapp.MainActivity;
import josim74.github.com.employeeapp.R;

public class ProjectActivity extends AppCompatActivity implements ProjectView{
    private ProgressBar progressBar;
    private EditText etProjectName, etProjectDuration, etNoOfMembers;
    private Button btnAddMore, btnView;
    private ProjectInteractor projectInteractor;
    private EmployeeInteractor employeeInteractor;
    private ArrayList<ProjectInteractor> projectlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        employeeInteractor = (EmployeeInteractor) getIntent().getSerializableExtra("employeeObject");
        projectlist = new ArrayList<>();


        progressBar = findViewById(R.id.progressBar_project);
        etProjectName = findViewById(R.id.et_project_name);
        etProjectDuration = findViewById(R.id.et_project_duration);
        etNoOfMembers = findViewById(R.id.et_no_of_members);
        btnAddMore = findViewById(R.id.btn_Show);
        btnView = findViewById(R.id.btn_view);
        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String projectname = etProjectName.getText().toString();
                String duration = etProjectDuration.getText().toString();
                String members = etNoOfMembers.getText().toString();
                if(projectname.equals(null))
                    projectNameError();
                else if(duration.equals(null))
                    projectDurationError();
                else if(members.equals(null))
                    noOfMembers();
                else {

                    projectInteractor = new ProjectInteractor();
                    projectInteractor.setProjectName(projectname);
                    projectInteractor.setProjectDuration(duration);
                    projectInteractor.setNoOfMembers(members);

                    projectlist.add(projectInteractor);


                    Toast.makeText(ProjectActivity.this, "Data Added!", Toast.LENGTH_SHORT).show();

                    etProjectName.setText(null);
                    etProjectDuration.setText(null);
                    etNoOfMembers.setText(null);

                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
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
    public void projectNameError() {

        etProjectName.setError("Project name cannot be empty");
    }

    @Override
    public void projectDurationError() {
        etProjectDuration.setError("Project duration cannot be empty");

    }

    @Override
    public void noOfMembers() {
        etNoOfMembers.setError("Project Members canot be empty");
    }

    @Override
    public void navigateToMainActivity() {
        employeeInteractor.setProjets(projectlist);
        Intent showIntent = new Intent(ProjectActivity.this, MainActivity.class);
        showIntent.putExtra("employeeObject", employeeInteractor);
        startActivity(showIntent);

    }
}
