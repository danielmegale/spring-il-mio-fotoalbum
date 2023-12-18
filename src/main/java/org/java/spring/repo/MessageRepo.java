package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.FotoAlbum;
import org.java.spring.pojo.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

    List<FotoAlbum> findByEmailContainingOrMessageContainingIgnoreCase(String email, String message);
}
