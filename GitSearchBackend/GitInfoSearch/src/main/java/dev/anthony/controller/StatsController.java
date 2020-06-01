package dev.anthony.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import dev.anthony.entities.ProjStats;
import dev.anthony.services.StatsServices;


@Component
@Controller
@springfox.documentation.swagger2.annotations.EnableSwagger2
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StatsController {

	@Autowired
	StatsServices ss;
// Implementing  CRUD
	
	
	//Read
	@ResponseBody
	@RequestMapping(value ="/stats",method = RequestMethod.GET)
	public List<ProjStats> getAllStats(){
		return ss.getallStats();   // automatically turns objects to json
	}
	
	//Create
	@ResponseBody
	@RequestMapping(value ="/stats/newSt", method = RequestMethod.POST)
	public ProjStats creatStats(@RequestBody ProjStats pjst) {
		System.out.println("Stats Controller "+ pjst+" Created");
		return ss.createStat(pjst);
	}
	
	//Update
	@ResponseBody
	@RequestMapping( value ="/stats", method= RequestMethod.PUT)
	public ProjStats UpdateStats(@PathVariable ProjStats pjst) {
		System.out.println("Stats Controller "+ pjst + "Updated");
		return ss.updatestat(pjst);	
	}
	//Delete
	@ResponseBody
	@RequestMapping( value ="/stats/{sid}", method= RequestMethod.DELETE)
	public boolean DeleteStats(@PathVariable int sid) {
		return ss.deleteStat(ss.getStatbySid(sid));
	}
	
}
