package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/")
public class TrackController {
    private TrackService trackService;

    public TrackController() {
    }

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    //here we will handle the exception
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException, TrackNotFoundException {


        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);


    }


    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
        Track retrievedTrack = trackService.getTrackById(id);
        return new ResponseEntity<>(retrievedTrack, HttpStatus.OK);


    }


    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {

        Optional<Track> optionalTrack = trackService.deleteTrackById(id);
        return new ResponseEntity<>(optionalTrack, HttpStatus.OK);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() throws Exception {

        List<Track> trackList = trackService.getAllTrack();
        return new ResponseEntity<>(trackList, HttpStatus.OK);

    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackById(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException {

        Track updatedTrack = trackService.updateTrackById(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);

    }

    @GetMapping("tracks/name/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String trackName) throws TrackNotFoundException {

        List<Track> foundTracksList = trackService.searchTrackByName(trackName);
        return new ResponseEntity<>(foundTracksList, HttpStatus.OK);
    }
}






