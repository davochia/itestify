package com.dattech.iTestify.service;

import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.dto.WikiCategoryDto;
import com.dattech.iTestify.dto.WikiDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;
import com.dattech.iTestify.exception.CategoryNotFoundException;
import com.dattech.iTestify.exception.WikiNotFoundException;

import java.util.List;

public interface ItestifyServiceI {
    ///////////////// Author //////////////////////////
    AuthorDto addAuthor(AuthorDto authorDto);
    AuthorDto findAuthorById(Integer id) throws AuthorNotFoundException;
    List<AuthorDto> getAuthors( );
    AuthorDto modifyWikiCategory(Integer id, AuthorDto authorDto);
    Boolean removeAuthor(Integer id) ;

    ///////////////// Wiki //////////////////////////
    WikiDto addWiki(WikiDto WikiDto);
    WikiDto findWikiById(Integer id) throws WikiNotFoundException;
    List<WikiDto> getWikis( );
    WikiDto modifyWiki(Integer id, WikiDto WikiDto);
    Boolean removeWiki(Integer id) ;

    ///////////////// Category //////////////////////////
    WikiCategoryDto addWikiCategory(WikiCategoryDto wikiCategoryDto);
    WikiCategoryDto findWikiCategoryById(Integer id) throws CategoryNotFoundException;
    List<WikiCategoryDto> getWikiCategories( );
    WikiCategoryDto modifyWikiCategory(Integer id, WikiCategoryDto wikiCategoryDto);
    Boolean removeWikiCategory(Integer id) ;

}
