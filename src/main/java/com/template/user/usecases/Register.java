package com.template.user.usecases;

import com.template.common.Messages;
import com.template.common.exceptions.BusinessException;
import com.template.user.dtos.RegisterInput;
import com.template.user.entity.Role;
import com.template.user.entity.User;
import com.template.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Register {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<Void> execute(RegisterInput input) {
        if (userRepository.existsByEmailAndDeletedTrueOrDeletedFalse(input.email())) {
            throw new BusinessException(Messages.USER_ALREADY_EXISTS.getMessage());
        }

        userRepository.save(new User(
                input.name(),
                input.email(),
                passwordEncoder.encode(input.password()),
                Role.ROLE_USER
        ));

        return ResponseEntity.ok().build();
    }

}
