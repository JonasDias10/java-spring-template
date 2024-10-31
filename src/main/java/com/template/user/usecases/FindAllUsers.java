package com.template.user.usecases;

import com.template.common.dtos.ResponseData;
import com.template.user.dtos.UserResponse;
import com.template.user.helpers.UserMapper;
import com.template.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllUsers {

    private final UserRepository userRepository;

    public ResponseEntity<ResponseData<Iterable<UserResponse>>> execute(Integer take, Integer skip) {
        Pageable pageable = Pageable.ofSize(take).withPage(skip);

        var users = userRepository.findAll(pageable);

        var total = users.getTotalElements();
        var content = users.getContent();

        var response = new ResponseData<>(
                total,
                UserMapper.INSTANCE.toUsersResponse(content)
        );

        return ResponseEntity.ok().body(response);
    }
}
