package com.stackroute.service;

import com.stackroute.domain.Track;


import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track);
    public Track getTrackById(int id);
    public List<Track> getAllTrack();
    public Optional<Track>deleteTrackById(int id);
    public List<Track> searchTrackByName(String trackName);
    public List<Track>updateTrackById(String name);



}
