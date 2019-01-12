package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//List ALL
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public List<Contact> getContact()
	{
		return contactRepository.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercheContact",method=RequestMethod.GET)
	
	public Page<Contact> chercheContact(
			@RequestParam(name="mc" , defaultValue="") String mc , 
			@RequestParam(name="page" , defaultValue="0" )int page , 
			@RequestParam(name="size" , defaultValue="5") int size)
	{
		
		return contactRepository.chercher(mc, new PageRequest(page, size));
	}
	
	//find one 
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public Optional<Contact> findContact(@PathVariable Long id)
	{
		return contactRepository.findById(id);
	}
	
	@RequestMapping(value="/contact",method = RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c)
	{
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/contact/{id}",method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable Long id)
	{
		contactRepository.deleteById(id);
	}
	
	
	
	public Contact updateContact(@PathVariable Long id , @RequestBody Contact c)
	{
		c.setId(id);
		return contactRepository.save(c);
	}
	

}
