package com.template.user.controller;

import com.template.common.dtos.ResponseData;
import com.template.user.dtos.*;
import com.template.user.usecases.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

  private final Login login;
  private final Register register;
  private final UpdateUser updateUser;
  private final DeleteUser deleteUser;
  private final FindAllUsers findAllUsers;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/all")
  public ResponseEntity<ResponseData<Iterable<UserResponse>>> findAll(
      @RequestParam(name = "take", required = false, defaultValue = "10") Integer take,
      @RequestParam(name = "skip", required = false, defaultValue = "0") Integer skip) {
    return findAllUsers.execute(take, skip);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginInput input) {
    return login.execute(input);
  }

  @PostMapping("/register")
  public ResponseEntity<Void> register(@RequestBody @Valid RegisterInput input) {
    return register.execute(input);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(
      @PathVariable(name = "id") Long id, @RequestBody @Valid UpdateInput input) {
    return updateUser.execute(id, input);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
    return deleteUser.execute(id);
  }
}
