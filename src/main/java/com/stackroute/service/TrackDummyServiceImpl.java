package com.stackroute.service;

//There may be a situation when you create more than one bean of the same type and want to
// wire only one of them with a property. In such cases, you can use the @Qualifier
// annotation along with @Autowired to remove the confusion by specifying which exact bean will be wired.


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class TrackDummyServiceImpl implements TrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getAllTrack() throws Exception {
        return null;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        return Optional.empty();
    }

    @Override
    public List<Track> searchTrackByName(String name) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track updateTrackById(int id, Track track) throws TrackNotFoundException {
        return null;
    }


}








