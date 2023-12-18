package org.java.spring.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class FotoAlbum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@Length(min = 3, max = 60, message = "Il Titolo della foto deve avere un Minimo di 3 caratteri ad un Massimo di 60")
	private String titolo;
	@Column(nullable = false)
	@Length(min = 3, max = 140, message = "La descrizione della foto deve avere un Minimo di 3 caratteri ad un Massimo di 140")
	private String descrizione;
	@Column(nullable = false)
	private String url = "";
	@Column(nullable = false)
	private Boolean visibile;

	@ManyToMany
	private List<Category> categories;

	public FotoAlbum() {
	}

	public FotoAlbum(String titolo, String descrizione, String url, Boolean visibile,Category... categories) {
		setTitolo(titolo);
		setDescrizione(descrizione);
		setUrl(url);
		setVisibile(visibile);
		setCategories(categories);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getVisibile() {
		return visibile;
	}

	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@JsonIgnore
	public void setCategories(Category... categories) {
		setCategories(Arrays.asList(categories));
	}

	public void clear() {
		getCategories().clear();
	}

	@Override
	public String toString() {

		return "[" + getId() + "]" + getTitolo() + " - " + getDescrizione() + " - " + getUrl();
	}

}