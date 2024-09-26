package com.dattech.iTestify.dto;

import com.dattech.iTestify.model.WikiCategory;
import lombok.Data;

@Data
public class WikiCategoryDto {

    private Integer id;
    private String name;

    public static WikiCategory getWikiCategory(WikiCategoryDto wikiCategoryDto){
        WikiCategory wikiCategory = new WikiCategory();

        wikiCategory.setId(wikiCategoryDto.getId());
        wikiCategory.setName(wikiCategoryDto.getName());

        return wikiCategory;
    }


    public static WikiCategoryDto getWikiCategoryDto(WikiCategory wikiCategory){
        WikiCategoryDto wikiCategoryDto = new WikiCategoryDto();

        wikiCategoryDto.setId(wikiCategory.getId());
        wikiCategoryDto.setName(wikiCategory.getName());

        return wikiCategoryDto;
    }
}
