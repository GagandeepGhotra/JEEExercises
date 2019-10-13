package ca.sheridancollege.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bean.Contact;

@Repository
public class DatabaseAccess {

	@Autowired NamedParameterJdbcTemplate jdbc;
	
	//CREATE TABLE contacts (name VARCHAR(255), phoneNumber bigint(20), address VARCHAR(255), email VARCHAR(255));
	
	public void addContact(Contact contact) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO contacts VALUES " +
		"(:name, :phoneNumber, :address, :email)";
		parameters.addValue("name", contact.getContactName());
		parameters.addValue("phoneNumber", contact.getContactPhoneNumber());
		parameters.addValue("address", contact.getContactAddress());
		parameters.addValue("email", contact.getContactEmail());
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Contact> showContacts() {
		String query = "SELECT * FROM contacts";
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String, Object>());
		for(Map<String, Object> row : rows) {
			Contact newContact = new Contact();
			newContact.setContactName((String)(row.get("name")));
			newContact.setContactPhoneNumber((Long)(row.get("phoneNumber")));
			newContact.setContactAddress((String)(row.get("address")));
			newContact.setContactEmail((String)(row.get("email")));
			contacts.add(newContact);
		}
		return contacts;
	}
}
