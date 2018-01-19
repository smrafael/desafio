package com.rafaelsm.desafio.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.rafaelsm.desafio.models.Client;
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
		rafael.setAddress(AddressData.getRafael());
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
		client.setAddress(AddressData.getDaniel());
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
		client.setAddress(AddressData.getPamella());
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
		client.setAddress(AddressData.getPedro());
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
		client.setAddress(AddressData.getCamila());
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
		client.setAddress(AddressData.getNewUser());
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
		client.setAddress(AddressData.getNewUserSaved());
		return client;
	}
	
	public static List<Client> all() {
		return Arrays.asList(getRafael(), getPamella(), getDaniel(), getCamila(), getPedro());
	}

}