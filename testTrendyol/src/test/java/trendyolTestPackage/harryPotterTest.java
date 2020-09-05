package trendyolTestPackage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class harryPotterTest extends testBase {
	

	//Base URL tanımlanması
	@BeforeTest
	public void setUp(){
		RestAssured.baseURI = "http://omdbapi.com";
	}
	
	@Test
	public void harryPotterTest() {

		ValidatableResponse response = findMovie("Harry Potter", "6b18a2b7","http://omdbapi.com");
		response.extract().response().prettyPrint();
		
		//"Harry Potter and the Sorcerer's Stone" filmin id'sinin bulunması
		String imdbID = response.extract().path("Search.imdbID[1]");
		System.out.println(imdbID);
		
		//Film id'si ile film araması
		String movieNameByImdbID = findMovieNameByImdbID(imdbID, "6b18a2b7","http://omdbapi.com");
		System.out.println(movieNameByImdbID);
	
		//Film id'si ile filmin yılının bulunması
		String movieYear = findMovieYear(imdbID, "6b18a2b7","http://omdbapi.com");
		System.out.println(movieYear);
		
		//Released alanının alınması
		String releasedArea = findReleasedArea(imdbID, "6b18a2b7","http://omdbapi.com");
		System.out.println(releasedArea);
		
		//Response iceriginin kontrolu
		assertTrue(!movieNameByImdbID.isEmpty());
		assertTrue(!movieYear.isEmpty());
		assertTrue(!releasedArea.isEmpty());
		assertEquals(200, response.extract().statusCode());
	}
}
