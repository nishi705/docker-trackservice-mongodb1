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
public class TrackController<Optional> {
    private TrackService trackService;

    public TrackController() {
    }

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    //here we will handle the exception
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            Track savedTrack = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            Track retrievedTrack = trackService.getTrackById(id);
            responseEntity = new ResponseEntity<>(retrievedTrack, HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;


    }


    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {

        try {
            Optional<> optionalTrack = trackService.deleteTrackById(id);
            return new ResponseEntity<>(optionalTrack, HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {
        try {
            List<Track> trackList = trackService.getAllTrack();
            return new ResponseEntity<>(trackList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackById(@PathVariable int id, @RequestBody Track track) {
        try {
            Track updatedTrack = trackService.updateTrackById(id, track);
            return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
        } catch (TrackNotFoundException tr) {
            return new ResponseEntity<>(tr.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("tracks/name/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String name) {
        try {
            List<Track> foundTracksList = trackService.searchTrackByName(name);
            return new ResponseEntity<>(foundTracksList, HttpStatus.OK);
        } catch (TrackNotFoundException tr) {
            return new ResponseEntity<>(tr.getMessage(), HttpStatus.OK);
        }
    }


}





