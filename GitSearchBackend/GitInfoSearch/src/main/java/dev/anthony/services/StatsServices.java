package dev.anthony.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.anthony.entities.ProjStats;

@Component
@Service
public interface StatsServices {

	ProjStats createStat(ProjStats sts);
	
	ProjStats getStatbySid(int sid);
	
	Set<ProjStats> getallStat();
	
	List<ProjStats> getallStats( );
	
	ProjStats updatestat(ProjStats sts);
	
	boolean deleteStat(ProjStats sts);
}
