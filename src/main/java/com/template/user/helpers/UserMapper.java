package com.template.user.helpers;

import com.template.user.dtos.UserResponse;
import com.template.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "role", target = "role")
  UserResponse toUserResponse(User user);

  Iterable<UserResponse> toUsersResponse(Iterable<User> users);
}
