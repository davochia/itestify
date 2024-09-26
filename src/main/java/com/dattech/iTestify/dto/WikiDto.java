package com.dattech.iTestify.dto;

import com.dattech.iTestify.model.Wiki;
import com.dattech.iTestify.model.WikiCategory;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.util.List;

@Data
public class WikiDto {

    private Integer id;
    private String title;
    private String description;
    private Timestamp createdTimeStamp;
    private List<WikiCategory> wikiCategories;

    public static Wiki getWiki(WikiDto wikiDto){
        Wiki wiki = new Wiki();

        wiki.setId(wikiDto.getId());
        wiki.setTitle(wikiDto.getTitle());
        wiki.setShortDescription(wikiDto.getDescription());
        wiki.setWikiCategories(wikiDto.getWikiCategories());
        wiki.setCreatedTimeStamp(wikiDto.getCreatedTimeStamp());

        return wiki;
    }

    public static WikiDto getWikiDto(Wiki wiki){
        WikiDto wikiDto = new WikiDto();

        wikiDto.setId(wiki.getId());
        wikiDto.setTitle(wiki.getTitle());
        wikiDto.setDescription(wiki.getShortDescription());
        wikiDto.setWikiCategories(wiki.getWikiCategories());
        wikiDto.setCreatedTimeStamp(wiki.getCreatedTimeStamp());

        return wikiDto;
    }

}
