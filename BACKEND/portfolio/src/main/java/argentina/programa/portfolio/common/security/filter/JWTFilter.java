package argentina.programa.portfolio.common.security.filter;

import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.common.exception.ForbiddenException;
import argentina.programa.portfolio.common.security.service.Impl.UserDetailsServiceImpl;
import argentina.programa.portfolio.common.security.service.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JWTUtils jwtUtil;

    private static final String BEARER = "Bearer ";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        try {
            String email = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {

                jwt = authorizationHeader.substring(7);
                email = jwtUtil.extractUsername(jwt);

            }

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);

                if (jwtUtil.validateToken(jwt, userDetails)) {

                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                            userDetails, userDetails.getPassword(), Collections.emptyList());

                    authRequest.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authRequest);
                }
            }
        }
        catch(Exception e) {
            throw new ForbiddenException(Errors.INVALIDUSER);
        }
        filterChain.doFilter(request, response);
    }
}