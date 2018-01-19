package com.rafaelsm.desafio.data;

import java.util.Arrays;
import java.util.List;

import com.rafaelsm.desafio.models.Cliente;

public class ClientData {
	
	public static Cliente getRafael() {
		Cliente rafael = new Cliente();
		rafael.setRazaoSocial("Rafael Mendes");
		rafael.setNomeFantasia("Nome Legal");
		rafael.setEmail("rafael.sm1990@gmail.com");
		rafael.setCnpj("37.887.569/0001-20");
		rafael.setEndereco(AddressData.getRafael());
		return rafael;
	}
	
	public static Cliente getDaniel() {
		Cliente client = new Cliente();
		client.setRazaoSocial("Daniel Alves");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("daniel@gmail.com");
		client.setCnpj("52.794.157/0001-30");
		client.setEndereco(AddressData.getDaniel());
		return client;
	}
	
	public static Cliente getPamella() {
		Cliente client = new Cliente();
		client.setRazaoSocial("Pamella Freitas");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("pamella@gmail.com");
		client.setCnpj("26.330.357/0001-21");
		client.setEndereco(AddressData.getPamella());
		return client;
	}
	
	public static Cliente getPedro() {
		Cliente client = new Cliente();
		client.setRazaoSocial("Pedro Alves");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("pedro@gmail.com");
		client.setCnpj("38.494.793/0001-15");
		client.setEndereco(AddressData.getPedro());
		return client;
	}
	
	public static Cliente getCamila() {
		Cliente client = new Cliente();
		client.setRazaoSocial("Camila Nascimento");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("camila@gmail.com");
		client.setCnpj("97.219.539/0001-78");
		client.setEndereco(AddressData.getCamila());
		return client;
	}
	
	public static Cliente getNewUser() {
		Cliente client = new Cliente();
		client.setRazaoSocial("New User");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("newuser@gmail.com");
		client.setCnpj("58.922.552/0001-37");
		client.setEndereco(AddressData.getNewUser());
		return client;
	}
	
	public static Cliente getNewUserSaved() {
		Cliente client = new Cliente();
		client.setId(1L);
		client.setRazaoSocial("New User");
		client.setNomeFantasia("Nome Legal");
		client.setEmail("newuser@gmail.com");
		client.setCnpj("82.414.365/0001-27");
		client.setEndereco(AddressData.getNewUserSaved());
		return client;
	}
	
	public static List<Cliente> all() {
		return Arrays.asList(getRafael(), getPamella(), getDaniel(), getCamila(), getPedro());
	}

}