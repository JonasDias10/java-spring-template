package com.template.user.usecases;

import com.template.common.exceptions.BusinessException;
import com.template.user.helpers.UserMessages;
import com.template.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUser {

  private final UserRepository userRepository;

  public ResponseEntity<Void> execute(Long id) {
    var user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new BusinessException(UserMessages.USER_NOT_FOUND));

    userRepository.delete(user);

    return ResponseEntity.ok().build();
  }
}
