package com.dattech.iTestify.controller;

import com.dattech.iTestify.dto.WikiDto;
import com.dattech.iTestify.exception.WikiNotFoundException;
import com.dattech.iTestify.service.ItestifyImpl.ItestifyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WikiController {
    @Autowired
    private ItestifyServiceImpl itestifyServiceImpl;

    // Add new wiki
    @ApiOperation(value="Add a new wiki to system", response= WikiDto.class)
    @PostMapping("/wiki")
    public WikiDto addWiki(@RequestBody WikiDto wikiDto) {
        return itestifyServiceImpl.addWiki(wikiDto);
    }

    // Get Wikis
    @ApiOperation(value="Get all wikis from system", response= WikiDto.class)
    @GetMapping("/wikis")
    public List<WikiDto> getWikis()  {
        return itestifyServiceImpl.getWikis();

    }


    // Get wiki by id
    @ApiOperation(value="Get wiki wiki from system find by id", response= WikiDto.class)
    @GetMapping("/wiki/{id}")
    public WikiDto getWiki(@PathVariable Integer id) throws WikiNotFoundException {
        return itestifyServiceImpl.findWikiById(id);

    }

    // Edit wiki
    @ApiOperation(value="Edit wiki in the system", response= WikiDto.class)
    @PutMapping("/Wiki/{id}")
    public WikiDto editWiki(@PathVariable Integer id, @RequestBody WikiDto wikiDto){
        return itestifyServiceImpl.modifyWiki(id, wikiDto);
    }

    // Delete wiki
    @ApiOperation(value="Delete wiki from system", response= WikiDto.class)
    @DeleteMapping("/wiki/{id}")
    public Boolean deleteWiki(@PathVariable Integer id) {
        return itestifyServiceImpl.removeWiki(id);
    }
}
