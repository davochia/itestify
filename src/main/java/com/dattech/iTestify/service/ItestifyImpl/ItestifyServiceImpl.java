package com.dattech.iTestify.service.ItestifyImpl;

import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.dto.WikiCategoryDto;
import com.dattech.iTestify.dto.WikiDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;
import com.dattech.iTestify.exception.CategoryNotFoundException;
import com.dattech.iTestify.exception.WikiNotFoundException;
import com.dattech.iTestify.model.Author;
import com.dattech.iTestify.repository.AuthorRepository;
import com.dattech.iTestify.service.ItestifyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItestifyServiceImpl implements ItestifyServiceI {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        if (authorDto == null)return null;
        Author author = AuthorDto.getAuthor(authorDto);
        return AuthorDto.getAuthorDto((Author) authorRepository.save(author));

    }

    @Override
    public AuthorDto findAuthorById(Integer id) throws AuthorNotFoundException {
        delayResponse();
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.map(AuthorDto::getAuthorDto).orElseThrow(() -> new AuthorNotFoundException(id));
    }


    @Override
    public List<AuthorDto> getAuthors() {
        delayResponse();
        List<Author> authors = (List<Author>) authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        if (authors == null) return null;
        authors.forEach(author -> authorDtos.add(AuthorDto.getAuthorDto(author)));
        return authorDtos;
    }

    @Override
    public AuthorDto modifyWikiCategory(Integer id, AuthorDto authorDto)  {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isEmpty())return null;

        Author author = optionalAuthor.get();

        if(authorDto == null) return null;

        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setPhone(authorDto.getPhone());
        author.setEmail(authorDto.getEmail());
        //author.setWikis(authorDto.);

        return AuthorDto.getAuthorDto((Author) authorRepository.save(author));


//        return authorRepository.findById(id)
//                .map(author -> {
//                    author.setFirstName(newAuthor.getFirstName());
//                    author.setLastName(newAuthor.getLastName());
//                    author.setPhone(newAuthor.getPhone());
//                    author.setEmail(newAuthor.getEmail());
//                    author.setWikis(newAuthor.getWikis());
//                    return authorRepository.save(author);
//                })
//                .orElseGet(() -> {
//                    newAuthor.setId(id);
//                    return authorRepository.save(newAuthor);
//                });
    }

    @Override
    public Boolean removeAuthor(Integer id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty())return false;

        Author author = optionalAuthor.get();
        authorRepository.delete(author);
        return true;
    }


    ///////////////////// Wiki ///////////////////////////
    @Override
    public WikiDto addWiki(WikiDto WikiDto) {
        return null;
    }

    @Override
    public WikiDto findWikiById(Integer id) throws WikiNotFoundException {
        return null;
    }

    @Override
    public List<WikiDto> getWikis() {
        return null;
    }

    @Override
    public WikiDto modifyWiki(Integer id, WikiDto WikiDto) {
        return null;
    }

    @Override
    public Boolean removeWiki(Integer id) {
        return null;
    }


    //////////////////// Category ////////////////////////

    @Override
    public WikiCategoryDto addWikiCategory(WikiCategoryDto wikiCategoryDto) {
        return null;
    }

    @Override
    public WikiCategoryDto findWikiCategoryById(Integer id) throws CategoryNotFoundException {
        return null;
    }

    @Override
    public List<WikiCategoryDto> getWikiCategories() {
        return null;
    }

    @Override
    public WikiCategoryDto modifyWikiCategory(Integer id, WikiCategoryDto wikiCategoryDto) {
        return null;
    }

    @Override
    public Boolean removeWikiCategory(Integer id) {
        return null;
    }


    //////////////////////////// Delay ///////////////////////////

    private void delayResponse(){
        try{
            long time = 3000L;
            Thread.sleep(time);
        }catch(InterruptedException e){
            throw new IllegalStateException(e);
        }
    }
}
