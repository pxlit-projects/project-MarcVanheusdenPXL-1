package be.pxl.services.client;

import be.pxl.services.domain.dto.PostRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "comment-service") // -> naam van de service
public interface CommentClient {

    @PostMapping("/comment/")
    void sendNotification(@RequestBody PostRequest postRequest);

    @DeleteMapping("/comment")
    void deleteNotifications(@RequestBody PostRequest postRequest);
}

