package com.dattech.iTestify.service;

import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;

import java.util.List;

public interface ItestifyServiceI {
    AuthorDto addAuthor(AuthorDto authorDto);
    AuthorDto findAuthorById(Integer id) throws AuthorNotFoundException;
    List<AuthorDto> getAuthors( );
    AuthorDto modifyAuthor(Integer id, AuthorDto authorDto);
    void removeAuthor(Integer id) ;
}
