package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

 public interface TrackRepository extends MongoRepository<Track,Integer> {

// @Query("select track from Track track where track.name like %?1% ")
 List<Track> findByName(String name);
}




