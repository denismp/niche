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

import com.ebusiness.niche.entity.CriteriaYesNo;
import com.ebusiness.niche.service.CriteriaYesNoService;
import com.sun.istack.internal.logging.Logger;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class CriteriaYesNoController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CriteriaYesNoService criteriaYesNoService;
	
	@ResponseBody
	@RequestMapping(value = {"/criteriayesno"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<CriteriaYesNo>> getCriteriaYesNos() {
		log.info("getCriteriaYesNos(): Called...");
		
		List<CriteriaYesNo> list = null;
		
		list = this.criteriaYesNoService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getCriteriaYesNos(): returned a null or empty list.");
			ResponseEntity<List<CriteriaYesNo>> rVal = new ResponseEntity<List<CriteriaYesNo>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<CriteriaYesNo>>(list, HttpStatus.OK);		
	}

}
