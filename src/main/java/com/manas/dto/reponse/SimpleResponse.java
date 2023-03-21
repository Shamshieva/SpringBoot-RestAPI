package com.manas.dto.reponse;

import lombok.Builder;

@Builder
public record SimpleResponse(
        String status,
        String message
) {
}
