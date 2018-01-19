package com.rafaelsm.desafio.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.models.Estado;
import com.rafaelsm.desafio.models.Sexo;

public class ClientData {
	
	
	
	public static Client getRafael() {
		LocalDate date = LocalDate.of(1990, 6, 27);
			
		Client rafael = new Client();
		rafael.setNomeCompleto("Rafael Mendes");
		rafael.setSexo(Sexo.MASCULINO);
		rafael.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		rafael.setEmail("rafael.sm1990@gmail.com");
		rafael.setCpf("090.274.904-81");
		rafael.setRua("Rua Rafael");
		rafael.setNumero(295);
		rafael.setBairro("Bairro Rafael");
		rafael.setCidade("Cidade Rafael");
		rafael.setEstado(Estado.PB);
		rafael.setComplemento("Complemento Rafael");
		return rafael;
	}
	
	public static Client getDaniel() {
		LocalDate date = LocalDate.of(1991, 10, 27);
		
		Client client = new Client();
		client.setNomeCompleto("Daniel Alves");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("daniel@gmail.com");
		client.setCpf("516.213.229-20");
		client.setRua("Rua Daniel");
		client.setNumero(21);
		client.setBairro("Bairro Daniel");
		client.setCidade("Cidade Daniel");
		client.setEstado(Estado.PE);
		client.setComplemento("Complemento Daniel");
		return client;
	}
	
	public static Client getPamella() {
		LocalDate date = LocalDate.of(1997, 5, 20);
		
		Client client = new Client();
		client.setNomeCompleto("Pamella Freitas");
		client.setSexo(Sexo.FEMININO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("pamella@gmail.com");
		client.setCpf("498.643.878-63");
		client.setRua("Rua Pamella");
		client.setNumero(15);
		client.setBairro("Bairro Pamella");
		client.setCidade("Cidade Pamella");
		client.setEstado(Estado.PB);
		client.setComplemento("Complemento Pamella");
		return client;
	}
	
	public static Client getPedro() {
		LocalDate date = LocalDate.of(1989, 2, 10);
		
		Client client = new Client();
		client.setNomeCompleto("Pedro Alves");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("pedro@gmail.com");
		client.setCpf("339.108.313-11");
		client.setRua("Rua Pedro");
		client.setNumero(80);
		client.setBairro("Bairro Pedro");
		client.setCidade("Cidade Pedro");
		client.setEstado(Estado.SE);
		client.setComplemento("Complemento Pedro");
		return client;
	}
	
	public static Client getCamila() {
		LocalDate date = LocalDate.of(1995, 8, 18);
		
		Client client = new Client();
		client.setNomeCompleto("Camila Nascimento");
		client.setSexo(Sexo.FEMININO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("camila@gmail.com");
		client.setCpf("769.470.825-52");
		client.setRua("Rua Camila");
		client.setNumero(73);
		client.setBairro("Bairro Camila");
		client.setCidade("Cidade Camila");
		client.setEstado(Estado.SE);
		client.setComplemento("Complemento Camila");
		return client;
	}
	
	public static Client getNewUser() {
		LocalDate date = LocalDate.of(1991, 10, 26);
		
		Client client = new Client();
		client.setNomeCompleto("New User");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("newuser@gmail.com");
		client.setCpf("734.654.198-71");
		client.setRua("Rua New User");
		client.setNumero(21);
		client.setBairro("Bairro New User");
		client.setCidade("Cidade New User");
		client.setEstado(Estado.PE);
		client.setComplemento("Complemento New User");
		return client;
	}
	
	public static Client getNewUserSaved() {
		LocalDate date = LocalDate.of(1991, 10, 26);
		
		Client client = new Client();
		client.setId(1L);
		client.setNomeCompleto("New User");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("newuser@gmail.com");
		client.setCpf("734.654.198-71");
		client.setRua("Rua New User");
		client.setNumero(21);
		client.setBairro("Bairro New User");
		client.setCidade("Cidade New User");
		client.setEstado(Estado.PE);
		client.setComplemento("Complemento New User");
		return client;
	}
	
	public static List<Client> all() {
		return Arrays.asList(getRafael(), getPamella(), getDaniel(), getCamila(), getPedro());
	}

}