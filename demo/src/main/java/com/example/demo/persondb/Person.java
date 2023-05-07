package com.example.demo.persondb;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name ="person")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String personName;

}
