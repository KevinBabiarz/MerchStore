package com.example.merchstore.models.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("music")
public class Music extends Product{

private String artist;
    private String genre;
    private String album;
    private Long duration;

    public Music(String artist, String genre, String album, Long duration, String name, Long quantity, String img, Long price) {
        super(name, quantity, img, price);
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.duration = duration;
    }

    public Music() {
        super(
        );
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
