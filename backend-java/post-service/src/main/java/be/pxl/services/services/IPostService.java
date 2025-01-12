package be.pxl.services.services;

import be.pxl.services.domain.dto.PostRequest;
import be.pxl.services.domain.dto.PostResponse;

import java.util.List;

public interface IPostService {
    List<PostResponse> getAllPosts();
    PostResponse getPostById(Long id);
    void addPost(PostRequest postRequest);

    void updatePost(Long id, PostRequest postRequest);
}
