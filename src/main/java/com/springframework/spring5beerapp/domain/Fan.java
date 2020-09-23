package com.springframework.spring5beerapp.domain;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Sex sex;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "fans")
    private List<Beer> beer = new ArrayList<>();

    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    private Review review;

    public void setReview(Review review){
        if (review != null) {
            review.setFan(this);
            this.review = review;
        }
        this.review = review;
    }
}
