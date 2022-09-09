package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    /**
     * Function name: addMovie
     *
     * @param movie Inside the function:
     *              1. adds a movie object
     */
    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }


    public int getMovieIndex(String name) {
        return IntStream.range(0, movies.size())
                .filter((i) -> movies.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1000);
    }

    public void sellMovie(String name) {
        if(!(movies.get(getMovieIndex(name)).isAvailable())) throw new  IllegalStateException("its unavailable to sell");
        movies.removeIf((movie) -> movie.getName().equals(name));
    }
    public void rentMovie(String name) {
        movies.get(getMovieIndex(name)).setAvailable(false);
    }

    public void returnMovie(String name) {
        movies.get(getMovieIndex(name)).setAvailable(false);
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
