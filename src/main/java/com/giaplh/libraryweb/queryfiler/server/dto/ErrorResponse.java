package com.giaplh.libraryweb.queryfiler.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    @Builder.Default
    private long timestamp = System.currentTimeMillis();
}
