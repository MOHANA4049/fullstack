package com.jobapp.mona.config;


import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jobapp.mona.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
//We have to add unimplemented methods
public class JwtAuthenticationConfig extends OncePerRequestFilter{
    // private final UserDetailsService userDetailsService;
    // private final JwtUtil jwtUtil;
    // @Override
    // protected void doFilterInternal(
    //     @NonNull HttpServletRequest request, 
    //     @NonNull HttpServletResponse response,
    //     @NonNull FilterChain filterChain)
    //         throws ServletException, IOException {
    //             //HttpHeaders.AUTHORIZATION
    //      final String authHeader=request.getHeader(AUTHORIZATION);//it will not be changed so final keyword
    //      final String token;
    //      final String username;
    //      //There is no authHeader or Header does not starts with Bearer it returns nothing.
    //      if(authHeader==null|| !authHeader.startsWith("Bearer"))
    //      {
    //         filterChain.doFilter(request,response);
    //         //request and response shared to next configuration
    //         return;
    //      }
    //      token=authHeader.substring(7);
    //      username=jwtUtil.extractUsername(token);
    //      //checking the user is authenticated or not
    //      //checking only one time whether the user is authenticated or not
    //      //saving the data in security contextholder
    //      //i dont want to check authentication part again and again for the same user
    //      //username should not be nullvalue && 
    //      if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
    //         UserDetails userDetails= this.userDetailsService.loadUserByUsername(username);
    //         //To check whether the token is valid or not
    //         if(jwtUtil.isTokenValid(token,userDetails))
    //         {
    //             UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    //             authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    //             SecurityContextHolder.getContext().setAuthentication(authToken);
    //         }
    //         //request sent to next config
    //         filterChain.doFilter(request,response);
    //         //if this is not given,response and request wont send to next configuration,application will be crashed.

    //      }
        
    // }
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailService;
    @Override
    protected void doFilterInternal(
      @NonNull HttpServletRequest request, 
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {
  
        String authHeader= request.getHeader(AUTHORIZATION);
        String token;
        String username;
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
          filterChain.doFilter(request, response);
          return;
        }
        token = authHeader.substring(7);
        username=jwtUtil.extractUsername(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){
          UserDetails userDetails= this.userDetailService.loadUserByUsername(username);
          if(jwtUtil.isTokenValid(token, userDetails)) {
            UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
          }
          filterChain.doFilter(request, response);
        }
      }
}
