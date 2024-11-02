package com.template.user.usecases;

import com.template.common.exceptions.BusinessException;
import com.template.infra.security.TokenService;
import com.template.user.dtos.LoginInput;
import com.template.user.dtos.LoginResponse;
import com.template.user.entity.User;
import com.template.user.helpers.UserMessages;
import com.template.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Login {

  private final TokenService tokenService;
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;

  public ResponseEntity<LoginResponse> execute(LoginInput input) {
    authenticateUser(input);

    var userDB =
        (User)
            userRepository
                .findByEmail(input.email())
                .orElseThrow(() -> new BusinessException(UserMessages.USER_NOT_FOUND_BY_EMAIL));

    var token = tokenService.generateToken(userDB.getEmail());
    var response = new LoginResponse(userDB.getId(), userDB.getName(), userDB.getEmail(), token);

    return ResponseEntity.ok(response);
  }

  private void authenticateUser(LoginInput input) {
    var usernamePasswordToken =
        new UsernamePasswordAuthenticationToken(input.email(), input.password());
    try {
      authenticationManager.authenticate(usernamePasswordToken);
    } catch (Exception exception) {
      throw new BusinessException(UserMessages.USER_INVALID_CREDENTIALS);
    }
  }
}
