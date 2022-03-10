package br.dcc.ufjf.atividades.service;

import java.util.Date;
import java.util.List;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Service;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import br.dcc.ufjf.atividades.model.Document;
import br.dcc.ufjf.atividades.repository.DocumentRepository;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;
 
    // lista todos os Documents
    //@Query("SELECT new Document(d.id, d.name, d.size) FROM Document d ORDER BY d.uploadTime DESC")
    public List<Document> findAllDocuments(){
        return documentRepository.findAll();
    }

    
    public Document saveDocument(@RequestBody  MultipartFile multipartFile) throws IOException{
        Document document = new Document();
        String fileName = StringUtils.cleanPath( multipartFile.getOriginalFilename());
       
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());

        document.setUploadTime(new Date());
       
       
        return documentRepository.save(document);

    }

    // procura um Document a partir do seu id
    public Document get(Long id){
        return documentRepository.findById(id).get();
    }

    // deleta Document a partir do seu id
    public void delete(Long id){ 
        documentRepository.deleteById(id);
    }
    
   
}


    