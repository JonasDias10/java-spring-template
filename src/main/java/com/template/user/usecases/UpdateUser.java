package com.template.user.usecases;

import com.template.common.exceptions.BusinessException;
import com.template.user.dtos.UpdateInput;
import com.template.user.entity.User;
import com.template.user.helpers.UserMessages;
import com.template.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUser {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public ResponseEntity<Void> execute(Long id, UpdateInput input) {
    var user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new BusinessException(UserMessages.USER_NOT_FOUND));

    validateEmail(input.email(), user.getEmail());

    updateUserDetails(user, input);
    userRepository.save(user);

    return ResponseEntity.ok().build();
  }

  private void validateEmail(String newEmail, String currentEmail) {
    if (newEmail != null && emailAlreadyExists(currentEmail, newEmail)) {
      throw new BusinessException(UserMessages.USER_EMAIL_ALREADY_EXISTS);
    }
  }

  private void updateUserDetails(User user, UpdateInput input) {
    if (input.name() != null) {
      user.setName(input.name());
    }
    if (input.email() != null) {
      user.setEmail(input.email());
    }
    if (input.password() != null) {
      user.setPassword(passwordEncoder.encode(input.password()));
    }
  }

  private boolean emailAlreadyExists(String currentEmail, String newEmail) {
    return !currentEmail.equals(newEmail)
        && userRepository.existsByEmailIgnoringSoftDelete(newEmail);
  }
}
