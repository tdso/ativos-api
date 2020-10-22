package com.tdso.ativosapi;

import java.time.LocalDate;
import java.util.Arrays;

import com.tdso.ativosapi.entity.Negociacao;
import com.tdso.ativosapi.repository.NegociacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtivosApiApplication implements CommandLineRunner {

	@Autowired
	NegociacaoRepository negRepo; 
	public static void main(String[] args) {
		SpringApplication.run(AtivosApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Negociacao neg1 = new Negociacao("TAEE11", LocalDate.now(), 100, 99.01, 1);
		Negociacao neg2 = new Negociacao("HGRU11", LocalDate.parse("2020-10-10"), 200, 199.01, 1);
		Negociacao neg3 = new Negociacao("VIVT4", LocalDate.now(), 700, 45.05, 1);
		Negociacao neg4 = new Negociacao("ALUP11", LocalDate.now(), 4100, 85.05, 2);
		Negociacao neg5 = new Negociacao("HGRU11", LocalDate.parse("2020-10-20"), 10, 80.21, 1);
		Negociacao neg6 = new Negociacao("ALUP11", LocalDate.now(), 1700, 89.0, 2);
		Negociacao neg7 = new Negociacao("HGRU11", LocalDate.parse("2020-09-20"), 20, 80.51, 1);
		Negociacao neg8 = new Negociacao("HGRU11", LocalDate.parse("2020-12-10"), 300, 99.0, 1);
		Negociacao neg9 = new Negociacao("HGRU11", LocalDate.parse("2019-01-10"), 51, 145.21, 1);

		negRepo.saveAll(Arrays.asList(neg1, neg2, neg3, neg4, neg5, neg6, neg7, neg8, neg9 ));
		

	}

}
