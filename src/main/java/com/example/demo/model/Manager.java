package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "managers")
@Builder
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private String salary;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private Date createdAt;

}

