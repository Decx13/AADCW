package lk.ijse.gdse63.travelcw.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse63.travelcw.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final ObjectMapper mapper;
    private UserService service;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, ObjectMapper mapper, UserService service) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
        this.service = service;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String, Object> errorDetails = new HashMap<>();
        System.out.println("Filtering internal start");
        try {
            String accessToken = jwtUtil.resolveToken(request);
            System.out.println("token : "+accessToken);
            if (accessToken == null ) {
                filterChain.doFilter(request, response);
                return;
            }
            System.out.println("token : "+accessToken);
            Claims claims = jwtUtil.resolveClaims(request);

            if(claims != null & jwtUtil.validateClaims(claims)){
                Integer userId = (Integer) claims.get("userId");
                String email = claims.getSubject();
                ArrayList<String> o = (ArrayList<String>) claims.get("roles");
                boolean admin = o.contains("User_Admin");
                boolean u = o.contains("user");

                if (u){
                    String[] split = request.getServletPath().split("/");
                    String id = split[4];
                    System.out.println(split.length-1);
                    System.out.println(id);
                    if (userId!= Integer.parseInt(id)){
                        throw new AccessDeniedException("Access Denied");
                    }
                }

                if (admin || u) {
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(email,"",new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            errorDetails.put("message", "Authentication Error");
            errorDetails.put("details",e.getMessage());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            mapper.writeValue(response.getWriter(), errorDetails);

        }
        filterChain.doFilter(request, response);
    }
}