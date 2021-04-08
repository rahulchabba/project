import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

public class Java8Test {

	public static void main(String[] args) throws JSONException {

		String newk = "C";
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "b");
		System.out.println(map);
		map.put(newk, map.remove("a"));

		System.out.println(map);
		JSONObject dataJsonObject=new JSONObject();
		dataJsonObject.put("NETMAPNODES", " { \"nodeName\": \"local.node\",     \"maxConcurrentConnectionPNode\": 255,    \"shortTermRetryInterval\": 30,                    \"ipAddress\": \"\", \"alternateOutboundAddress\": \"\",      \"faspFilesizeThreshold\": \"\",    \"tcpCRC\": \"\",      \"faspPolicy\": \"\",        \"faspBandwidth\": \"\",      \"shortTermFailRetryAttempt\": 3,      \"fasp\": \"\",      \"transportMode\": \"\",      \"longTermRetryInterval\": 600,      \"connectionRetryExhaustAction\": \"hold\",      \"alternateAddress\": \"\",      \"longTermFailRetryAttempt\": 6,      \"defaultSessionClass\": 1,      \"maxConcurrentConnectionSNode\": 255,      \"bufferSize\": \"65536\"  }");
		dataJsonObject.put("SECUREPLUSNODE","{  \"commonName\": \"\",  \"authenticationTimeout\": 240,  \"enableDataEncryption\": \"y\",  \"enableExternalAuthentication\": \"n\",  \"externalAuthCertificateValidationDefinition\": \"\",  \"type\": \"l\",  \"secureNodeName\": \".Local\",  \"securePlusProtocol\": \"SSL\",  \"certificateLabel\": \"ssl_server\",  \"cipherSuites\": \"TLS_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_RC4_128_SHA,TLS_RSA_WITH_RC4_128_MD5,TLS_RSA_WITH_3DES_EDE_CBC_SHA,TLS_RSA_WITH_DES_CBC_SHA,TLS_RSA_WITH_NULL_SHA,TLS_RSA_WITH_NULL_MD5\",  \"enableFIPS\": \"n\",  \"clientAuthentication\": \"n\",  \"override\": \"y\",  \"baseName\": \"gkumar10\" }");
 
		System.out.println(getFinalJsonFormated(dataJsonObject, "Object"));

	}

	public static JSONArray getFinalJsonFormated(JSONObject dataJsonObject, String responseformat) throws JSONException {

		JSONArray jsonArray = new JSONArray();

		JSONObject objToReturn = null;

		
		
		if (responseformat.equalsIgnoreCase("Object")) {
			if (dataJsonObject != null) {
			  for (Object currentApi : dataJsonObject.keySet()) {
					JSONArray singleJsonofCurrentAPI = new JSONArray();
					singleJsonofCurrentAPI = (JSONArray) dataJsonObject.get(currentApi);
					for (Object singleJson : singleJsonofCurrentAPI) {
						objToReturn = new JSONObject();
						JSONObject jsonSinglekeyValue = (JSONObject) singleJson;
						if (jsonArray == null || jsonArray.isEmpty()) {
							objToReturn.put(currentApi, jsonSinglekeyValue);
							jsonArray.add(objToReturn);
						} else {
							Object[] arraylistToUpdate = jsonArray.toArray();
							boolean flag = true;
							for (Object toadd : arraylistToUpdate) {
								JSONObject alreadyAddedJson = (JSONObject) toadd; 
								for(Object addedAPIS:alreadyAddedJson.keySet()){
								if (!addedAPIS.equals(currentApi) && alreadyAddedJson.containsKey(addedAPIS)
										&& ((JSONObject) alreadyAddedJson.get(addedAPIS)).containsKey("nodeName")
										&& jsonSinglekeyValue.containsKey("nodeName")
										&& ((JSONObject) alreadyAddedJson.get(addedAPIS)).get("nodeName").toString()
												.equalsIgnoreCase(jsonSinglekeyValue.get("nodeName").toString())) {
									alreadyAddedJson.put(currentApi, jsonSinglekeyValue);
									flag = false;
								} else if (!alreadyAddedJson.containsKey(currentApi)
										&& jsonSinglekeyValue.containsKey("secureNodeName")
										&& ((JSONObject) alreadyAddedJson.get(addedAPIS)).get("nodeName").toString()
												.equalsIgnoreCase("local.node") && addedAPIS.equals("NETMAPNODES") && currentApi.equals("SECUREPLUSNODE")
										&& (jsonSinglekeyValue.get("secureNodeName").toString()
												.equalsIgnoreCase(".Local"))) {
									alreadyAddedJson.put(currentApi, jsonSinglekeyValue);
									flag = false;
								}
								}
							}
							if (flag) {
								objToReturn.put(currentApi, jsonSinglekeyValue);
								jsonArray.add(objToReturn);
							}
						}
					}
				} //for loop 
			}
			for (Object obj : jsonArray) {
				JSONObject inner = (JSONObject) obj;
				for (Object currentApi : dataJsonObject.keySet()) {
					if (!inner.containsKey(currentApi)) {
						inner.put(currentApi, new JSONObject());
					}
				}
			}
		} else if (responseformat.equalsIgnoreCase("simpleArray")) {/*
			JSONObject formattedDataJsonObject = new JSONObject();

			for (Object key : dataJsonObject.keySet()) {

				// based on you key types

				try {

					apiName = (String) key;

					apiValue = dataJsonObject.get(apiName);

					// for nested objects iteration if required

					if (apiValue instanceof JSONArray)

						formattedDataJsonObject = iterJsonArray((JSONArray) apiValue, formattedDataJsonObject);

				}

				catch (JSONException je) {

					//CDUtilLogger.error(CDUtilLogger.getInstance(), je);

				}

			}

			jsonArray = new JSONArray();

			jsonArray.put(formattedDataJsonObject);

		*/} else if (responseformat.equalsIgnoreCase("rest")) {

			JSONObject jsonObjectOfData = new JSONObject(dataJsonObject);

			JSONArray jsonObjectArray = new JSONArray();

			jsonObjectArray.add(jsonObjectOfData);

			jsonArray = jsonObjectArray;

		}

		return jsonArray;

	}

}
