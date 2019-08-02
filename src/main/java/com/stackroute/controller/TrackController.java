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
    //        Track savedTrack = trackService.saveTrack(track);
//        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
//    }

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


//        System.out.println(id);
//        Track retrivedTrack = trackService.getTrackById(id);
//        return new ResponseEntity<Track>(retrivedTrack, HttpStatus.OK);
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track trackOptional = trackService.deleteTrackById(id).get();
        return new Respopackage com.stackroute.controller;


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
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
    ResponseEntity responseEntity;
    try{
        Track savedTrack = trackService.saveTrack(track);
        responseEntity = new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
    }catch(TrackAlreadyExistsException ex)
    {
        responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
    }
     return responseEntity;

    }
    //        Track savedTrack = trackService.saveTrack(track);
//        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
//    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try{
            Track retrievedTrack=trackService.getTrackById(id);
            responseEntity=new ResponseEntity<>(retrievedTrack,HttpStatus.OK);
        }catch(TrackNotFoundException ex)
        {
            responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;



//        System.out.println(id);
//        Track retrivedTrack = trackService.getTrackById(id);
//        return new ResponseEntity<Track>(retrivedTrack, HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track trackOptional = trackService.deleteTrackById(id).get();
        return new ResponseEntity<>(trackOptional, HttpStatus.OK);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {
        try{
            List<Track> trackList=trackService.getAllTrack();
             return new ResponseEntity<>(trackList,HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        {

        }


        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrackById(@PathVariable String name) {
        Track updatedTrack = (Track) trackService.updateTrackById(name);
        return new ResponseEntity<>(updatedTrack,HttpStatus.OK);
    }
    @GetMapping("track/search/name/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String name)
    {
        List<Track> foundTracksList = trackService.searchTrackByName(name);
        return new ResponseEntity<>(foundTracksList, HttpStatus.OK);
    }
    }





nseEntity<>(trackOptional, HttpStatus.OK);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {

        return new ResponseEntity<>(trackService.getAllTrack(), HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrackById(@PathVariable String name) {
        Track updatedTrack = (Track) trackService.updateTrackById(name);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    @GetMapping("track/search/name/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String name) {
        List<Track> foundTracksList = trackService.searchTrackByName(name);
        return new ResponseEntity<>(foundTracksList, HttpStatus.OK);
    }
}





