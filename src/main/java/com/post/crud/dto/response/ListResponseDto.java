package com.post.crud.dto.response;

import com.post.crud.domain.Post;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListResponseDto {

    private Long postId;
    private String title;
    private String writer;
    private LocalDateTime createdAt;

    public static ListResponseDto fromPost(Post post) {
        return ListResponseDto.builder()
            .postId(post.getPostId())
            .title(post.getTitle())
            .writer(post.getUser().getNickname())
            .createdAt(post.getCreatedAt())
            .build();
    }

    public static List<ListResponseDto> fromList(List<Post> posts) {
        return posts.stream()
            .map(ListResponseDto::fromPost)
            .toList();
    }
}
