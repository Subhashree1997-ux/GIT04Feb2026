package org.one;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParam {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification specification = RestAssured.given();
		specification.queryParam("page", 2);
		Response request = specification.request(Method.GET,"/api/users");
		String asPrettyString = request.getBody().asPrettyString();
		System.out.println(asPrettyString);
		ResponseBody body = request.getBody();
		int int1 = body.jsonPath().getInt("data[0].id");
		Assert.assertEquals(7, int1);
		int statusCode = request.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}

}
