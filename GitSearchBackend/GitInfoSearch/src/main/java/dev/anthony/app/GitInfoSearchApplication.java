package dev.anthony.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dev.anthony.dao.StatsJDBCDAOImpl;
import dev.anthony.entities.ProjStats;



@SpringBootApplication

@ComponentScan("dev.anthony")
@EnableJpaRepositories("dev.anthony.repositories")
@EntityScan("dev.anthony.entities")
public class GitInfoSearchApplication {
	

	   private static HttpURLConnection connection;
	public static void main(String[] args) {
		SpringApplication.run(GitInfoSearchApplication.class, args);
		
		
		
			        BufferedReader reader;
			        String line;
			        StringBuffer response = new StringBuffer();
			try {
				StatsJDBCDAOImpl newsts= new StatsJDBCDAOImpl();
				
				
    // Establishing connection to the Github Api
				
				URL url = new URL("https://api.github.com/search/repositories?q=is:public%20project%20in:name%20language:python%20stars:%3E=500");
				connection = (HttpURLConnection)  url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(10000);
				connection.setReadTimeout(5000);
				
				
	// Connection
				   int status = connection.getResponseCode();
				         //System.out.println("Connection status "+ status);     
				   if (status>299) {
					   reader= new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				              while((line = reader.readLine()) != null) {
						            response.append(line);
				                    }
				       reader.close();
				   }
				   else {
					   reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
				              while((line = reader.readLine()) != null) {
					               response.append(line);
					               }
				       reader.close();
				   } 
				   String res=response.toString();
				         
				 
	//Getting the json
				@SuppressWarnings("deprecation")
				JsonParser parser =new JsonParser();
				Reader readder = new StringReader(res);
				@SuppressWarnings("deprecation")
				JsonElement rootelement = parser.parse(readder);
				JsonObject rootobj=rootelement.getAsJsonObject();
				rootobj.getAsJsonObject();
				
				
	//Extracting the array from one of the json fields
				JsonArray aray= rootobj.getAsJsonArray("items");
				      
				
   //Turning the json information into java objects and saving it in a list
				List<ProjStats> TotStat= new ArrayList<ProjStats>();
				for(JsonElement statelement:aray) {
					JsonObject statJsonObject= statelement.getAsJsonObject();
					//Extracting Data
					int sid=0;
					int reponum =statJsonObject.get("id").getAsInt();
					String Name =statJsonObject.get("name").getAsString();
					String  urll =statJsonObject.get("url").getAsString();
					String  createdDate=statJsonObject.get("created_at").getAsString();
					String lastPushDate=statJsonObject.get("pushed_at").getAsString();
					String description=statJsonObject.get("description").getAsString();
					int numOfStars =statJsonObject.get("stargazers_count").getAsInt();
					
					                      ProjStats st= new ProjStats();
					                                st.setSid(sid);
 					                                st.setRepoId(reponum);
					                                st.setName(Name);
					                                st.setUrl(urll);
					                                st.setCreatedDate(createdDate);
					                                st.setLastPushDate(lastPushDate);
					                                st.setDescription(description);
					                                st.setNumOfStars(numOfStars);

					TotStat.add(st);
				}
    //Getting the objects from the list and putting it in the DataBase 
				
				
				        try {
                              for(int i=0; i<26;i++){
					              ProjStats oop=TotStat.get(i);
                	              newsts.createProjSts(oop);
                               }    
				        }catch(NullPointerException e) {
					           System.out.println("Null pointer Exception thrown ");
				               }
			} catch (MalformedURLException e) {	
			} catch (IOException e) {
				System.out.println("Exception thrown");
			}
			finally {
				connection.disconnect();
			}
		}		
	}


