package com.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.constants.AppConstants;
import com.ashokit.entity.Contact;
import com.ashokit.props.AppProperties;
import com.ashokit.service.ContactService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContactController {
	
			@Autowired
			private ContactService contactService;
			
			@Autowired
			private AppProperties appProps;
			
			@PostMapping("/contact")
			public String saveConatct(@RequestBody Contact contact)
			{
				boolean status = contactService.saveContact(contact);
				
				Map<String,String> messages = appProps.getMessages();
				
				if (status 	) 
				{
					return messages.get(AppConstants.CONTACT_SAVE_SUCC);
				} else {
					return messages.get(AppConstants.CONTACT_SAVE_FAIL);
				}
			}
		
			// get All Contacts Component
		
			@GetMapping("/contacts")
			public List<Contact> getAllContacts()
			{
				return contactService.getAllContacts();
			}
			
			// @getContactById
			
			@GetMapping("/contact/{cid}")
			public Contact editContact(@PathVariable("cid") Integer contactId)
			{
				return contactService.getContactById(contactId);
			}
			
			// @deleteContactById
			
			@DeleteMapping("{cid}")
			public String deleteContact(@PathVariable("cid") Integer contactId)
			{
				boolean status = contactService.deleteContactById(contactId);
				
				Map<String,String> messages = appProps.getMessages();
				
				if(status)
				{
					return messages.get(AppConstants.CONTACT_DEL_SUCC);
				}
				else
				{
					return messages.get(AppConstants.CONTACT_DEL_FAIL);
				}
				
			}
			
			
			// update contact component
			
//			@PutMapping("{contactId}")
//			public ResponseEntity<Contact> updateContact(@PathVariable("contactId") Integer contactId, @RequestBody Contact contact)
//			{
//				boolean isUpdated = contactService.saveContact(contact);
//				
//				if(isUpdated)
//				{
//					return new ResponseEntity<Contact>(HttpStatus.OK);
//				}
//				else 
//				{
//					return new ResponseEntity<Contact>(HttpStatus.CONFLICT);
//				}
//			}
				
			
			
			
	
	

}
