package com.dattech.iTestify.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WikiCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ApiModelProperty(notes="Unique auto generated identifier for the system")
    private Integer id;

    //    @ApiModelProperty(notes="Author's first name ")
    @Column(name= "name")
    private String name;

    @ManyToMany
    private List<Wiki> wikis;
}
