package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.ReviewCommand;
import com.springframework.spring5beerapp.domain.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewCommandToReview implements Converter<ReviewCommand, Review> {

    @Override
    public Review convert(ReviewCommand reviewCommand) {
        Review review = new Review();
        review.setId(reviewCommand.getId());
        review.setText(reviewCommand.getText());
        return review;
    }
}
