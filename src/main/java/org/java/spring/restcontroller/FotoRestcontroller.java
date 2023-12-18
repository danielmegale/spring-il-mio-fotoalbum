package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.pojo.FotoAlbum;
import org.java.spring.service.FotoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/photos")
public class FotoRestcontroller {

    @Autowired
    private FotoAlbumService fotoAlbumService;

    @GetMapping
    public ResponseEntity<List<FotoAlbum>> getIndex() {
        List<FotoAlbum> photos = fotoAlbumService.findAll();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<FotoAlbum> getFoto(@PathVariable int id) {
        FotoAlbum foto = fotoAlbumService.findById(id);
        if (foto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

}
