package br.dcc.ufjf.atividades.controller_service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import br.dcc.ufjf.atividades.exception.FileStorageException;
import br.dcc.ufjf.atividades.model.FileActivities;
import br.dcc.ufjf.atividades.repository.FileActivitiesRepository;



@Service
public class FileActivitiesService {

    @Autowired
    private FileActivitiesRepository fileActivitiesRepository;

    public FileActivities storeFile(MultipartFile file){
        //Normalize file name

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
             // Check if the file's name contains invalid characters
             if(fileName.contains("..")){
                throw new FileStorageException("File name contains invalid path sequence " +fileName);

             }
             FileActivities fileActivities = new FileActivities(fileName, file.getContentType(), file.getBytes());

            return fileActivitiesRepository.save(fileActivities);
        } catch(IOException ex){
            throw new FileStorageException("Could not store file"+fileName+ ". Please try again!",ex);
        }

        
    }

    public FileActivities getFile(String fileId){
        return fileActivitiesRepository.findById(fileId)
        .orElseThrow(() ->  new FileStorageException("Could notFile not found with id " + fileId));
    }
    
}
