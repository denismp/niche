/**
 * 
 */
package com.ebusiness.niche.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebusiness.niche.entity.ContactInfo;
import com.ebusiness.niche.service.ContactInfoService;
import com.sun.istack.internal.logging.Logger;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class ContactInfoController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@ResponseBody
	@RequestMapping(value = {"/contactinfos"}, method = { RequestMethod.GET })
	public ResponseEntity<List<ContactInfo>> getContactInfos() {
		log.info("getContactInfos(): Called...");
		
		List<ContactInfo> list = null;
		
		list = this.contactInfoService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getContactInfos(): returned a null or empty list.");
			ResponseEntity<List<ContactInfo>> rVal = new ResponseEntity<List<ContactInfo>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<ContactInfo>>(list, HttpStatus.OK);		
	}

}
