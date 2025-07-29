package com.tamil.cloudimage.controller;

import com.tamil.cloudimage.entity.Data;
import com.tamil.cloudimage.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class DataController {
    @Autowired
    private DataService dataService;

    @CacheEvict(value = "datas",allEntries = true)
    @PostMapping(path = "store", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CompletableFuture<ResponseEntity<Data>> store(@RequestPart("data") Data data, @RequestPart("image") MultipartFile file) {
        CompletableFuture future =dataService.store(data,file);
        return future.thenApply(list->ResponseEntity.status(HttpStatus.CREATED)
                                                           .body(list));
    }
@Cacheable(value = "datas")
@GetMapping("get")
public ResponseEntity<List<Data>> getAllData(){
        return ResponseEntity.status(HttpStatus.OK)
        .body(dataService.getAllData());
}

}