package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.ReviewCommand;
import com.springframework.spring5beerapp.converters.ReviewCommandToReview;
import com.springframework.spring5beerapp.converters.ReviewToReviewCommand;
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
    private final ReviewToReviewCommand reviewToReviewCommand;
    private final ReviewCommandToReview reviewCommandToReview;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             ReviewToReviewCommand reviewToReviewCommand,
                             ReviewCommandToReview reviewCommandToReview) {
        this.reviewRepository = reviewRepository;
        this.reviewToReviewCommand = reviewToReviewCommand;
        this.reviewCommandToReview = reviewCommandToReview;
    }

    @Override
    public List<ReviewCommand> getAll() {
        List<ReviewCommand> reviewCommands = new ArrayList<>();
        reviewRepository
                .findAll()
                .iterator()
                .forEachRemaining(review -> reviewCommands.add(reviewToReviewCommand.convert(review)));
        return reviewCommands;
    }

    @Override
    public ReviewCommand findById(Long id) throws NotFoundException {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isEmpty()){
            throw new NotFoundException("Review doesn't exist");
        }
        return reviewToReviewCommand.convert(reviewOptional.get());
    }

    @Override
    public ReviewCommand save(ReviewCommand reviewCommand) {
        return reviewToReviewCommand
                .convert(reviewRepository
                        .save(reviewCommandToReview.convert(reviewCommand)));
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
