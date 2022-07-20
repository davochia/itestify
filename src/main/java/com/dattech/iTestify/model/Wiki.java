package com.dattech.iTestify.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

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
    private String title;


    //    @ApiModelProperty(notes="Wiki description")
    private String description;

    @ManyToOne
    private Author author;
}
