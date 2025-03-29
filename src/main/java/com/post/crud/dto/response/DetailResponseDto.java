package com.post.crud.dto.response;

import com.post.crud.domain.Post;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailResponseDto {

    private Long postId;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DetailResponseDto from(Post post) {
        return DetailResponseDto.builder()
            .postId(post.getPostId())
            .title(post.getTitle())
            .writer(post.getUser().getNickname())
            .content(post.getContent())
            .createdAt(post.getCreatedAt())
            .updatedAt(post.getUpdatedAt())
            .build();
    }
}
