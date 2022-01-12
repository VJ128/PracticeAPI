package com.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest.API.Client.RestAPIClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.PojoSingleUser;

public class PUT extends BaseClass {

	String baseURL = getURL();
	RestAPIClient client = new RestAPIClient();
	ObjectMapper mapper;
	PojoSingleUser user;

	@Test
	public void put() throws ClientProtocolException, IOException {
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		mapper = new ObjectMapper();
		user = new PojoSingleUser("morpheus", "zion resident");
		String stringentity = mapper.writeValueAsString(user);
		CloseableHttpResponse response = client.put(baseURL, headermap, stringentity);
		String jasonstring = EntityUtils.toString(response.getEntity());
		System.out.println(jasonstring);
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
	}

}
