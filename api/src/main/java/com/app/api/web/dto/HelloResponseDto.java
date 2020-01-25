package com.app.api.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
// 선언된 모든 final 필드 포함생성자 만듬
// final 선언 x 면 안만들어줌
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
