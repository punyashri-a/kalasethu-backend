package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.service.ArtistService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @PostMapping
    public Artist addArtist(@RequestBody Artist artist){
        return artistService.addArtist(artist);
    }

    @GetMapping
    public List<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id){
        return artistService.getArtistById(id);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id,@RequestBody Artist artist){
        return artistService.updateArtist(id,artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtistById(@PathVariable Long id){
         artistService.deleteArtistById(id);
    }


}
