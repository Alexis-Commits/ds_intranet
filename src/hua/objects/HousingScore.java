package hua.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students_score")
public class HousingScore {
    @Id
    @Column(name="student_id")
    int id;

    @Column(name="score")
    int score;

    @Column(name="department")
    String department;

    public HousingScore(int id , int score , String department) {
        this.id = id;
        this.score = score;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public HousingScore() {
    }
}
