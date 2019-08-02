package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("track already exist");
        }

        Track savedTrack = trackRepository.save(track);
        {
            if (savedTrack == null)
                throw new TrackAlreadyExistsException("track already exist");
        }
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("track not exist");
        }
        Track retrievedTrack = trackRepository.findById(id).get();
        return retrievedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> searchTrackByName(String name) {
        List<Track> foundTracksList = trackRepository.searchTrackByName(name);
        return foundTracksList;
    }


    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException{
        Optional<Track> optional = trackRepository.findById(id);
        if (optional.isPresent()) {
            trackRepository.deleteById(id);
        }
        return optional;


    }

    @Override
    public List<Track> updateTrackById(String name) {
//        Gets the reference to the Track object (lazy)
        List<Track> tracks = trackRepository.searchTrackByName(name);
        return tracks;


    }
}