package com.mavrk.springmvc.model;

import java.util.Arrays;

/**
 * Created by Sanatt on 14-06-2017.
 */
public class Client {

	private long id;
	String name;
	String description;
	String website;
	String clientType;
	String redirectionURI;
	String[] scopes;
	String[] grantType;

	public Client(){

	}
	
	public Client(String name, String description, String website, String clientType, String redirectionURI, String[] scopes, String[] grantType) {
		this.name = name;
		this.description = description;
		this.website = website;
		this.clientType = clientType;
		this.redirectionURI = redirectionURI;
		this.scopes = scopes;
		this.grantType = grantType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;

	}

	public String getDescription() {
		return description;
	}

	public String getWebsite() {
		return website;
	}

	public String getClientType() {
		return clientType;
	}

	public String getRedirectionURI() {
		return redirectionURI;
	}

	public String[] getScopes() {
		return scopes;
	}

	public String[] getGrantType() {
		return grantType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public void setRedirectionURI(String redirectionURI) {
		this.redirectionURI = redirectionURI;
	}

	public void setScopes(String[] scopes) {
		this.scopes = scopes;
	}

	public void setGrantType(String[] grantType) {
		this.grantType = grantType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (!name.equals(client.name)) return false;
		if (description != null ? !description.equals(client.description) : client.description != null) return false;
		if (website != null ? !website.equals(client.website) : client.website != null) return false;
		if (!clientType.equals(client.clientType)) return false;
		if (!redirectionURI.equals(client.redirectionURI)) return false;
		// Probably incorrect - comparing Object[] arrays with Arrays.equals
		if (!Arrays.equals(scopes, client.scopes)) return false;
		// Probably incorrect - comparing Object[] arrays with Arrays.equals
		return Arrays.equals(grantType, client.grantType);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (website != null ? website.hashCode() : 0);
		result = 31 * result + clientType.hashCode();
		result = 31 * result + redirectionURI.hashCode();
		result = 31 * result + Arrays.hashCode(scopes);
		result = 31 * result + Arrays.hashCode(grantType);
		return result;
	}

	@Override
	public String toString() {
		return "Client{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", website='" + website + '\'' +
				", clientType='" + clientType + '\'' +
				", redirectionURI='" + redirectionURI + '\'' +
				", scopes=" + Arrays.toString(scopes) +
				", grantType=" + Arrays.toString(grantType) +
				'}';
	}
}
