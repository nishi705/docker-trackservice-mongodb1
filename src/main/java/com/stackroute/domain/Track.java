package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    //id annotation make id variable as primary key
    @Id
    private int id;
    private String name;
    private String comments;



}