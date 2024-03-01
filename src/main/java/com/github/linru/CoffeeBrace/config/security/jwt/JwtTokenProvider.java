//package com.github.linru.CoffeeBrace.config.security.jwt;
//
//import com.github.linru.CoffeeBrace.entities.Role;
//import io.jsonwebtoken.*;
//import jakarta.annotation.PostConstruct;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class JwtTokenProvider {
//
//    @Value("${jwt.token.secret}")
//    private String secret;
//    @Value("${jwt.token.expired}")
//    private long validityInMilliseconds;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @PostConstruct
//    protected void init() {
//        secret = Base64.getEncoder().encodeToString(secret.getBytes());
//    }
//
//    public String createToken(String username, List<Role> roles) {
//        Claims claims = (Claims) Jwts.claims().setSubject(username);
//
//        claims.put("roles", getRoleNames(roles));
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserName(token));
//        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
//
//    }
//
//    public String getUserName(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody.getSubject();
//
//    }
//public String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken!= null && bearerToken.startsWith("Bearer_")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//}
//
//    public boolean validateToken(String token) {
//        try {
//            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret.parseClaimJws(token);
//            return !claimsJws.getBody().getExpiration().before(new Date());
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new JwtAuthenticationException("JWT token is expired or invalid")
//        }
//    }
//
//    private List<String> getRoleNames (List<Role> userRoles) {
//        List<String> result = new ArrayList<>();
//        userRoles.forEach(role -> result.add(role.getName()));
//        return result;
//    }
//
//
//}
