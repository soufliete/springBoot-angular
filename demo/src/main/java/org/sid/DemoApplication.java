package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("gigi", "med", df.parse("12/03/1990"), "gigi.med@gmail.com", 0664445147 , "test"));
		contactRepository.save(new Contact("hqssh", "hiskan", df.parse("12/03/1990"), "hqssh.hiskan@gmail.com", 0664445147 , "test"));
		contactRepository.save(new Contact("gizyiuizgi", "teyei", df.parse("12/03/1990"), "gizyiuizgi.teyei@gmail.com", 0664445147 , "test"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		}
				
				);
				


	}

}

