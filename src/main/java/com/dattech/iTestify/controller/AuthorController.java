package com.dattech.iTestify.controller;


import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;
import com.dattech.iTestify.service.ItestifyImpl.ItestifyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {



    @Autowired
    private ItestifyServiceImpl itestifyServiceImpl;

    // Add new Author
//    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ApiOperation(value="Add a new author to system", response= AuthorDto.class)
    @PostMapping("/author")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) {
        return itestifyServiceImpl.addAuthor(authorDto);
    }

    // Get Authors
    @ApiOperation(value="Get all authors from system", response= AuthorDto.class)
    @GetMapping("/authors")
    public List<AuthorDto> getAuthors()  {
        return itestifyServiceImpl.getAuthors();

    }


    // Get Author by id
    @ApiOperation(value="Get author from system find by id", response= AuthorDto.class)
    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable Integer id) throws AuthorNotFoundException {
        return itestifyServiceImpl.findAuthorById(id);

    }


    // Edit Author info
    @ApiOperation(value="Edit author in the system", response= AuthorDto.class)
    @PutMapping("/author/{id}")
    public AuthorDto editAuthor(@PathVariable Integer id, @RequestBody AuthorDto newAuthor){
        return itestifyServiceImpl.modifyWikiCategory(id, newAuthor);
    }


    // Delete author
    @ApiOperation(value="Delete author from system", response= AuthorDto.class)
    @DeleteMapping("/author/{id}")
    public Boolean deleteAuthor(@PathVariable Integer id) {
       return itestifyServiceImpl.removeAuthor(id);
    }
}
