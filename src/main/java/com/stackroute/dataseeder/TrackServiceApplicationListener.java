//package com.stackroute.dataseeder;
//
//import com.stackroute.domain.Track;
//import com.stackroute.exceptions.TrackAlreadyExistsException;
//import com.stackroute.exceptions.TrackNotFoundException;
//import com.stackroute.service.TrackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
////@PropertySource("classpath:application.properties")
////used to specify the path of the resource file.
//class TrackServiceApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
//    //Used to particularly mention the bean name.
//    private TrackService trackService;
//
//    @Autowired
//    public TrackServiceApplicationListener(TrackService trackService) {
//        this.trackService = trackService;
//    }
//
//
//
//    @Autowired
//    private Environment environment;
//    @Value ("${id}")
//    int id;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event){
//       // Track track1 = new Track(trackId, trackName, trackComments);
//        //Track track2 = new Track(Integer.parseInt(environment.getProperty("track2.id")),
//              //  environment.getProperty("track2.name"), environment.getProperty("track2.comments"));
//        try {
//            trackService.saveTrack(new Track(id, environment.getProperty("trackName"), environment.getProperty("comments")));
//        } catch (TrackAlreadyExistsException trackAlreadyExistExceptions) {
//            trackAlreadyExistExceptions.printStackTrace();
//        }
//
//
//        }
//
//}