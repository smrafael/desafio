package com.rafaelsm.desafio.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.rafaelsm.desafio.models.Cliente;
import com.rafaelsm.desafio.models.Sexo;

public class ClientData {
	
	public static Cliente getRafael() {
		LocalDate date = LocalDate.of(1990, 6, 27);
			
		Cliente rafael = new Cliente();
		rafael.setNomeCompleto("Rafael Mendes");
		rafael.setSexo(Sexo.MASCULINO);
		rafael.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		rafael.setEmail("rafael.sm1990@gmail.com");
		rafael.setCpf("090.274.904-81");
		rafael.setEndereco(AddressData.getRafael());
		return rafael;
	}
	
	public static Cliente getDaniel() {
		LocalDate date = LocalDate.of(1991, 10, 27);
		
		Cliente client = new Cliente();
		client.setNomeCompleto("Daniel Alves");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("daniel@gmail.com");
		client.setCpf("516.213.229-20");
		client.setEndereco(AddressData.getDaniel());
		return client;
	}
	
	public static Cliente getPamella() {
		LocalDate date = LocalDate.of(1997, 5, 20);
		
		Cliente client = new Cliente();
		client.setNomeCompleto("Pamella Freitas");
		client.setSexo(Sexo.FEMININO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("pamella@gmail.com");
		client.setCpf("498.643.878-63");
		client.setEndereco(AddressData.getPamella());
		return client;
	}
	
	public static Cliente getPedro() {
		LocalDate date = LocalDate.of(1989, 2, 10);
		
		Cliente client = new Cliente();
		client.setNomeCompleto("Pedro Alves");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("pedro@gmail.com");
		client.setCpf("339.108.313-11");
		client.setEndereco(AddressData.getPedro());
		return client;
	}
	
	public static Cliente getCamila() {
		LocalDate date = LocalDate.of(1995, 8, 18);
		
		Cliente client = new Cliente();
		client.setNomeCompleto("Camila Nascimento");
		client.setSexo(Sexo.FEMININO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("camila@gmail.com");
		client.setCpf("769.470.825-52");
		client.setEndereco(AddressData.getCamila());
		return client;
	}
	
	public static Cliente getNewUser() {
		LocalDate date = LocalDate.of(1991, 10, 26);
		
		Cliente client = new Cliente();
		client.setNomeCompleto("New User");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("newuser@gmail.com");
		client.setCpf("734.654.198-71");
		client.setEndereco(AddressData.getNewUser());
		return client;
	}
	
	public static Cliente getNewUserSaved() {
		LocalDate date = LocalDate.of(1991, 10, 26);
		
		Cliente client = new Cliente();
		client.setId(1L);
		client.setNomeCompleto("New User");
		client.setSexo(Sexo.MASCULINO);
		client.setDataNascimento(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		client.setEmail("newuser@gmail.com");
		client.setCpf("734.654.198-71");
		client.setEndereco(AddressData.getNewUserSaved());
		return client;
	}
	
	public static List<Cliente> all() {
		return Arrays.asList(getRafael(), getPamella(), getDaniel(), getCamila(), getPedro());
	}

}