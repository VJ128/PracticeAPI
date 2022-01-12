package com.Rest.API.Client;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	// Get JSON Objects' values
	public int getData(JSONObject response, String fieldname) {
		int value = response.getInt(fieldname);
		return value;
	}

	// JSONArray values
	public Object getArrayValues(JSONObject response, String name, String fieldname, int i) {
		JSONArray jsonarray = response.getJSONArray(name);//here name=data in the jsonresponse
		JSONObject jobj = jsonarray.getJSONObject(i);
		Object obj = jobj.get(fieldname);
		return obj;
	}
}

/*
 * {"last_name":"Lawson","id":7,"avatar":
 * "https://reqres.in/img/faces/7-image.jpg",
 * "first_name":"Michael","email":"michael.lawson@reqres.in"}
 */
