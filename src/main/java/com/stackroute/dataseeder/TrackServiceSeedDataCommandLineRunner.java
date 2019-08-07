//package com.stackroute.dataseeder;
//
//import com.stackroute.domain.Track;
//import com.stackroute.exceptions.TrackAlreadyExistsException;
//import com.stackroute.repository.TrackRepository;
//import com.stackroute.service.TrackService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//
////To create getters and setters for all properties, to override toString(),
//// to create equals, canEquals and HashCode.
////@ConfigurationProperties(prefix = "track4")
////Used to get the data prefix with track4 and matches with the property name.
// public class TrackServiceSeedDataCommandLineRunner implements CommandLineRunner {
//    TrackService trackService;
//
//    //Used to particularly mention the bean name.
//    //private TrackRepository trackRepository;
//
//    @Autowired
//    public TrackServiceSeedDataCommandLineRunner(TrackRepository trackRepository) {
//        this.trackService = trackService;
//    }
//
//
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        //        Create seed data objects
//        Track track1 = new Track(4, "Track 4", "Comment from CommandLineRunner");
//        Track track2 = new Track(5, "Track 5", "Comment from CommandLineRunner");
//        Track track3 = new Track(6, "Track 6", "Comment from CommandLineRunner");
//        try {
//            trackService.saveTrack(track1);
//            trackService.saveTrack(track2);
//            trackService.saveTrack(track3);
//        } catch (TrackAlreadyExistsException trackAlreadyExistExceptions) {
//            trackAlreadyExistExceptions.printStackTrace();
//        }
//    }
//}