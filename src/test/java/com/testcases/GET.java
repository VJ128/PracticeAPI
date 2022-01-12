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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Rest.API.Client.RestAPIClient;
import com.Rest.API.Client.TestUtil;

public class GET extends BaseClass {
	public String url = getURL();
	RestAPIClient client = new RestAPIClient();
    TestUtil testutil=new TestUtil();
    JSONObject responseJson;
    CloseableHttpResponse jresponse;
    int i=0;
    //dataprovider
    @DataProvider(name="DP1")
    public Object[][] createData1() throws Exception
    {
     Object[][] retObjArr=getTableArray("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls","DataPool", "userdetails");
     return(retObjArr);
     //Datapool is the sheet name
    }
        @BeforeClass
	    public void getMethod() throws ClientProtocolException, IOException {
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		jresponse = client.get(url, headermap);
        //System.out.println(jresponse);
		
		// json string
		String responseString = EntityUtils.toString(jresponse.getEntity());

		responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API---> "+ responseJson);

		int statuscode = jresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, 200);
		//log.info("status code is verified");
        }
//-------------------------------------data validation--------------------------------------
		@Test(dataProvider="DP1")
		public void getValuesFromJSONResponse(String xlid,String xlfirst_name,String xllast_name,String xlemail,String xlavatar ) {
		// per_page value validation
		int per_page=testutil.getData(responseJson, "per_page");
		Assert.assertEquals(per_page, 6);
		
		//total value validation
		int total=testutil.getData(responseJson, "total");
		Assert.assertEquals(total, 12);
		
		//total_pages value validation
		int total_pages=testutil.getData(responseJson, "total_pages");
		Assert.assertEquals(total_pages, 2);
		
		//page value validation
		int page=testutil.getData(responseJson, "page");
		Assert.assertEquals(page, 1);

		Object last_name=testutil.getArrayValues(responseJson, "data", "last_name", i);
		Assert.assertEquals(last_name, xllast_name);
		Object id=testutil.getArrayValues(responseJson, "data", "id", i);
		int id1=Integer.parseInt(xlid);
		Assert.assertEquals(id, id1);
		Object avatar=testutil.getArrayValues(responseJson, "data", "avatar", i);
		Assert.assertEquals(avatar, xlavatar);
		Object first_name=testutil.getArrayValues(responseJson, "data", "first_name", i);
		Assert.assertEquals(first_name, xlfirst_name);
		Object email=testutil.getArrayValues(responseJson, "data", "email", i);
		Assert.assertEquals(email, xlemail);
		i++;
//-------------------------------------------------------------------------------------
        //Get Header from the response
		Header[] allheaders = jresponse.getAllHeaders();
		HashMap<String, String> header = new HashMap<String, String>();
		for (Header hdr : allheaders) {
			header.put(hdr.getName(), hdr.getValue());
		}
        //System.out.println("Header map "+header );
		}

}
