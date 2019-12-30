package hua.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="students_enabled_for_housing_requests")
public class StudentHousing {
    @Id
    @Column(name="id")
    int id;
    @Column(name="enabled")
    int enabled;

    public StudentHousing() {
    }

    public StudentHousing(int id , int enabled){
        this.id=id;
        this.enabled=enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }




}
