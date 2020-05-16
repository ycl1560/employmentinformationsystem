package cn.edu.gues.employmentinformationsystem.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "provinces")
public class Provinces {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "provinceid")
    private String provinceid;

    @Column(name = "province")
    private String province;
}