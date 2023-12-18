package org.java.spring.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable= false)
	private String nome;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<FotoAlbum> photos;
	
	public Category() {}
	public Category(String nome) {
		setNome(nome);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<FotoAlbum> getPhotos() {
		return photos;
	}
	public void setPhotos(List<FotoAlbum> photos) {
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "]" + getNome();
	}
	
}
