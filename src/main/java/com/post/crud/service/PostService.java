package com.post.crud.service;

import com.post.crud.domain.Post;
import com.post.crud.domain.User;
import com.post.crud.dto.request.CreateRequestDto;
import com.post.crud.dto.request.UpdateRequestDto;
import com.post.crud.dto.response.CreateResponseDto;
import com.post.crud.dto.response.DetailResponseDto;
import com.post.crud.dto.response.ListResponseDto;
import com.post.crud.repository.PostRepository;
import com.post.crud.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CreateResponseDto create(CreateRequestDto request) {

        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("유효한 아이디가 없습니다"));

        Post post = Post.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .user(user)
            .build();

        Post postSaved = postRepository.save(post);

        return CreateResponseDto.from(postSaved);
    }

    public List<ListResponseDto> getList() {

        List<Post> getList = postRepository.findAll();

        return ListResponseDto.fromList(getList);
    }

    public DetailResponseDto getDetail(Long postId) {

        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("유효한 포스트가 없습니다"));

        return DetailResponseDto.from(post);
    }

    public void update(Long postId, UpdateRequestDto request) {

        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("유효한 포스트가 없습니다"));

        post.update(request.getTitle(), request.getContent());

        postRepository.save(post);
    }

    public void delete(Long postId) {

        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("유효한 포스트가 없습니다"));

        post.softDelete();

        postRepository.save(post);
    }
}
