/**
 * 
 */
package com.ebusiness.niche.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebusiness.niche.entity.Company;
import com.ebusiness.niche.service.CompanyService;
import com.sun.istack.internal.logging.Logger;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class CompanyController {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CompanyService companyService;
	
	@ResponseBody
	@RequestMapping(value = {"/company"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Company>> getCompanys() {
		log.info("getCompanys(): Called...");
		
		List<Company> companyList = null;
		
		companyList = this.companyService.findAll();
		
		if( companyList == null || companyList.isEmpty() ) {
			log.info("getCompanys(): returned a null or empty list.");
			ResponseEntity<List<Company>> rVal = new ResponseEntity<List<Company>>(companyList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);		
	}

}
