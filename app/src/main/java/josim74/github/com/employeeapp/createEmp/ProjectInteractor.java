package josim74.github.com.employeeapp.createEmp;

import java.io.Serializable;

/**
 * Created by JosimUddin on 19/04/2018.
 */

public class ProjectInteractor implements Serializable{
    private String projectName, projectDuration, NoOfMembers;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(String projectDuration) {
        this.projectDuration = projectDuration;
    }

    public String getNoOfMembers() {
        return NoOfMembers;
    }

    public void setNoOfMembers(String noOfMembers) {
        NoOfMembers = noOfMembers;
    }
}
