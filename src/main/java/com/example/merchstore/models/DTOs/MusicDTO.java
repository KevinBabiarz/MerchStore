package com.example.merchstore.models.DTOs;

import com.example.merchstore.models.entities.Music;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MusicDTO {

    private Long id;
    private String name;
    private Long quantity;
    private String img;
    private Long price;
    private String artist;
    private String genre;
    private String album;
    private Long duration;

    public static MusicDTO toDTO(Music music){

        if( music == null )
            return null;

        return MusicDTO.builder()
                .id(music.getId())
                .name(music.getName())
                .quantity(music.getQuantity())
                .img(music.getImg())
                .price(music.getPrice())
                .artist(music.getArtist())
                .genre(music.getGenre())
                .album(music.getAlbum())
                .duration(music.getDuration())
                .build();
    }
}
