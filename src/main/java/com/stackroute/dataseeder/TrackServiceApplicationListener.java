package com.stackroute.dataseeder;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TrackServiceApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    public TrackService trackService;

    @Autowired
    public  TrackServiceApplicationListener(TrackService trackService)
    {
        this.trackService=trackService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track1 = new Track(1, "Track 1", "Comment 1");
        Track track2=new Track(2,"track 2","comment 2");
        Track track3=new Track(3,"track 3","comment 3");
        try{
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);

        }catch(TrackAlreadyExistsException trackAlreadyExistsException )
        {
            trackAlreadyExistsException.printStackTrace();
        }


    }
}
