package com.example.demo.authordb;

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
@Entity(name ="author")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String authorName;

}
