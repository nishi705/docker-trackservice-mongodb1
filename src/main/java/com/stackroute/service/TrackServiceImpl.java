package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {

        Track retrievedTrack = trackRepository.findById(id).get();
        return retrievedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> deleteTrackById(int id) {
        Optional<Track> optional = trackRepository.findById(id);
        if (optional.isPresent()) {
            trackRepository.deleteById(id);
        }
        return optional;


    }

    @Override
    public List<Track> updateTrackById(int id) {
        List<Track> optional=trackRepository.findAll();
        
    }
}
