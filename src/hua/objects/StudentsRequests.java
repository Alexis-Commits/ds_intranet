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
    int id;

    @Column(name="income")
    int income;

    @Column(name="studying_brothers")
    int brothers;

    @Column(name="from_another_city")
    int fromAnotherCity;

    @Column(name="semester")
    int semester ;

    @Column(name="already_housing_years")
    int housingYears;

    @Column(name="department")
    String department;



    public StudentsRequests() {
    }
    public StudentsRequests(int id ,int income , int brothers , int fromAnotherCity , int semester , int housingYears , String department) {
        this.id = id ;
        this.income = income;
        this.brothers = brothers ;
        this.fromAnotherCity = fromAnotherCity;
        this.semester = semester ;
        this.housingYears = housingYears;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getBrothers() {
        return brothers;
    }

    public void setBrothers(int brothers) {
        this.brothers = brothers;
    }

    public int getFromAnotherCity() {
        return fromAnotherCity;
    }

    public void setFromAnotherCity(int fromAnotherCity) {
        this.fromAnotherCity = fromAnotherCity;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getHousingYears() {
        return housingYears;
    }

    public void setHousingYears(int housingYears) {
        this.housingYears = housingYears;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
