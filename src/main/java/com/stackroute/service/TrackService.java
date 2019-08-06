package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;


import java.util.List;
import java.util.Optional;


public interface TrackService {
    public  Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public Track getTrackById(int id) throws TrackNotFoundException;
    public List<Track> getAllTrack() throws Exception;
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;
    public List<Track> searchTrackByName(String name) throws TrackNotFoundException ;
    public Track updateTrackById(int id,Track track) throws TrackNotFoundException;
}
