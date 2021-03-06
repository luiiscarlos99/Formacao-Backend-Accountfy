package com.accountfy.livros.config;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.accountfy.livros.entities.Livro;
import com.accountfy.livros.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private LivroRepository repository;

	@Override
	public void run(String... args) throws Exception {

		Livro l1 = new Livro("Sociedade da caveira de cristal", 356, sdf.parse("12/02/1999"), new BigDecimal(50.00));
		Livro l2 = new Livro("Diario de Anne Frank", 560, sdf.parse("17/03/1999"), new BigDecimal(50.00));
		Livro l3 = new Livro("teste", 560, sdf.parse("09/02/1999"), new BigDecimal(99.00));
		Livro l4 = new Livro("teste", 123, sdf.parse("22/03/1999"), new BigDecimal(99.00));

		repository.saveAll(Arrays.asList(l1, l2, l3, l4));
	}

//	{
//	    "titulo": "O Cortico",
//	    "numeroDePaginas": "567",
//	    "publicadoEm": "2022-01-26",
//	    "precoDeVenda": "30.00"
//	}

//	{
//    "ano": "1999",
//    "mes": "02"
//	}

//	[
//	    {
//	        "ano": "1999",
//	        "mes": "02"
//	    },
//	    {
//	        "ano": "1999",
//	        "mes": "03"
//	    }
//	]
}
