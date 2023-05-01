package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Robo82") 
public class MotorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private int Speed;
    
    public MotorData() {
        super();
    }
    
    public MotorData(int id, int Speed, String Name) {
        super();
        this.id = id;
        this.Speed = Speed;
        this.Name = Name;
    }
    
    public MotorData(int Speed, String Name) {
        super();
        this.Speed = Speed;
        this.Name = Name;
    }
    
    public int getSpeed() {
        return Speed;
    }
    
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
