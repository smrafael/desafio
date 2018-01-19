package com.rafaelsm.desafio.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.rafaelsm.desafio.models.Address;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.models.Estado;
import com.rafaelsm.desafio.models.Sexo;

public class AddressData {
	
	public static Address getRafael() {
		Address address = new Address();
		address.setRua("Rua Rafael");
		address.setNumero(295);
		address.setBairro("Bairro Rafael");
		address.setCidade("Cidade Rafael");
		address.setEstado(Estado.PB);
		address.setComplemento("Complemento Rafael");
		return address;
	}
	
	public static Address getDaniel() {
		Address address = new Address();
		address.setRua("Rua Daniel");
		address.setNumero(21);
		address.setBairro("Bairro Daniel");
		address.setCidade("Cidade Daniel");
		address.setEstado(Estado.PE);
		address.setComplemento("Complemento Daniel");
		return address;
	}
	
	public static Address getPamella() {
		Address address = new Address();
		address.setRua("Rua Pamella");
		address.setNumero(15);
		address.setBairro("Bairro Pamella");
		address.setCidade("Cidade Pamella");
		address.setEstado(Estado.PB);
		address.setComplemento("Complemento Pamella");
		return address;
	}
	
	public static Address getPedro() {
		Address address = new Address();
		address.setRua("Rua Pedro");
		address.setNumero(80);
		address.setBairro("Bairro Pedro");
		address.setCidade("Cidade Pedro");
		address.setEstado(Estado.SE);
		address.setComplemento("Complemento Pedro");
		return address;
	}
	
	public static Address getCamila() {
		Address address = new Address();
		address.setRua("Rua Camila");
		address.setNumero(73);
		address.setBairro("Bairro Camila");
		address.setCidade("Cidade Camila");
		address.setEstado(Estado.SE);
		address.setComplemento("Complemento Camila");
		return address;
	}
	
	public static Address getNewUser() {
		Address address = new Address();
		address.setRua("Rua New User");
		address.setNumero(21);
		address.setBairro("Bairro New User");
		address.setCidade("Cidade New User");
		address.setEstado(Estado.PE);
		address.setComplemento("Complemento New User");
		return address;
	}
	
	public static Address getNewUserSaved() {
		Address adress = new Address();
		adress.setRua("Rua New User");
		adress.setNumero(21);
		adress.setBairro("Bairro New User");
		adress.setCidade("Cidade New User");
		adress.setEstado(Estado.PE);
		adress.setComplemento("Complemento New User");
		return adress;
	}
}
