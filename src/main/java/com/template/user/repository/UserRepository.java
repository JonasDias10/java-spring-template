package com.template.user.repository;

import com.template.user.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<UserDetails> findByEmail(String email);

  @Query(
      value =
          "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM tb_user u WHERE u.email = :email",
      nativeQuery = true)
  boolean existsByEmailIgnoringSoftDelete(@Param("email") String email);

  @Override
  @NonNull @Query(
      value = "SELECT u.id, u.deleted, u.email, u.name, u.password, u.role FROM tb_user u",
      nativeQuery = true)
  Page<User> findAll(@NonNull Pageable pageable);
}
