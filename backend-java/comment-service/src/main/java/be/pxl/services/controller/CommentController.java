package be.pxl.services.controller;

import be.pxl.services.domain.dto.CommentRequest;
import be.pxl.services.services.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity getCommentById(@PathVariable Long id) {
        return new ResponseEntity(commentService.getComment(id), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity getCommentsByPostId(@PathVariable Long postId) {
        return new ResponseEntity(commentService.getAllCommentsByPostId(postId), HttpStatus.OK);
    }

    //update delete and create comment

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody String content) {
        commentService.updateComment(id, content);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentService.addComment(commentRequest.getPostId(), commentRequest.getContent());
    }




}
