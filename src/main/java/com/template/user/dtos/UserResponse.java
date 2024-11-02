package com.template.user.dtos;

import com.template.user.entity.Role;

public record UserResponse(Long id, String name, String email, Role role, boolean deleted) {}
