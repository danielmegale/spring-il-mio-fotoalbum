package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.FotoAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoAlbumRepo extends JpaRepository<FotoAlbum, Integer> {

	List<FotoAlbum> findByTitoloContaining(String query);
}
