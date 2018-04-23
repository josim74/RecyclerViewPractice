package josim74.github.com.employeeapp.createEmp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JosimUddin on 19/04/2018.
 */

public class EmployeeInteractor implements Serializable{
    private String empName, empEmail, empDesignation;
    private AddressInteractor addressInteractor;
    private ArrayList<ProjectInteractor> projets;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public AddressInteractor getAddressInteractor() {
        return addressInteractor;
    }

    public void setAddressInteractor(AddressInteractor addressInteractor) {
        this.addressInteractor = addressInteractor;
    }

    public ArrayList<ProjectInteractor> getProjets() {
        return projets;
    }

    public void setProjets(ArrayList<ProjectInteractor> projets) {
        this.projets = projets;
    }
}
