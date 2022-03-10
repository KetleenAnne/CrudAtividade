package br.dcc.ufjf.atividades.atividades;
import java.io.*;
import java.nio.file.Files;
import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.annotation.*;

import br.dcc.ufjf.atividades.model.Document;
import br.dcc.ufjf.atividades.repository.DocumentRepository;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AtividadesApplicationTests {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private TestEntityManager entityManager;
	@Test
	@Rollback(false)
	void contextLoads() throws IOException {
		File file = new File("C:\\Users\\ketle\\Documents\\CamScanner 11-24-2020 14.25.pdf");
		
		Document document = new Document();
		document.setName(file.getName());
		
		byte[] bytes = Files.readAllBytes(file.toPath());
		document.setContent(bytes);
		long fileSize = bytes.length;
		document.setSize(fileSize);
		document.setUploadTime(new Date());

		
		Document saveDoc = documentRepository.save(document);

		Document existDoc = entityManager.find(Document.class,saveDoc.getId() );

		assertThat(existDoc.getSize()).isEqualTo(fileSize);
	}
	

}
