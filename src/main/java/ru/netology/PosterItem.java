package ru.netology;

public class PosterItem {
    private int id;
    private String imageUrl;
    private String title;
    private String genre;

    public PosterItem(int id, String imageUrl, String title, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}