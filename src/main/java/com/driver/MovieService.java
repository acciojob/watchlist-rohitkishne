package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovies(Movies movies)
    {
        String add = movieRepository.addMovies(movies);
        return add;
    }

    public String addDirector(Director director)
    {
        String add = movieRepository.addDirector(director);
        return add;
    }

    public String addMovieDirectorPair(String studentName, String teacherName)
    {
        String add = movieRepository.addMovieDirectorPair(studentName, teacherName);
        return add;
    }

    public Movies getMovieByName(String movieName)
    {
        Movies movies = movieRepository.getMovieByName(movieName);
        return movies;
    }
    public Director getDirectorByName(String teacherName)
    {
        Director director = movieRepository.getDirectorByName(teacherName);
        return director;
    }

    public List<String> getMoviesByDirectorName(String teacherName)
    {
        List<String> getAllStudents = movieRepository.getMoviesByDirectorName(teacherName);
        return getAllStudents;
    }

    public List<String> getAllMovies()
    {
        List<String> allStudents = movieRepository.getAllMovies();
        return allStudents;
    }

    public String deleteDirectorByName(String teacherName)
    {
        String delete = movieRepository.deleteDirectorByName(teacherName);
        return delete;
    }
    public String deleteAllDirectors()
    {
        String delete = movieRepository.deleteAllDirectors();
        return delete;
    }
}

