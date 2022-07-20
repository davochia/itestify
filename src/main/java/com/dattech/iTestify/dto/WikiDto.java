package com.dattech.iTestify.dto;

import com.dattech.iTestify.model.Wiki;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class WikiDto {

    private Integer id;
    private String title;
    private String description;
    private Timestamp timestamp;

    public static Wiki getWiki(WikiDto wikiDto){
        Wiki wiki = new Wiki();

        wiki.setId(wikiDto.getId());
        wiki.setTitle(wikiDto.getTitle());
        wiki.setDescription(wikiDto.getDescription());
        wiki.setTimestamp(wikiDto.getTimestamp());

        return wiki;
    }

    public static WikiDto getWikiDto(Wiki wiki){
        WikiDto wikiDto = new WikiDto();

        wikiDto.setId(wiki.getId());
        wikiDto.setTitle(wiki.getTitle());
        wikiDto.setDescription(wiki.getDescription());
        wikiDto.setTimestamp(wiki.getTimestamp());

        return wikiDto;
    }

}
