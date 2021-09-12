package CC;
import java.util.ArrayList;
import java.util.Collections;

/* use to sort single element */
class Movie implements Comparable<Movie>{
    private double rating;
    private String name;
    private int year;
    Movie(String name, double rating, int year){
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
    /* used to sort movie by year */
    public int compareTo(Movie object){
        return this.year - object.year;
    }
    /* getters to access private elements */
    public int getYear(){ return this.year; }
    public double getRating() { return rating; }
    public String getName() { return name; }
}

public class ComparableInterface {
    public static void main(String[] args){
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("DJ", 8.3, 2015));
        movies.add(new Movie("Force", 6.9, 1977));
        movies.add(new Movie("AFO", 7.2, 1980));
        movies.add(new Movie("JP", 8.8, 1983));
        movies.add(new Movie("AK", 9.0, 2021));
        Collections.sort(movies);
        for (Movie m : movies)
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
    }
}