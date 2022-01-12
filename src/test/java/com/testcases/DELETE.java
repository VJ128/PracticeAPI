package com.testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest.API.Client.RestAPIClient;

public class DELETE extends BaseClass{
	String baseURL=getURL();
	@Test
	public void delete() throws ClientProtocolException, IOException
	{
		RestAPIClient client=new RestAPIClient();
		CloseableHttpResponse resp=client.delete(baseURL);
		int statuscode=resp.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 204);
		
	}

}
