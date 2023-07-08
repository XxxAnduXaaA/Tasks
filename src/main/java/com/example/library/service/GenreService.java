package com.example.library.service;

import com.example.library.entity.Genre;
import com.example.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre createGenre(Genre genre) {

        if(genreRepository.findByDescription(genre.getDescription()) == null){
            genre.setCreatedAt(new Date());
            genre.setModifiedAt(new Date());
            return genreRepository.save(genre);
        }
        else{
            //TO DO: Заменить return на exception
            return null;
        }
    }

    public Genre getGenreById(Long id){
        return genreRepository.findById(id).orElse(null);
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public Genre updateGenre(Long id, Genre updatedGenre){

        Genre existingGenre = genreRepository.findById(id).orElse(null);

        if(existingGenre != null){
            existingGenre.setDescription(updatedGenre.getDescription());

            existingGenre.setModifiedAt(new Date());
            return genreRepository.save(existingGenre);
        }

        else {
            return null;
        }

    }


}
