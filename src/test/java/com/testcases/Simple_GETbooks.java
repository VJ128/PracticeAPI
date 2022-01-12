package com.testcases;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Rest.API.Client.RestAPIClient;
import com.Rest.API.Client.TestUtil;

public class Simple_GETbooks extends BaseClass {
	public String url = getbooksurl();
	RestAPIClient client = new RestAPIClient();
	TestUtil testutil = new TestUtil();
	JSONObject responseJson;
	CloseableHttpResponse jresponse;

	@BeforeClass
	public void getMethod() throws ClientProtocolException, IOException {
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		jresponse = client.get(url, headermap);
		System.out.println(jresponse);

		// json string
		String responseString = EntityUtils.toString(jresponse.getEntity());
        System.out.println(responseString);
		responseJson = new JSONObject(responseString);
		//System.out.println("Response JSON from API---> " + responseJson);
	}

	@Test
	public void status() {
		int statuscode = jresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
	}
	@Test
	public void dataValidation()
	{
		
		
	}
	
}
/*[{"id":1,"name":"The Russian","type":"fiction","available":true},
 * {"id":2,"name":"Just as I Am","type":"non-fiction","available":false},
 * {"id":3,"name":"The Vanishing Half","type":"fiction","available":true},
 * {"id":4,"name":"The Midnight Library","type":"fiction","available":true},
 * {"id":5,"name":"Untamed","type":"non-fiction","available":true},
 * {"id":6,"name":"Viscount Who Loved Me","type":"fiction","available":true}]
 */
