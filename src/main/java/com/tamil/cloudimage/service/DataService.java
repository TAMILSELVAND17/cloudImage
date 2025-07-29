package com.tamil.cloudimage.service;

import com.tamil.cloudimage.entity.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DataService {
    CompletableFuture<Data> store(Data data, MultipartFile file);
    List<Data> getAllData();
}
