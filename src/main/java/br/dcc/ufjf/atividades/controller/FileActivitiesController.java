package br.dcc.ufjf.atividades.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import br.dcc.ufjf.atividades.controller_service.FileActivitiesService;
import br.dcc.ufjf.atividades.model.FileActivities;
import br.dcc.ufjf.atividades.model.Response;

@Controller
public class FileActivitiesController {

    @Autowired
    private FileActivitiesService fileActivitiesService;


    /*
    * UPLOAD FILE
    */

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        FileActivities fileName = fileActivitiesService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

       
        return new Response(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(file))
            .collect(Collectors.toList());
    }

    /*
    * UPLOAD FILE
    */


    
    /*
    * DOWNLOAD FILE
    */

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity< Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        FileActivities fileActivities = fileActivitiesService.getFile(fileName);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileActivities.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + fileActivities.getFileName() + "\" ")
        .body(new ByteArrayResource(fileActivities.getData()));
        
    }

    /*
    * DOWNLOAD FILE
    */
}
