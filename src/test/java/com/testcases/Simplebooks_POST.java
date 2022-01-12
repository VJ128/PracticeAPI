package com.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest.API.Client.RestAPIClient;
import com.Rest.API.Client.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.PojoSingleUser;
import pojos.SimpleBooksPojo;

public class Simplebooks_POST extends BaseClass {
	String baseURl = getSimplebooksURL();
	SimpleBooksPojo user;
	TestUtil testutil;
	RestAPIClient client = new RestAPIClient();
	JSONObject jsonresp;
	ObjectMapper mapper;
	String response;
	CloseableHttpResponse jresponse;
	@BeforeClass
	public void post() throws ClientProtocolException, IOException {
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization", "f5b9f4ddec8590ef99856469056cdc4118ea44a85bb45e320f116efdb45c83ca");
		// Create request payload
		mapper = new ObjectMapper();
		user = new SimpleBooksPojo(1, "Vijaya");
		//Java to Json string
		String stringentity = mapper.writeValueAsString(user);

		jresponse = client.post(baseURl, headermap, stringentity);
        System.out.println(jresponse);
		int statuscode = jresponse.getStatusLine().getStatusCode();
		//Assert.assertEquals(statuscode, 201);

		response = EntityUtils.toString(jresponse.getEntity());
		System.out.println(response);
		jsonresp = new JSONObject(response);
	}

	// --------------------------data validation------------------------------
	/*
	 * @Test public void dataValidation() throws JsonMappingException,
	 * JsonProcessingException { Object name1 = jsonresp.get("name"); String name2 =
	 * user.getName(); Assert.assertEquals(name1, name2);
	 * 
	 * Object job1 = jsonresp.get("job"); String job2 = user.getJob();
	 * Assert.assertEquals(job1, job2);
	 * 
	 * // Another way of validating data //json to java object PojoSingleUser
	 * userresp=mapper.readValue(response, PojoSingleUser.class);
	 * Assert.assertEquals(userresp.getName(),user.getName());
	 * Assert.assertEquals(userresp.getName(), user.getName()); }
	 */
	//header validation
	@Test
	public void headerValidation()
	{
		Header[] headerarray=jresponse.getAllHeaders();
		
		for(Header header:headerarray)
		{
			if(header.getName().equals("Content-Type")) {
			Assert.assertEquals(header.getValue(), "application/json; charset=utf-8");
		}
		}
	}
}
