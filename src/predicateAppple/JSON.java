package predicateAppple;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

public class JSON {

	public static void main(String[] args) throws JSONException, InterruptedException, ExecutionException {

		String newk = "C";
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "b");
		System.out.println(map);
		map.put(newk, map.remove("a"));

		System.out.println(map);
		JSONObject dataJsonObject=new JSONObject();
		dataJsonObject.put("SECUREPLUSNODE", " {  \"commonName\": \"\",  \"authenticationTimeout\": 240,  \"enableDataEncryption\": \"y\",  \"enableExternalAuthentication\": \"n\",  \"externalAuthCertificateValidationDefinition\": \"\",  \"type\": \"l\",  \"secureNodeName\": \".Local\",  \"securePlusProtocol\": \"SSL\",  \"certificateLabel\": \"ssl_server\",  \"cipherSuites\": \"TLS_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_RC4_128_SHA,TLS_RSA_WITH_RC4_128_MD5,TLS_RSA_WITH_3DES_EDE_CBC_SHA,TLS_RSA_WITH_DES_CBC_SHA,TLS_RSA_WITH_NULL_SHA,TLS_RSA_WITH_NULL_MD5\",  \"enableFIPS\": \"n\",  \"clientAuthentication\": \"n\",  \"override\": \"y\",  \"baseName\": \"gkumar10\" }");

		
		ExecutorService execs = Executors.newCachedThreadPool();
		Future<String>  future = execs.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				String r = "";
				int i=0;
				for(int ii =0; ii < 5 ; ii++){
				r = getFinalJsonFormated(dataJsonObject , "a"+i);
				i++;
				}
			 return r;
				}});
		 
		Future<String>  future1 = execs.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				String r = "";
				int i=0;
				for(int ii =0; ii < 5 ; ii++){
				r = getFinalJsonFormated(dataJsonObject , "a"+i);
				i++;
				}
			 return r+future.get();		
				}});
									 
						
		
	}

	public static String getFinalJsonFormated(JSONObject dataJsonObject, String responseformat) throws JSONException, InterruptedException {
		System.out.println(responseformat);
		Thread.sleep(1000);
		return  responseformat;
		
		
		
		
	}

}
