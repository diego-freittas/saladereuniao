package br.com.diegofreitas.saladereuniao.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "startHour", nullable = false)
    private String startHour;
    @Column(name = "endHour", nullable = false)
    private String endHour;

  //  @Override
   // public String ToString(){
    //    return "Sala name: " + this.getName()+ "/n" +
     //           "Date: " + this.getDate()+"/n" +
      //          "Start Hour: " +this.getStartHour()+"/n" +
       //         "End Hour: " + this.getEndHour()+"/n";
   // }
}
