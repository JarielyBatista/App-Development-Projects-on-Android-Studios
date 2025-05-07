package com.example.hwk8;

import java.io.Serializable;

public class Song implements Serializable {
    private String rank;
    private String musicTitle;
    private String singer;
    private String studioAlbum;
    private int albumCover;
    private String videoUrl;

    public Song(String rank, String musicTitle, String singer, String studioAlbum, int albumCover, String videoUrl) {
        this.rank = rank;
        this.musicTitle = musicTitle;
        this.singer = singer;
        this.studioAlbum = studioAlbum;
        this.albumCover = albumCover;
        this.videoUrl = videoUrl;
    }

    public String getRank() {
        return rank;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public String getSinger() {
        return singer;
    }

    public String getStudioAlbum() {
        return studioAlbum;
    }

    public int getAlbumCover() {
        return albumCover;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
