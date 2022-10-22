package com.evoting.authservice.Controllers;

import com.evoting.authservice.Config.JwtTokenUtil;
import com.evoting.authservice.Models.JwtRequest;
import com.evoting.authservice.Models.JwtResponse;
import org.apache.tomcat.util.http.parser.Authorization;
import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping({ "/ValidateJwt" })
	public String hello(@RequestHeader String authorization) {
		// Automatic filter knows if the token in the Header with form "Bearer token" is valid or not
		String jwt = authorization.substring(7);
		return jwtTokenUtil.getUsernameFromToken(jwt);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		//TO DO : send to the user service request to search user by cin and password
		System.out.println(authenticationRequest.getCin());
		System.out.println(passwordEncoder.encode(authenticationRequest.getPassword()));

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getCin());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@GetMapping(value = "/getCin/{jwt}")
	public ResponseEntity<?> valdiateJwt(@PathVariable("jwt")String jwt) throws Exception {
			return new ResponseEntity<>(jwtTokenUtil.getUsernameFromToken(jwt),HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
