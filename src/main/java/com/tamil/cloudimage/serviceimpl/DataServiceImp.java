package com.tamil.cloudimage.serviceimpl;

import com.tamil.cloudimage.entity.Data;
import com.tamil.cloudimage.repository.DataJPA;
import com.tamil.cloudimage.service.DataService;
import com.tamil.cloudimage.tool.CloudinaryHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DataServiceImp implements DataService {

    @Autowired
    private DataJPA dataJPA;

    @Autowired
    private CloudinaryHelper cloudinaryHelper;


    @Override
    public CompletableFuture<Data> store(Data data, MultipartFile file){
        String imageUrl= null;
        try {
            imageUrl = cloudinaryHelper.uploadImage(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        data.setDataImage(imageUrl);
        Data saved=dataJPA.save(data);
        return CompletableFuture.completedFuture(saved);
    }

    @Override
    public List<Data> getAllData() {
         return dataJPA.findAll();

    }
}
