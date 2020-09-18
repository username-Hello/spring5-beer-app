package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Review;
import com.springframework.spring5beerapp.repositories.ReviewRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAll() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().iterator().forEachRemaining(reviews::add);
        return reviews;
    }

    @Override
    public Review findById(Long id) throws NotFoundException {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isEmpty()){
            throw new NotFoundException("Review doesn't exist");
        }
        return reviewOptional.get();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
