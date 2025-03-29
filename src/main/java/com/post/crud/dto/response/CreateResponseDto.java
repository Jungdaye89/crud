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
public class CreateResponseDto {

    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    public static CreateResponseDto from(Post post) {
        return CreateResponseDto.builder()
            .title(post.getTitle())
            .content(post.getContent())
            .writer(post.getUser().getNickname())
            .createdAt(post.getCreatedAt())
            .build();
    }
}
