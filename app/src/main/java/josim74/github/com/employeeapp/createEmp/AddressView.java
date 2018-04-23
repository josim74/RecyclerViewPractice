package josim74.github.com.employeeapp.createEmp;

/**
 * Created by JosimUddin on 18/04/2018.
 */

public interface AddressView {
    public void showProgress();
    public void hideProgress();
    public void setHouseNoError();
    public void setRoadNoError();
    public void setCityError();
    public void setZipCodeError();
    public void setPhoneError();
    public void navigateToProjectActivity();
}
