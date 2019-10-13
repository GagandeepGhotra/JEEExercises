package ca.sheridancollege.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.bean.Contact;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {
	
	@Autowired private DatabaseAccess da;
	
	@GetMapping("/")
	public String getNewContactPage() {
		return "newContact.html";
	}
	
	@PostMapping("/contact")
	public String redirectToHomeAfterAdding(@RequestParam String name, 
			@RequestParam long phoneNumber, @RequestParam String address, 
			@RequestParam String email) {
		Contact newContact = new Contact();
		newContact.setContactName(name);
		newContact.setContactPhoneNumber(phoneNumber);
		newContact.setContactAddress(address);
		newContact.setContactEmail(email);
		da.addContact(newContact);
		return "newContact.html";
	}
	
	@GetMapping("/showAllContacts")
	public String getShowAllContactsPage(Model model) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll(da.showContacts());
		model.addAttribute("contacts", contacts);
		return "showAllContacts.html";
	}	
}
