package com.example.uad.controller;

import com.example.uad.common.Endpoints;

import com.example.uad.service.impl.Handler;
import org.springframework.core.io.*;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.*;
import software.amazon.awssdk.services.s3.model.*;

import javax.annotation.*;
import java.io.*;


@RestController
public class FileController {

    private final Handler handler;

    public FileController(Handler handler) {
        this.handler = handler;
    }

    @PostMapping(value = Endpoints.File.FILE)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        return handler.sendRequest(multipartFile);
    }

    @GetMapping(value = Endpoints.File.FILE_UUID, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getFileUrl(@PathVariable("uuid") String uuid) throws IOException {
        var result = handler.getFile(uuid);
        return new ResponseEntity<>(new ByteArrayResource(result.readAllBytes()), HttpStatus.OK);
    }
}

