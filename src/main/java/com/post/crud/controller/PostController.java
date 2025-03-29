package com.post.crud.controller;

import com.post.crud.dto.request.CreateRequestDto;
import com.post.crud.dto.request.UpdateRequestDto;
import com.post.crud.dto.response.CreateResponseDto;
import com.post.crud.dto.response.DetailResponseDto;
import com.post.crud.dto.response.ListResponseDto;
import com.post.crud.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@RequestBody CreateRequestDto request) {

        CreateResponseDto response = postService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ListResponseDto>> getList() {

        List<ListResponseDto> response = postService.getList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<DetailResponseDto> getDetail(@PathVariable(name = "post_id") Long postId) {

        DetailResponseDto response = postService.getDetail(postId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{post_id}")
    public ResponseEntity update(@PathVariable(name = "post_id") Long postId, @RequestBody
        UpdateRequestDto request) {

        postService.update(postId, request);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity delete(@PathVariable(name = "post_id") Long postId) {

        postService.delete(postId);

        return ResponseEntity.noContent().build();
    }
}
