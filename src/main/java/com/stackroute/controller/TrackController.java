package com.stackroute.controller;


import com.stackroute.domain.Track;
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
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        System.out.println(id);
        Track retrivedTrack = trackService.getTrackById(id);
        return new ResponseEntity<Track>(retrivedTrack, HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track trackOptional = trackService.deleteTrackById(id).get();
        return new ResponseEntity<>(trackOptional, HttpStatus.OK);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {

        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrackById(@PathVariable("id") int id) {
        List<Track> tracksList = trackService.updateTrackById(id);
        return new ResponseEntity<Track>((Track) tracksList,HttpStatus.OK);
    }




}
