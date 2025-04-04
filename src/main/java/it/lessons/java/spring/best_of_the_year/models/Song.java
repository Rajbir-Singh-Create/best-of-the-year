package it.lessons.java.spring.best_of_the_year.models;

public class Song {
    private int id;
    private String title;
    private String autore;
    private String album;
    private String anno;

    public Song(int id, String title, String autore, String album, String anno) {
        this.id = id;
        this.title = title;
        this.autore = autore;
        this.album = album;
        this.anno = anno;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAutore() {
        return autore;
    }

    public String getAlbum() {
        return album;
    }

    public String getAnno() {
        return anno;
    }
}
