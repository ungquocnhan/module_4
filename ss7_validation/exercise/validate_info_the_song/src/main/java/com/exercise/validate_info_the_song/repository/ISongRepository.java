package com.exercise.validate_info_the_song.repository;

import com.exercise.validate_info_the_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
