package com.stackroute.repository;
import com.stackroute.domain.Track;

import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

 public interface TrackRepository extends MongoRepository<Track,Integer> {

 @Query("select track from Track track where track.name like %?1% ")
 List<Track> findByame(String name);
}




