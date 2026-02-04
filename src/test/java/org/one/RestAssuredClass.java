package org.one;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClass {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.pathParam("id", 2);
		Response request = requestSpecification.request(Method.GET,"/api/users/{id}");
		int statusCode = request.getStatusCode();
		System.out.println(statusCode);
		String asPrettyString = request.getBody().asPrettyString();
		System.out.println(asPrettyString);
		int num=100;
		System.out.println("Deserialization");
		int num=200;
		System.out.println("Serialization");

		
		
	}

}
