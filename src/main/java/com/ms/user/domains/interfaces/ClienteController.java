package com.ms.user.domains.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.domains.Client;
import com.ms.user.repositories.ClientRepository;

@RestController
public class ClienteController {
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@PostMapping("/users")
	public ResponseEntity createNewUser(@RequestBody User user) {
		if(user.getEmail() != null && user.getName() != null && user.getPassword() != null) {
			Client client = new Client();
			client.setName(user.getName());
			client.setEmail(user.getEmail());
			client.setPassword(user.getPassword());
			clientRepository.save(client);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/users")
	public ResponseEntity createNewUser() {
		return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
	}

}
