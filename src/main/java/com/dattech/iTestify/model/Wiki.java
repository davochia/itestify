package com.dattech.iTestify.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wiki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ApiModelProperty(notes="Unique auto generated identifier for the system")
    private Integer id;

    //    @ApiModelProperty(notes="Wiki name or title")
    @Column(name= "title")
    private String title;


    //    @ApiModelProperty(notes="Wiki description")
    @Column(name= "description")
    private String description;

    @ManyToOne
    private Author author;

    @Column(name= "timestamp")
    private Timestamp timestamp;


    @ManyToMany
    private List<Wiki> wikis;
}
