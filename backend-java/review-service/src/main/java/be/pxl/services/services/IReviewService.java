package be.pxl.services.services;


import be.pxl.services.domain.dto.ReviewRequest;
import be.pxl.services.domain.dto.ReviewResponse;

public interface IReviewService {
    void createReview(ReviewRequest reviewRequest);
    ReviewResponse getReviewById(Long id);
}
