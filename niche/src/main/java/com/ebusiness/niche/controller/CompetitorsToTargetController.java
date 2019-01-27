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

import com.ebusiness.niche.entity.CompetitorsToTarget;
import com.ebusiness.niche.service.CompetitorsToTargetService;
import com.sun.istack.internal.logging.Logger;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class CompetitorsToTargetController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CompetitorsToTargetService competitorsToTargetService;
	
	@ResponseBody
	@RequestMapping(value = {"/competitorstotargets"}, method = { RequestMethod.GET })
	public ResponseEntity<List<CompetitorsToTarget>> getCompetitorsToTarget() {
		log.info("getCompetitorsToTarget(): Called...");
		
		List<CompetitorsToTarget> list = null;
		
		list = this.competitorsToTargetService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getCompetitorsToTarget(): returned a null or empty list.");
			ResponseEntity<List<CompetitorsToTarget>> rVal = new ResponseEntity<List<CompetitorsToTarget>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<CompetitorsToTarget>>(list, HttpStatus.OK);		
	}

}
