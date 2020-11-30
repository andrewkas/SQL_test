package com.noirix.security.controller;

import com.noirix.security.model.AuthRequest;
import com.noirix.security.model.AuthResponse;
import com.noirix.security.util.TokenUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentificate")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userProvider;
    private final TokenUtils tokenUtils;

@PostMapping
 public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest request) {

    Authentication authentication=authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getLogin(),
                    request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    return ResponseEntity.ok(
            AuthResponse
                    .builder()
                    .name(request.getLogin())
                    .token(tokenUtils.generateToken(userProvider.loadUserByUsername(request.getLogin())))
                    .build()
    );
 }
}
