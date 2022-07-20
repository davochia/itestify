package com.dattech.iTestify.controller;


import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;
import com.dattech.iTestify.service.HelloImpl.Hello;
import com.dattech.iTestify.service.ItestifyImpl.ItestifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private Hello helloService;

    @Autowired
    private ItestifyServiceImpl itestifyServiceImpl;

//    @ApiOperation(value="Add a new author to system", response= Author.class)
    @GetMapping("/hello")
    public String helloWorld(){
        return helloService.getHello();
    }

    @PostMapping("/name")
    public String postName(@RequestBody String name){
        return helloService.putHello(name);
    }

        // Add new Author
//    @ApiOperation(value="Add a new author to system", response= AuthorDto.class)
//    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @PostMapping("/author")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) {
        return itestifyServiceImpl.addAuthor(authorDto);
    }

    // Get Authors
    @GetMapping("/authors")
    public List<AuthorDto> getAuthors()  {
        return itestifyServiceImpl.getAuthors();

    }


    // Get Author by id
    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable Integer id) throws AuthorNotFoundException {
        return itestifyServiceImpl.findAuthorById(id);

    }


    // Edit Author info
    @PutMapping("/author/{id}")
    public AuthorDto editAuthor(@PathVariable Integer id, @RequestBody AuthorDto newAuthor){
        return itestifyServiceImpl.modifyAuthor(id, newAuthor);
    }


    // Delete author
    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        itestifyServiceImpl.removeAuthor(id);
    }
}
