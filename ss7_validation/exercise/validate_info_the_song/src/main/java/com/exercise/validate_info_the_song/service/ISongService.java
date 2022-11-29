package com.exercise.validate_info_the_song.service;

import com.exercise.validate_info_the_song.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    Optional<Song> findById(int id);

    void save(Song song);
}
