package com.jwt.spring.springjwt.controllers;


import com.jwt.spring.springjwt.datamodels.AuthRequestBody;
import com.jwt.spring.springjwt.datamodels.AuthResponse;
import com.jwt.spring.springjwt.datamodels.ErrorResponse;
import com.jwt.spring.springjwt.services.UserAuthService;
import com.jwt.spring.springjwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;


    //The basic authenthication from the usr.
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> getJwtToken(@RequestBody AuthRequestBody authRequestBody) throws Exception{
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequestBody.getUsername(), authRequestBody.getPassword()));
        }catch(BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestBody.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt,"Token","GEETU"));
    }
    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello");
    }

   /* @RequestMapping(value = "/authtoken", method = RequestMethod.POST)
    public ResponseEntity<?> createJWT(@RequestBody AuthRequestBody authRequest) throws Exception{
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch(BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }*/

}
