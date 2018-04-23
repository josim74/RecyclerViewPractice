package josim74.github.com.employeeapp.createEmp;

/**
 * Created by JosimUddin on 18/04/2018.
 */

public interface EmployeeView {
    void showProgress();
    void hideProgress();
    void setNameError();
    void setEmailError();
    void setDesignationError();
    void navigateToAddress();
}
