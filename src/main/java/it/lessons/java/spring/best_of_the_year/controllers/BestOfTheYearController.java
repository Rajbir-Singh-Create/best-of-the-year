package it.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lessons.java.spring.best_of_the_year.models.Movie;
import it.lessons.java.spring.best_of_the_year.models.Song;


@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    // Step 1
    @GetMapping()
    public String bestOfTheYear(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        
        return "bestOfTheYear";
    }

    // Step 2
    // Metodo che deve ritornare una lista di oggetti
    // di tipo Movie
    private List<Movie> getBestMovies(){
        // Istanzio degli oggetti e li salvo in variabili
        Movie m1 = new Movie(1, "Fury");
        Movie m2 = new Movie(2, "Pirates of the Caribbean");
        Movie m3 = new Movie(3, "Man of steel");

        // Creo una lista di movies e aggiungo le istanze create
        // in precedenza
        List<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);

        // Ritorno la lista
        return movies;
    }

    private List<Song> getBestSongs(){
        Song s1 = new Song(11, "Phantom Fear");
        Song s2 = new Song(22, "Nihilist");
        Song s3 = new Song(33, "Memento Mori");
        
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);

        return songs;
    }

    @GetMapping("movies")
    public String movies(Model model) {
        // Creo una lista di tipo Movie
        // inserisco al suo interno gli elementi istanziati nel metodo getBestMovies()
        List<Movie> movies = getBestMovies();
        // Inserisco la lista nel Model come valore da passare alla view
        // tramite l'attributo moviesList
        model.addAttribute("moviesList", movies);

        // Stringa di film
        // String moviesString = "";
        // for(Movie m : movies){
        //     moviesString += m.getTitle() + ", ";
        // }
        // moviesString = moviesString.substring(0, moviesString.length()-2);
        // model.addAttribute("moviesListString", moviesString);

        return "bestMovies";
    }

    @GetMapping("songs")
    public String songs(Model model){
        List<Song> songs = getBestSongs();
        model.addAttribute("songsList", songs);

        // Stringa di canzoni
        // String songsList = "";
        // for (Song song : songs) {
        //     songsList += song.getTitle() + ", ";
        // }
        // songsList = songsList.substring(0, songsList.length()-2);
        // model.addAttribute("songsListString", songsList);        

        return "bestSongs";
    }

    @GetMapping("movies/{id}")
    public String filterMovieById(@PathVariable("id") int movieId, Model model) {
        List<Movie> movies = getBestMovies();
        for(Movie m : movies){
            if(m.getId() == movieId){
                model.addAttribute("filteredMovie", m);
                break;
            }
        }
        return "searchMovie";
    }
    
    @GetMapping("songs/{id}")
    public String filterSongById(@PathVariable("id") int songId, Model model) {
        List<Song> songs = getBestSongs();
        for (Song s : songs) {
            if(s.getId() == songId){
                model.addAttribute("filteredSong", s);
                break;
            }
        }
        
        return "searchSongs";
    }
    

}
