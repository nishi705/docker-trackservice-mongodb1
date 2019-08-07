package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("track already exist");
        }

        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
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
    public List<Track> searchTrackByName(String name) throws TrackNotFoundException {
        List<Track> foundTracksList = trackRepository.findByName(name);
        if (foundTracksList.isEmpty()) {
            throw new TrackNotFoundException("get by name not found");
        }
        return foundTracksList;
    }


    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        if (trackRepository.existsById(id)) {
            Optional<Track> optional = trackRepository.findById(id);
            trackRepository.deleteById(id);
            return optional;
        }
        throw new TrackNotFoundException("deleted track");
    }


    @Override
    public Track updateTrackById(int id, Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(id)) {
            Track trackBeforeUpdate = trackRepository.findById(id).get();
            track.setComments(track.getComments());
            track.setName(track.getName());

            return trackRepository.save(track);
        }
        throw new TrackNotFoundException("update failed");
    }
}