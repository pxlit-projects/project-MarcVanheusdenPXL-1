package be.pxl.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import be.pxl.services.repository.CommentRepository;
import be.pxl.services.domain.Comment;
import be.pxl.services.domain.dto.CommentRequest;
import be.pxl.services.domain.dto.CommentResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;

    @Override
    public void addComment(Long postId, String comment) {
        Comment newComment = new Comment();
        newComment.setPostId(postId);
        newComment.setContent(comment);
        commentRepository.save(newComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public void updateComment(Long commentId, String comment) {
        Comment updatedComment = commentRepository.findById(commentId).
                orElseThrow();
        updatedComment.setContent(comment);
        commentRepository.save(updatedComment);
    }

    private CommentResponse mapToCommentResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPostId())
                .authorId(comment.getAuthorId())
                .content(comment.getContent())
                .date(comment.getDate())
                .build();
    }

    @Override
    public CommentResponse getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return mapToCommentResponse(comment);
    }

    @Override
    public List<CommentResponse> getAllCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        return comments.stream().map(this::mapToCommentResponse).toList();
    }
}
