package com.dattech.iTestify.service.ItestifyImpl;

import com.dattech.iTestify.dto.AuthorDto;
import com.dattech.iTestify.dto.WikiCategoryDto;
import com.dattech.iTestify.dto.WikiDto;
import com.dattech.iTestify.exception.AuthorNotFoundException;
import com.dattech.iTestify.exception.CategoryNotFoundException;
import com.dattech.iTestify.exception.WikiNotFoundException;
import com.dattech.iTestify.model.Author;
import com.dattech.iTestify.model.Wiki;
import com.dattech.iTestify.model.WikiCategory;
import com.dattech.iTestify.repository.AuthorRepository;
import com.dattech.iTestify.repository.WikiCategoryRepository;
import com.dattech.iTestify.repository.WikiRepository;
import com.dattech.iTestify.service.ItestifyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItestifyServiceImpl implements ItestifyServiceI {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private WikiRepository wikiRepository;

    @Autowired
    private WikiCategoryRepository wikiCategoryRepository;

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        if (authorDto == null)return null;
        Author author = AuthorDto.getAuthor(authorDto);
        return AuthorDto.getAuthorDto((Author) authorRepository.save(author));

    }

    @Override
    public AuthorDto findAuthorById(Integer id) throws AuthorNotFoundException {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.map(AuthorDto::getAuthorDto).orElseThrow(() -> new AuthorNotFoundException(id));
    }


    @Override
    public List<AuthorDto> getAuthors() {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
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
    public WikiDto addWiki(WikiDto wikiDto, Integer authorId) {
        if(wikiDto == null) return null;
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
//        List<WikiCategory> wikiCategory = wikiCategoryRepository.findAll();


        Wiki wiki = WikiDto.getWiki(wikiDto);
        Author author = optionalAuthor.get();



       // wikiCategory.setId();
        wiki.setAuthor(author);
//         wiki.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return WikiDto.getWikiDto(wikiRepository.save(wiki));
    }

    @Override
    public WikiDto findWikiById(Integer id) throws WikiNotFoundException {
        Optional<Wiki> optionalWiki = wikiRepository.findById(id);
        if(optionalWiki.isEmpty())throw new WikiNotFoundException(id);
        return WikiDto.getWikiDto(optionalWiki.get());
    }

    @Override
    public List<WikiDto> getWikis() {
        List<Wiki> wikies = (List<Wiki>) wikiRepository.findAll();
        if (wikies.isEmpty()) return null;
        List<WikiDto> wikiDtos = new ArrayList<WikiDto>();

        wikies.forEach(wiki -> wikiDtos.add(WikiDto.getWikiDto(wiki)));
        return wikiDtos;
    }

    @Override
    public WikiDto modifyWiki(Integer id, WikiDto wikiDto) {
        return wikiDto.getWikiDto(wikiRepository.findById(id)
                .map(wiki -> {
                    wiki.setId(wikiDto.getId());
                    wiki.setTitle(wikiDto.getTitle());
//                    wiki.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
                    wiki.setShortDescription(wikiDto.getDescription());
                    return wikiRepository.save(wiki);
                })
                .orElseGet(() -> {
                    wikiDto.setId(id);
                    return wikiRepository.save(WikiDto.getWiki(wikiDto));
                }));
    }

    @Override
    public Boolean removeWiki(Integer id) {
        Optional<Wiki> optionalWiki = wikiRepository.findById(id);
        if (optionalWiki.isEmpty())return false;

        Wiki wiki = optionalWiki.get();
        wikiRepository.delete(wiki);
        return true;
    }


    //////////////////// Category ////////////////////////

    @Override
    public WikiCategoryDto addWikiCategory(WikiCategoryDto wikiCategoryDto) {
        if(wikiCategoryDto == null) return null;
        WikiCategory wikiCategory = WikiCategoryDto.getWikiCategory(wikiCategoryDto);
        return WikiCategoryDto.getWikiCategoryDto(wikiCategoryRepository.save(wikiCategory));
    }

    @Override
    public WikiCategoryDto findWikiCategoryById(Integer id) throws CategoryNotFoundException {
        Optional<WikiCategory> optionalWikiCategory = wikiCategoryRepository.findById(id);
        if(optionalWikiCategory.isEmpty())throw new CategoryNotFoundException(id);
        return WikiCategoryDto.getWikiCategoryDto(optionalWikiCategory.get());
    }

    @Override
    public List<WikiCategoryDto> getWikiCategories() {
        List<WikiCategory> wikiCategories = (List<WikiCategory>) wikiCategoryRepository.findAll();
        if (wikiCategories.isEmpty()) return null;
        List<WikiCategoryDto> wikiCategoryDtoList = new ArrayList<WikiCategoryDto>();

        wikiCategories.stream().map(category -> wikiCategoryDtoList.add(WikiCategoryDto.getWikiCategoryDto(category)));
        return wikiCategoryDtoList;
    }

    @Override
    public WikiCategoryDto modifyWikiCategory(Integer id, WikiCategoryDto wikiCategoryDto) {
        Optional<WikiCategory> optionalWikiCategory = wikiCategoryRepository.findById(id);
        WikiCategory wikiCategory = optionalWikiCategory.get();
        if (Objects.nonNull(wikiCategoryDto.getName()) && !"".equalsIgnoreCase(wikiCategoryDto.getName())){
            wikiCategory.setName(wikiCategory.getName());
        }
//        if (Objects.nonNull(wikiCategoryDto.getId()) && !"".equalsIgnoreCase(wikiCategoryDto.getId())){
//            wikiCategory.setId(wikiCategory.getId());
//        }

        return WikiCategoryDto.getWikiCategoryDto(wikiCategory);
    }

    @Override
    public Boolean removeWikiCategory(Integer id) {
        Optional<WikiCategory> optionalWikiCategory = wikiCategoryRepository.findById(id);
        if (optionalWikiCategory.isEmpty())return false;

        WikiCategory wikiCategory = optionalWikiCategory.get();
        wikiCategoryRepository.delete(wikiCategory);
        return true;
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
