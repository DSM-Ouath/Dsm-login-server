package com.example.ouath.global.security.jwt;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.global.security.auth.CustomUserDetailsService;
import com.example.ouath.global.security.jwt.exception.ExpiredTokenException;
import com.example.ouath.global.security.jwt.exception.InvalidTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private final UserRepository userRepository;

    private final CustomUserDetailsService customUserDetailsService;

    // access token 생성
//    public String createAccessToken(String xquareId) {
//
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setSubject(xquareId)
//                .claim("type", "access")
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExpiration() * 1000))
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
//                .compact();
//    }
//
//    public String createRefreshToken(String xquareId) {
//
//        Date now = new Date();
//
//        String refreshToken = Jwts.builder()
//                .claim("type", "refresh")
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExpiration() * 1000))
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
//                .compact();
//
//        refreshTokenRepository.save(
//                RefreshToken.builder()
//                        .xquareId(xquareId)
//                        .token(refreshToken)
//                        .timeToLive(jwtProperties.getRefreshExpiration())
//                        .build());
//
//        return refreshToken;
//    }
//
    // 토큰에 담겨있는 userId로 SpringSecurity Authentication 정보를 반환하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
//
//    public LoginResponse receiveToken(String xquareId) {
//
//        Date  now = new Date();
//
//        User user = userRepository.findByXquareId(xquareId)
//                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
//
//        return LoginResponse
//                .builder()
//                .accessToken(createAccessToken(xquareId))
//                .refreshToken(createRefreshToken(xquareId))
//                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
//                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration()))
//                .part(user.getPart())
//                .build();
//    }
//
    // HTTP 요청 헤더에서 토큰을 가져오는 메서드
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }
}