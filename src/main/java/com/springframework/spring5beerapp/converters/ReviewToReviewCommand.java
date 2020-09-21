package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.ReviewCommand;
import com.springframework.spring5beerapp.domain.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewCommand implements Converter<Review, ReviewCommand> {

    @Override
    public ReviewCommand convert(Review review) {
        ReviewCommand reviewCommand = new ReviewCommand();
        reviewCommand.setId(review.getId());
        reviewCommand.setText(review.getText());
        return reviewCommand;
    }
}
