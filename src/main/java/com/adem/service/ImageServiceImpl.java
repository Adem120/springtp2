package com.adem.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.adem.entities.Image;
import com.adem.entities.Machine;
import com.adem.repos.ImageRepository;
import com.adem.repos.MachineReposotiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements Imageservice {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    MachineService machineService;
    @Autowired
    MachineReposotiry machineReposotiry;
    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
 Machine Machine = new Machine();
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes()).
                build() );
    }
    @Override
    public Image getImageDetails(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository. findById (id);
        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build() ;
    }
    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository. findById (id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }
    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
    @Override
    public Image uplaodImageProd(MultipartFile file, Long idProd)
            throws IOException {

        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build() );
    }


}
