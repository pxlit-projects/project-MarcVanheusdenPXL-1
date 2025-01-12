package be.pxl.services.services;

import be.pxl.services.domain.dto.CommentResponse;
import be.pxl.services.domain.dto.CommentRequest;

import java.util.List;

public interface ICommentService {
    void addComment(Long postId, String comment);
    void deleteComment(Long commentId);
    void updateComment(Long commentId, String comment);

    CommentResponse getComment(Long commentId);
    List<CommentResponse>getAllCommentsByPostId(Long postId);

}
