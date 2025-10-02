package com.bardan.mydog24crm.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor // Lombok will create the constructor for final fields
public class FirebaseAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseAuthenticationFilter.class);
    private final SecurityProperties securityProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            String email = decodedToken.getEmail();

            // Authorization check: Is the email in our allowed list?
            if (email == null || !securityProperties.getAllowedEmails().contains(email)) {
                logger.warn("Unauthorized access attempt by email: {}", email);
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.getWriter().write("Access Denied: Email not authorized.");
                return; // Stop the filter chain
            }

            String uid = decodedToken.getUid();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(uid, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            logger.debug("Successfully authenticated and authorized user with UID: {} and email: {}", uid, email);

        } catch (Exception e) {
            logger.warn("Failed to authenticate Firebase token: {}", e.getMessage());
            SecurityContextHolder.clearContext();
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Authentication Failed: Invalid token.");
            return; // Stop the filter chain
        }

        filterChain.doFilter(request, response);
    }
}
