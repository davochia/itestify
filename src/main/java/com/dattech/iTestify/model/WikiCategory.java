package com.dattech.iTestify.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WikiCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes="Unique auto generated identifier for the system")
    private Integer id;

    @ApiModelProperty(notes="Author's first name ")
    @Column(name= "name")
    private String name;

    @ManyToMany
    private Set<Wiki> wikis;
}
