package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
@Entity
@Table
@Getter
@Setter
@ToString
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Deleting an activity will remove all associated signups
    @ManyToOne
    private Camper camper;
    @ManyToOne
    private Activity activity;
    @Min(value = 0)
    @Max(23)
    private int time;
    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();
    @Temporal(TemporalType.DATE)
    private Date updated_at;
}
