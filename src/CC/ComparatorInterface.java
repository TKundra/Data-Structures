package CC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* use to sort multiple elements */
class Movies implements Comparable<Movies>{
    private double rating;
    private String name;
    private int year;
    Movies(String name, double rating, int year){
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
    /* used to sort movie by year */
    public int compareTo(Movies object){
        return this.year - object.year;
    }
    /* getters to access private elements */
    public int getYear(){ return this.year; }
    public double getRating() { return rating; }
    public String getName() { return name; }
}

/* to compare movie by rating */
class RatingCompare implements Comparator<Movies> {
    @Override
    public int compare(Movies o1, Movies o2) {
        if (o1.getRating() > o2.getRating())
            return 1;
        else if (o1.getRating() < o2.getRating())
            return -1;
        return 0;
    }
}
/* to compare movie by name */
class NameCompare implements Comparator<Movies>{
    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class ComparatorInterface {
    public static void main(String[] args){
        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(new Movies("DJ", 8.3, 2015));
        movies.add(new Movies("Force", 6.9, 1977));
        movies.add(new Movies("AFO", 7.2, 1980));
        movies.add(new Movies("JP", 8.8, 1983));
        movies.add(new Movies("AK", 9.0, 2021));

        System.out.println("sort by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(movies, ratingCompare);
        for (Movies m : movies)
            System.out.println(m.getRating() +  " " + m.getName() + " " + m.getYear());

        System.out.println("\nsort by name");
        NameCompare nameCompare = new NameCompare();
        movies.sort(nameCompare);
        for (Movies m : movies)
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());

        System.out.println("\nsort by year");
        Collections.sort(movies);
        for (Movies m : movies)
            System.out.println(m.getYear() + " " + m.getName() + " " + m.getRating());

    }
}
/*
    sort by rating
    6.9 Force 1977
    7.2 AFO 1980
    8.3 DJ 2015
    8.8 JP 1983
    9.0 AK 2021

    sort by name
    AFO 7.2 1980
    AK 9.0 2021
    DJ 8.3 2015
    Force 6.9 1977
    JP 8.8 1983

    sort by year
    1977 Force 6.9
    1980 AFO 7.2
    1983 JP 8.8
    2015 DJ 8.3
    2021 AK 9.0
*/


