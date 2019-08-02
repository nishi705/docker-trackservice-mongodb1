package com.stackroute.dataseeder;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrackServiceSeedDataCommandLineRunner implements CommandLineRunner {
    TrackService trackService;


    @Autowired
    public TrackServiceSeedDataCommandLineRunner(TrackService trackService)
    {
        this.trackService=trackService;

    }


    @Override
    public void run(String... args) throws Exception {
        Track track1 = new Track(11, "Track 11", "Comment from CommandLineRunner");
        Track track2=new Track(12,"Track 12","Comment from CommandLineRnnner");
        Track track3=new Track(13,"Track 13","Comment from CommandLineRunner");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        } catch (TrackAlreadyExistsException trackAlreadyExistsException) {
            trackAlreadyExistsException.printStackTrace();

        }


    }
}
