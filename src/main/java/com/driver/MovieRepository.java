package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> moviesDB = new HashMap<>();
    HashMap<String, Director> directorDB = new HashMap<>();
    HashMap<String, List<String>> moviesDirectorPairDB = new HashMap<>();

    public String addMovie(Movie movie)
    {
        String movieName = movie.getName();
        moviesDB.put(movieName, movie);
        return "Movie has been Successfully added";
    }

    public String addDirector(Director director)
    {
        String directorName = director.getName();
        directorDB.put(directorName,director);
        return "Director has been Successfully added";
    }

    public String addMovieDirectorPair(String movieName, String directorName)
    {
       if(moviesDirectorPairDB.containsKey(directorName))
       {
           List<String> list = moviesDirectorPairDB.get(directorName);
           list.add(movieName);
           moviesDirectorPairDB.put(directorName, list);
       }
       else
       {
           List<String> list = new ArrayList<>();
           list.add(movieName);
           moviesDirectorPairDB.put(directorName, list);
       }
       return "Movie Director Pair has been added successfullly";
    }

    public Movie getMovieByName(String movieName)
    {
        Movie movie = moviesDB.get(movieName);
        return movie;
    }
    public Director getDirectorByName(String directorName)
    {
        Director director = directorDB.get(directorName);
        return director;
    }

    public List<String> getMoviesByDirectorName(String directorName)
    {
        List<String> movieByDirectorName = moviesDirectorPairDB.get(directorName);
        return movieByDirectorName;
    }

    public List<String> getAllMovies(){
        List<String> allMovies = new ArrayList<>();

        for(String name : moviesDB.keySet())
        {
            allMovies.add(name);
        }

        return allMovies;
    }

    public String deleteDirectorByName(String directorName)
    {
        List<String> movies = moviesDirectorPairDB.get(directorName);
        for(String movie : movies)
        {
            moviesDB.remove(movie);
        }
        moviesDirectorPairDB.remove(directorName);
        directorDB.remove(directorName);

        return "Director and its Students are deleted Successfully";
    }
    public String deleteAllDirectors()
    {
        for(String director : directorDB.keySet())
        {
            List<String> movie = moviesDirectorPairDB.get(director);
            for(String name : movie)
            {
                moviesDB.remove(name);
            }
            moviesDirectorPairDB.remove(director);
            directorDB.remove(director);
        }
        return "Director and its Students are deleted Successfully";
    }
}
