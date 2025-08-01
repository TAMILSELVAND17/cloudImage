package com.tamil.cloudimage.tool;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
@AllArgsConstructor
public class CloudinaryHelper {
    @Qualifier("cloudinary")
    private final Cloudinary cloudinary;
    public String uploadImage(MultipartFile file)throws IOException {
        Map<?,?> uploadResult=cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        return uploadResult.get("secure_url").toString();
    }

}
