package dev.anthony.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.anthony.entities.ProjStats;
import dev.anthony.repositories.StatsRepo;

@Component
@Service
public class StatsServicesimpl implements StatsServices {

	@Autowired
	StatsRepo sr;
	
	
	@Override
	public ProjStats createStat(ProjStats sts) {
		this.sr.save(sts);
		return sts;
	}

	@Override
	public Set<ProjStats> getallStat() {
		Set<ProjStats> st = new HashSet<ProjStats>((Collection<? extends ProjStats>)sr.findAll());
		return st;
	}
	@Override
	public List<ProjStats> getallStats( ) {
		List<ProjStats> st = new ArrayList<ProjStats>((Collection<? extends ProjStats>)sr.findAll());
		return st;
	}

	@Override
	public ProjStats updatestat(ProjStats sts) {
		sts = sr.save(sts);
		return sts;
	}

	@Override
	public boolean deleteStat(ProjStats sts) {
		this.sr.delete(sts);
		return true;
	}

	@Override
	public ProjStats getStatbySid(int sid) {

		return sr.findById(sid).get();
	}

}
