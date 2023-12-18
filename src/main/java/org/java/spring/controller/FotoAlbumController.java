package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.Category;
import org.java.spring.pojo.FotoAlbum;
import org.java.spring.pojo.Message;
import org.java.spring.service.CategoryService;
import org.java.spring.service.FotoAlbumService;
import org.java.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class FotoAlbumController {

	@Autowired
	private FotoAlbumService fotoAlbumService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MessageService messageService;

	@GetMapping("/")
	public String searchFoto(Model model, @RequestParam(required = false) String q) {
		List<FotoAlbum> photos = q == null ? fotoAlbumService.findAll() : fotoAlbumService.findByTitle(q);
		model.addAttribute("photos", photos);
		model.addAttribute("q", q == null ? "" : q);
		return "foto-album";
	}

	@GetMapping("/photos/{id}")
	public String getFotoId(Model model, @PathVariable int id) {
		FotoAlbum fotoId = fotoAlbumService.findById(id);
		model.addAttribute("foto", fotoId);
		return "foto-detail";
	}

	@GetMapping("/photos/create")
	public String createFoto(Model model) {
		List<Category> categories = categoryService.findAll();
		FotoAlbum foto = new FotoAlbum();
		model.addAttribute("categories", categories);
		model.addAttribute("foto", foto);
		return "foto-form";
	}

	@PostMapping("/photos/create")
	public String storeFoto(Model model, @Valid @ModelAttribute FotoAlbum foto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			model.addAttribute("foto", foto);
			return "foto-form";
		}
		fotoAlbumService.save(foto);
		return "redirect:/";
	}

	@GetMapping("/photos/edit/{id}")
	public String editFoto(Model model, @PathVariable int id) {
		FotoAlbum foto = fotoAlbumService.findById(id);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("foto", foto);
		return "foto-form";
	}

	@PostMapping("/photos/edit/{id}")
	public String updateFoto(Model model, @Valid @ModelAttribute FotoAlbum foto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			model.addAttribute("foto", foto);
			return "foto-form";
		}
		fotoAlbumService.save(foto);
		return "redirect:/";
	}

	@PostMapping("/photos/delete/{id}")
	public String deleteFoto(@PathVariable int id) {
		FotoAlbum foto = fotoAlbumService.findById(id);
		fotoAlbumService.save(foto);

		fotoAlbumService.delete(foto);
		return "redirect:/";
	}

	@GetMapping("/messages")
	public String getMessages(Model model) {

		List<Message> messages = messageService.findAll();
		model.addAttribute("list", messages);

		return "message-index";
	}

}
