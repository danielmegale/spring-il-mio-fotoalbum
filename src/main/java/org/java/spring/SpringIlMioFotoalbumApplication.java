package org.java.spring;

import java.util.List;

import org.java.spring.auth.conf.AuthConfig;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.service.RoleService;
import org.java.spring.auth.db.service.UserService;
import org.java.spring.pojo.Category;
import org.java.spring.pojo.FotoAlbum;
import org.java.spring.pojo.Message;
import org.java.spring.service.CategoryService;
import org.java.spring.service.FotoAlbumService;
import org.java.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private FotoAlbumService fotoAlbumService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category nat = new Category("Natura");
		Category urb = new Category("Urbano");
		Category ani = new Category("Animali");
		Category self = new Category("Selfie");
		Category food = new Category("Cibi e Bevande");

		categoryService.save(nat);
		categoryService.save(urb);
		categoryService.save(ani);
		categoryService.save(self);
		categoryService.save(food);

		Message messaggio1 = new Message("indirizzo.mail.it", "Ciao mi piacciono le tue foto");
		Message messaggio2 = new Message("indirizzo.mail.com", "Che bella foto!");
		Message messaggio3 = new Message("indirizzo.mail.org", "WOW! GREAT! AWESOME!");
		Message messaggio4 = new Message("indirizzo.mail.eu", "Ciao potrei acquistare una tua foto?");
		Message messaggio5 = new Message("indirizzo.mail.io", "Bella foto!");
		messageService.save(messaggio1);
		messageService.save(messaggio2);
		messageService.save(messaggio3);
		messageService.save(messaggio4);
		messageService.save(messaggio5);

		fotoAlbumService.save(new FotoAlbum("pippo", "descizione", "https://picsum.photos/200/300", false, nat));
		fotoAlbumService.save(new FotoAlbum("nome2", "descizione", "", false, urb));
		fotoAlbumService.save(new FotoAlbum("nome3", "descizione", "", false, ani));
		fotoAlbumService.save(new FotoAlbum("nome4", "descizione", "https://picsum.photos/200/300", true, food));
		fotoAlbumService.save(new FotoAlbum("nome5", "descizione", "", true, self));
		fotoAlbumService.save(new FotoAlbum("nome6", "descizione", "", true, ani, urb));

		List<FotoAlbum> photos = fotoAlbumService.findAll();

		Role roleAdmin = new Role("ADMIN");

		roleService.save(roleAdmin);

		String pws = AuthConfig.passwordEncoder().encode("pws");

		User admin = new User("admin", pws, roleAdmin);

		userService.save(admin);
	}
}
