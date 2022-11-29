package com.exercise.validate_info_the_song.service.impl;

import com.exercise.validate_info_the_song.model.Song;
import com.exercise.validate_info_the_song.repository.ISongRepository;
import com.exercise.validate_info_the_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
