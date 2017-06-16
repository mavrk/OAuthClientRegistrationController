package com.mavrk.springmvc.service;

import com.mavrk.springmvc.model.Client;

import java.util.List;

/**
 * Created by Sanatt on 14-06-2017.
 */
public interface ClientService {

	void createClient(Client client);

	List<Client> getClients();

}
