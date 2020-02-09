package hua.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students_request")
public class StudentsRequests {

    @Column(name="student_id")
    @Id
    String id;

    @Column(name="income")
    String income;

    @Column(name="studying_brothers")
    String brothers;

    @Column(name="from_another_city")
    String fromAnotherCity;

    @Column(name="semester")
    String semester ;

    @Column(name="already_housing_years")
    String housingYears;

    @Column(name="department")
    String department;

    public StudentsRequests(String id , String income , String brothers , String fromAnotherCity , String semester , String housingYears , String department){
        this.id = id;
        this.income = income;
        this.brothers = brothers;
        this.fromAnotherCity = fromAnotherCity;
        this.semester = semester;
        this.housingYears = housingYears;
        this.department = department;

    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getBrothers() {
        return brothers;
    }

    public void setBrothers(String brothers) {
        this.brothers = brothers;
    }

    public String getFromAnotherCity() {
        return fromAnotherCity;
    }

    public void setFromAnotherCity(String fromAnotherCity) {
        this.fromAnotherCity = fromAnotherCity;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getHousingYears() {
        return housingYears;
    }

    public void setHousingYears(String housingYears) {
        this.housingYears = housingYears;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public StudentsRequests() {
    }

}
