package com.template.infra.security;

import com.template.user.helpers.UserMessages;
import com.template.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
  private final TokenService tokenService;
  private final UserRepository userRepository;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest req,
      @NonNull HttpServletResponse res,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {

    String token = recoverToken(req);

    if (token != null) {
      var email = tokenService.validateToken(token);

      UserDetails user =
          userRepository
              .findByEmail(email)
              .orElseThrow(() -> new RuntimeException(UserMessages.USER_NOT_FOUND));

      var authentication =
          new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(req, res);
  }

  private String recoverToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");

    if (authHeader == null) return null;

    return authHeader.substring(7);
  }
}
