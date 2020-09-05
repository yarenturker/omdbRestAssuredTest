package trendyolTestPackage;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

public class testBase {


	public ValidatableResponse findMovie(String movieName, String apiKey, String address){
		return given()
				.param("s", movieName)
				.param("apikey", apiKey)
				.when()
				.get(address)
				.then();
	}
	
	public String findMovieNameByImdbID(String imdbID, String apiKey, String address){
		String movieNameByImdbID = given()
				.param("i", imdbID)
				.param("apikey", apiKey)
				.when()
				.get(address)
				.path("Title");
		return movieNameByImdbID;
	}
	
	public String findMovieYear(String imdbID, String apiKey, String address){
		String movieYear = given()
				.param("i", imdbID)
				.param("apikey", apiKey)
				.when()
				.get(address)
				.path("Year");
		return movieYear;
	}
	
	public  String findReleasedArea(String imdbID, String apiKey, String address){
		String releasedArea = given()
				.param("i", imdbID)
				.param("apikey", apiKey)
				.when()
				.get(address)
				.path("Released");
		
	return releasedArea;
	}

}
