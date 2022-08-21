package app_mini_crm.minicrm.security;

import app_mini_crm.minicrm.service.AuthService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


public class JwtTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    AuthService authService;

    @Value("${app.jwtSecretKey}")
    private String kalituzingizBratan;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String tokenxon = request.getHeader("Authorization");
            if (tokenxon != null) {
                if (tokenxon.substring(0, 6).equals("Bearer")) {
                    tokenxon = tokenxon.substring(7);
                    if (tokenValidmi(tokenxon)) {
                        String userId = getUserIdTokenningIchidan(tokenxon);
                        UserDetails userDetails = authService.getUserById(UUID.fromString(userId));
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Could not set user authentication in security context", e);
        }
        filterChain.doFilter(request, response);
    }


    public boolean tokenValidmi(String tokenjon) {
        try {
            Jwts.parser()
                    .setSigningKey(kalituzingizBratan)
                    .parseClaimsJws(tokenjon);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }


    public String getUserIdTokenningIchidan(String token) {
        return Jwts.parser()
                .setSigningKey(kalituzingizBratan)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
