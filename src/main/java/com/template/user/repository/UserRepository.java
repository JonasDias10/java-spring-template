package com.template.user.repository;

import com.template.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserDetails> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndDeletedTrueOrDeletedFalse(@Param("email") String email);

}
