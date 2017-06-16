package com.mavrk.springmvc.controller;

/**
 * Created by Sanatt on 14-06-2017.
 */
import com.mavrk.springmvc.model.Client;
import com.mavrk.springmvc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ClientRegistrationRestController {

	@Autowired
	private ClientService clientService;

	/**
	 * Retrieve All Users
	 */
	@RequestMapping(value = "/client/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAllUsers() {
		List<Client> clients = clientService.getClients();
		if(clients.isEmpty()){
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	@RequestMapping(value = "/client/", method = RequestMethod.POST)
	public ResponseEntity<Void> createClient(@RequestBody Client client, UriComponentsBuilder uriBuilder){
		System.out.println("Creating user" + client.getName());


		clientService.createClient(client);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/populate/", method = RequestMethod.GET)
	public ResponseEntity<Void> addSampleClients() {
		String[] scopes = {"r","w"};
		String[] grantTypes = {"password", "implicit"};
		Client client1 = new Client("Sample client", "Sample description", "www.samplesite.com",
				"sample client type", "www.redirectionuri.com", scopes, grantTypes);

		clientService.getClients().add(client1);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
