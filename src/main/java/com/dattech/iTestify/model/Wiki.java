package com.dattech.iTestify.model;

import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wiki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes="Unique auto generated identifier for the system")
    private Integer id;

    @ApiModelProperty(notes="Wiki name or title")
    @Column(name= "title")
    private String title;

    @ApiModelProperty(notes="Wiki description")
    @Column(name= "description")
    private String shortDescription;

    @ApiModelProperty(notes="Wiki full content")
    @Column(name= "content")
    private String content;

    @ApiModelProperty(notes="Number of wiki like")
    @Column(name= "likes")
    @ManyToMany(mappedBy = "likedWikis")
    private Set<Author> likes;

    @ApiModelProperty(notes="Wiki created date ")
    @Column(nullable = false)
    private Timestamp createdTimeStamp;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<WikiCategory> wikiCategories;

}
