package com.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Rest.API.Client.RestAPIClient;

public class Simplebooks_DELETE extends BaseClass {
	CloseableHttpResponse resp;
	String jsonrespstring;
	String baseURL = "https://simple-books-api.glitch.me/orders/JdvTKraZgGEx0YVtCeNb1";

	@BeforeClass
	public void delete() throws ClientProtocolException, IOException {
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Authorization", "f5b9f4ddec8590ef99856469056cdc4118ea44a85bb45e320f116efdb45c83ca");
		RestAPIClient client = new RestAPIClient();
		resp = client.deletesimplebooks(baseURL, headermap);
		System.out.println(resp);
	}

	@Test
	public void status() {
		int statuscode = resp.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 204);
	}
}
