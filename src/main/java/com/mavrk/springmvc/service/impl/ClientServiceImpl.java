package com.mavrk.springmvc.service.impl;

import com.mavrk.springmvc.model.Client;
import com.mavrk.springmvc.service.ClientService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Sanatt on 14-06-2017.
 */
@Service("userService")
public class ClientServiceImpl implements ClientService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Client> clients = new ArrayList<>();

	@Override
	public void createClient(Client client) {
		System.out.println("Client created.........");
		System.out.println(client.toString());
		client.setId(counter.incrementAndGet());
		clients.add(client);
	}

	@Override
	public List<Client> getClients() {
		return clients;
	}
}
