package com.rafaelsm.desafio.data;

import com.rafaelsm.desafio.models.Endereco;
import com.rafaelsm.desafio.models.Estado;

public class AddressData {
	
	public static Endereco getRafael() {
		Endereco address = new Endereco();
		address.setRua("Rua Rafael");
		address.setNumero(295);
		address.setBairro("Bairro Rafael");
		address.setCidade("Cidade Rafael");
		address.setEstado(Estado.PB);
		address.setComplemento("Complemento Rafael");
		return address;
	}
	
	public static Endereco getDaniel() {
		Endereco address = new Endereco();
		address.setRua("Rua Daniel");
		address.setNumero(21);
		address.setBairro("Bairro Daniel");
		address.setCidade("Cidade Daniel");
		address.setEstado(Estado.PE);
		address.setComplemento("Complemento Daniel");
		return address;
	}
	
	public static Endereco getPamella() {
		Endereco address = new Endereco();
		address.setRua("Rua Pamella");
		address.setNumero(15);
		address.setBairro("Bairro Pamella");
		address.setCidade("Cidade Pamella");
		address.setEstado(Estado.PB);
		address.setComplemento("Complemento Pamella");
		return address;
	}
	
	public static Endereco getPedro() {
		Endereco address = new Endereco();
		address.setRua("Rua Pedro");
		address.setNumero(80);
		address.setBairro("Bairro Pedro");
		address.setCidade("Cidade Pedro");
		address.setEstado(Estado.SE);
		address.setComplemento("Complemento Pedro");
		return address;
	}
	
	public static Endereco getCamila() {
		Endereco address = new Endereco();
		address.setRua("Rua Camila");
		address.setNumero(73);
		address.setBairro("Bairro Camila");
		address.setCidade("Cidade Camila");
		address.setEstado(Estado.SE);
		address.setComplemento("Complemento Camila");
		return address;
	}
	
	public static Endereco getNewUser() {
		Endereco address = new Endereco();
		address.setRua("Rua New User");
		address.setNumero(21);
		address.setBairro("Bairro New User");
		address.setCidade("Cidade New User");
		address.setEstado(Estado.PE);
		address.setComplemento("Complemento New User");
		return address;
	}
	
	public static Endereco getNewUserSaved() {
		Endereco adress = new Endereco();
		adress.setId(1L);
		adress.setRua("Rua New User");
		adress.setNumero(21);
		adress.setBairro("Bairro New User");
		adress.setCidade("Cidade New User");
		adress.setEstado(Estado.PE);
		adress.setComplemento("Complemento New User");
		return adress;
	}
}
