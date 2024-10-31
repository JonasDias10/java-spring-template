package com.template.common.dtos;

public record ResponseData<T>(
        Long total,
        T data
) {
}

