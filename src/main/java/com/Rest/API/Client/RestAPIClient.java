package com.Rest.API.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestAPIClient {
	// GET
	public CloseableHttpResponse get(String baseURL, HashMap headermap) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getreq = new HttpGet(baseURL);
		Set<Entry<String, String>> set = headermap.entrySet();
		for (Entry<String, String> e : set) {
			getreq.addHeader(e.getKey(), e.getValue());
		}
		CloseableHttpResponse resp = client.execute(getreq);
		return resp;
	}

	// POST
	public CloseableHttpResponse post(String baseURL, HashMap headermap, String stringentity)
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost postreq = new HttpPost(baseURL);
		Set<Entry<String, String>> set = headermap.entrySet();
		// Add Header values
		for (Entry<String, String> e : set) {
			postreq.addHeader(e.getKey(), e.getValue());
		}
		postreq.setEntity(new StringEntity(stringentity));
		CloseableHttpResponse resp = client.execute(postreq);
		return resp;
	}

	// PUT
	public CloseableHttpResponse put(String baseURL, HashMap headermap, String stringenity)
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut putreq = new HttpPut(baseURL);
		Set<Entry<String, String>> set = headermap.entrySet();
		for (Entry<String, String> e : set) {
			putreq.addHeader(e.getKey(), e.getValue());
		}
		putreq.setEntity(new StringEntity(stringenity));
		CloseableHttpResponse resp = client.execute(putreq);
		return resp;
	}

	// DELETE
	public CloseableHttpResponse delete(String baseURL) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete delreq = new HttpDelete(baseURL);
		CloseableHttpResponse resp = client.execute(delreq);
		return resp;
	}
	// DELETE simplebooks
	public CloseableHttpResponse deletesimplebooks(String baseURL, HashMap headermap) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete delreq = new HttpDelete(baseURL);
		Set<Entry<String,String>> set=headermap.entrySet();
		for (Entry<String, String> e : set) {
			delreq.addHeader(e.getKey(), e.getValue());
		}
		CloseableHttpResponse resp = client.execute(delreq);
		return resp;
	}

}
