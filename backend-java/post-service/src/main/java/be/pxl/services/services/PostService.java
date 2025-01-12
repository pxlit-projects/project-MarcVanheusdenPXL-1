package be.pxl.services.services;

import be.pxl.services.domain.Post;
import be.pxl.services.domain.dto.PostRequest;
import be.pxl.services.domain.dto.PostResponse;
import be.pxl.services.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapToPostResponse).toList();
    }

    //method to get post by id
    @Override
    public PostResponse getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return mapToPostResponse(post);
    }

    @Override
    public void addPost(PostRequest postRequest) {
        Post post = Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .author(postRequest.getAuthor())
                .date(postRequest.getDate())
                .isDraft(postRequest.getIsDraft())
                .isPublished(postRequest.getIsPublished())
                .build();
        postRepository.save(post);
    }


    private PostResponse mapToPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .date(post.getDate())
                .isDraft(post.getIsDraft())
                .isPublished(post.getIsPublished())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    @Override
    public void updatePost(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(postRequest.getAuthor());
        post.setDate(postRequest.getDate());
        post.setIsDraft(postRequest.getIsDraft());
        post.setIsPublished(postRequest.getIsPublished());
        postRepository.save(post);
    }

}
