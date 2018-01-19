package com.rafaelsm.desafio.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rafaelsm.desafio.data.ClientData;
import com.rafaelsm.desafio.models.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository repository;
	
	@Before
	public void init() {
		repository.save(ClientData.getRafael());
		repository.save(ClientData.getPamella());
		repository.save(ClientData.getPedro());
		repository.save(ClientData.getCamila());
		repository.save(ClientData.getDaniel());
	}
	
	@Test
	public void whenFindByEmail_thenReturnClient() {
		Cliente pamella = ClientData.getPamella();
		Cliente clientDB = repository.findOneByEmail(pamella.getEmail());
		
		assertThat(clientDB.getNomeCompleto()).isEqualTo(pamella.getNomeCompleto());
		assertThat(clientDB.getCpf()).isEqualTo(pamella.getCpf());
	}
	
	@Test
	public void whenFindByCpf_thenReturnClient() {
		Cliente pamella = ClientData.getPamella();
		Cliente clientDB = repository.findOneByCpf(pamella.getCpf());
		
		assertThat(clientDB.getNomeCompleto()).isEqualTo(pamella.getNomeCompleto());
		assertThat(clientDB.getCpf()).isEqualTo(pamella.getCpf());
	}
	
	@Test
	public void whenFindByEmail_thenReturnNoneClient() {
		Cliente clientDB = repository.findOneByEmail("email_inexistente@gmail.com");
		assertThat(clientDB).isNull();
	}
	
	@Test
	public void whenFindByCpf_thenReturnNoneClient() {
		Cliente clientDB = repository.findOneByCpf("166.238.561-70");
		assertThat(clientDB).isNull();
	}

}
 