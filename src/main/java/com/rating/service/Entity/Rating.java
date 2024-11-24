package com.rating.service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;
    @Column(name="user_id")
    private String userId;
    @Column(name="hotel_id")
    private String hotelId;
    @Column(name="rating")
    private int rating;
    @Column(name="feedback",length = 255)
    private String feedback;
}
