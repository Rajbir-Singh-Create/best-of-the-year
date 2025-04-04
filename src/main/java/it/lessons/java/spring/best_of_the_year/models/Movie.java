package it.lessons.java.spring.best_of_the_year.models;

public class Movie {
    private int id;
    private String title;
    private String anno;
    private String director;
    private String studio;

    public Movie(int id, String title, String anno, String director, String studio) {
        this.id = id;
        this.title = title;
        this.anno = anno;
        this.director = director;
        this.studio = studio;
    }

    public String getAnno() {
        return anno;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
