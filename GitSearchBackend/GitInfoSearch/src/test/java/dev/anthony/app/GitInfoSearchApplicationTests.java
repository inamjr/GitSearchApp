package dev.anthony.app;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import dev.anthony.entities.ProjStats;
import dev.anthony.repositories.StatsRepo;
import dev.anthony.services.StatsServices;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitInfoSearchApplicationTests {

	@Autowired
	StatsServices sas;
	
	@Autowired
	StatsRepo sr;
	
	
	            //RepoTest
	
	   //works
	@Test
	@Rollback
	//@Commit
	void addstats() {
		ProjStats st = new ProjStats();
		st.setCreatedDate("12/10/2020 11:00pm");
		st.setDescription(" thing");
		st.setLastPushDate("12/10/2020 12:00pm");
		st.setName("tim");
		st.setNumOfStars(3);
		st.setRepoId(2);
		st.setSid(8);
		st.setUrl("www.ucandothis.com");
		sr.save(st);
     	
		System.out.println(st);
		
	}
	//works
	@Test
	@Rollback
	//@Commit
	void deleteStats() {
		ProjStats st = new ProjStats();
         st.setSid(3);
         sr.delete(st);
         System.out.println(st +" Has been deleted");
	}
	
	//works
	@Test
	@Rollback
	//@Commit
	void UpdateStats() {
		ProjStats st = new ProjStats();
		st.setCreatedDate("12/10/2020 11:00pm");
		st.setDescription(" thing");
		st.setLastPushDate("12/10/2020 12:00pm");
		st.setName("tim buktu1");
		st.setNumOfStars(3);
		st.setRepoId(2);
		st.setSid(2);
		st.setUrl("www.ucandffffffothis.com");
     	sr.save(st);
		System.out.println(st.getName()+ " Has been Updated");
	}
	
	
	
	
	
	           // services
	@Test
	@Rollback
	//@Commit
	void Creatstatsservice() {
		ProjStats st = new ProjStats();
		st.setCreatedDate("12/10/2020 11:00pm");
		st.setDescription(" thing");
		st.setLastPushDate("12/10/2020 12:00pm");
		st.setName("tim buktu");
		st.setNumOfStars(3);
		st.setRepoId(02);
		st.setSid(8);
		st.setUrl("www.ucandffffffothis.com");
     	sas.createStat(st);
		System.out.println(st);
	}
	//works
	@Test
	@Rollback
	//@Commit
	void deleteStatsService() {
		ProjStats st = new ProjStats();
         st.setSid(2);
         sas.deleteStat(st);
         System.out.println(st.getName() +" Has been deleted");
	}
	
	//works
	@Test
	@Rollback
	void UpdateStatsService() {
		ProjStats st = new ProjStats();
		st.setCreatedDate("12/10/2020 11:00pm");
		st.setDescription(" thing");
		st.setLastPushDate("12/10/2020 12:00pm");
		st.setName("tim buktu123");
		st.setNumOfStars(3);
		st.setRepoId(2);
		st.setSid(1);
		st.setUrl("www.ucandffffffothis.com");
     	sas.updatestat(st);
		System.out.println(st.getName()+ " Has been Updated");
	}

}
