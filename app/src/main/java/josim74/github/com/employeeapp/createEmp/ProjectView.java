package josim74.github.com.employeeapp.createEmp;

/**
 * Created by JosimUddin on 18/04/2018.
 */

public interface ProjectView {
    public void showProgress();
    public void hideProgress();
    public void projectNameError();
    public void projectDurationError();
    public void noOfMembers();

    public void navigateToMainActivity();
}
