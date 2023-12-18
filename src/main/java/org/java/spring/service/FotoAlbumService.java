package org.java.spring.service;

import java.util.List;

import org.java.spring.pojo.FotoAlbum;
import org.java.spring.repo.FotoAlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoAlbumService {

	@Autowired
	private FotoAlbumRepo fotoAlbumRepo;
	
	public List<FotoAlbum> findAll(){
		return fotoAlbumRepo.findAll();
	}
	
	public FotoAlbum findById(int id) {
		return fotoAlbumRepo.findById(id).get();
	}
	
	public List<FotoAlbum> findByTitle(String query){
		
		return fotoAlbumRepo.findByTitoloContaining(query);
	}
	
	public void save(FotoAlbum fotoAlbum) {
		fotoAlbumRepo.save(fotoAlbum);
	}
	
	public void delete(FotoAlbum fotoAlbum) {
		fotoAlbumRepo.delete(fotoAlbum);
	}
}
