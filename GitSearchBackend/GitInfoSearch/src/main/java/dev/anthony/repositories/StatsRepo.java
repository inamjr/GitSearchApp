package dev.anthony.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.anthony.entities.ProjStats;


@Component
@Repository
public interface StatsRepo extends CrudRepository<ProjStats,Integer> {
 
	
	
}
