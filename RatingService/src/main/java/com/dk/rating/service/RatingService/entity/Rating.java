package com.dk.rating.service.RatingService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_rating")
public class Rating {
    @Id
    private String id;
    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;
}
