package com.example.kalasethubackend.service;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepo;

    public ArtistService(ArtistRepository artistRepo) {
        this.artistRepo = artistRepo;
    }

    public Artist addArtist(Artist artist) {
        return artistRepo.save(artist);
    }

    public List<Artist> getAllArtists() {
        return artistRepo.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepo.findById(id).orElse(null);
    }

    public Artist updateArtist(Long id,Artist artist) {
            artist.setArtistId(id);
            return artistRepo.save(artist);
    }

    public void deleteArtistById(@PathVariable Long id) {
         artistRepo.deleteById(id);
    }

    public List<Artist> getActiveArtists(){
        return artistRepo.findByActiveTrue();
    }

}
