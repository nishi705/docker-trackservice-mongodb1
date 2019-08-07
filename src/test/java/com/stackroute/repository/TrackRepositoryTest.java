//package com.stackroute.repository;
//
//
//import com.stackroute.domain.Track;
//import com.stackroute.domain.Track;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//
//public class TrackRepositoryTest {
//@Autowired
//    TrackRepository  trackRepository;
//    Track track;
//
//    @Before
//    public void setUp()
//    {
//        track = new Track();
//        track.setName("John");
//        track.setId(101);
//        track.setComments("hello spring");
//
//    }
//
//    @After
//    public void tearDown(){
//
//        trackRepository.deleteAll();
//    }
//
//
//    @Test
//    public void testSaveTrack(){
//        trackRepository.save(track);
//        Track fetchUser = trackRepository.findById(track.getId()).get();
//        Assert.assertEquals(101,fetchUser.getId());
//
//    }
//
//    @Test
//    public void testSaveTrackFailure(){
//        Track testUser = new Track(34,"herry","Harry123");
//        trackRepository.save(track);
//        Track fetchUser = trackRepository.findById(track.getId()).get();
//        Assert.assertNotSame(testUser,track);
//    }
//
//    @Test
//    public void testGetAllTrack(){
//        Track track1 = new Track(191, "jonny","hellospring");
//        Track track2 = new Track(112, "di","hellospringboot");
//        trackRepository.save(track1);
//        trackRepository.save(track2);
//
//        List<Track> list = trackRepository.findAll();
//        Assert.assertEquals("jonny",list.get(0).getName());
//
//
//
//
//    }
//
//
//}
