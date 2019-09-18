/**
 * 
 */
package com.ebusiness.niche.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ebusiness.niche.entity.Company;
import com.ebusiness.niche.service.CompanyService;
//import com.sun.istack.internal.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping(value = "/niche")
public class CompanyController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyService companyService;

//	@ResponseBody
	@RequestMapping(value = { "/company" }, method = { RequestMethod.GET })
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Company>> getCompanys() {
		log.info("getCompanys(): Called...");

		List<Company> companyList = null;

		companyList = this.companyService.findAll();

		if (companyList == null || companyList.isEmpty()) {
			log.info("getCompanys(): returned a null or empty list.");
			ResponseEntity<List<Company>> rVal = new ResponseEntity<List<Company>>(companyList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
	}

//	@ResponseBody
	@RequestMapping(value = { "/company/{id}" }, method = { RequestMethod.GET })
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
		log.info("getCompany(): Called...");
		log.info("id=" + id);

//		List<Company> companyList = null;
		Optional<Company> optcompany = null;
		Company company = null;

		optcompany = this.companyService.findById(id);

		if (optcompany == null) {
			log.info("getCompany(): returned a null.");
			ResponseEntity<Company> rVal = new ResponseEntity<Company>(company, HttpStatus.NO_CONTENT);
			return rVal;
		} else {
			company = optcompany.get();
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

//	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = { "/company/{id}" }, headers = "Accept=application/json", method = { RequestMethod.PUT })
	public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		log.info("updateCompany(): Called...");
		log.info("id=" + id);

		Optional<Company> currentCompany = this.companyService.findById(id);
		Company dbCompany = null;

		if (currentCompany == null) {
			log.error("Unable to update.  The company with id {} not found.", id);
			ResponseEntity<Company> rVal = new ResponseEntity<Company>(company, HttpStatus.NO_CONTENT);
			return rVal;
		}

		try {
			dbCompany = currentCompany.get();
			dbCompany.setCompanyName(company.getCompanyName());
			dbCompany.setEmail(company.getEmail());
			dbCompany.setNotes(company.getNotes());
			dbCompany.setPhone(company.getPhone());
			dbCompany.setWebSite(company.getWebSite());

			dbCompany = this.companyService.update(dbCompany);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to update the company with id {}.", id);
			ResponseEntity<Company> rVal = new ResponseEntity<Company>(company, HttpStatus.EXPECTATION_FAILED);
			return rVal;
		}

		return new ResponseEntity<Company>(dbCompany, HttpStatus.OK);
	}

}
