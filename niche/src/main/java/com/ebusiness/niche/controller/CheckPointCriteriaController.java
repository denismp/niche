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

import com.ebusiness.niche.entity.CheckPointCriteria;
import com.ebusiness.niche.service.CheckPointCriteriaService;
import com.sun.istack.internal.logging.Logger;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class CheckPointCriteriaController {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CheckPointCriteriaService checkpointCriteriaService;
	
	@ResponseBody
	@RequestMapping(value = {"/checkpointcriterias"}, method = { RequestMethod.GET })
	public ResponseEntity<List<CheckPointCriteria>> getCheckPointCriterias() {
		log.info("getCheckPointCriterias(): Called...");
		
		List<CheckPointCriteria> checkPointCriteriaList = null;
		
		checkPointCriteriaList = this.checkpointCriteriaService.findAll();
		
		if( checkPointCriteriaList == null || checkPointCriteriaList.isEmpty() ) {
			log.info("getCheckPointCriterias(): returned a null or empty list.");
			ResponseEntity<List<CheckPointCriteria>> rVal = new ResponseEntity<List<CheckPointCriteria>>(checkPointCriteriaList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<CheckPointCriteria>>(checkPointCriteriaList, HttpStatus.OK);		
	}

}
