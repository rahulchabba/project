import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsonEncodeDemo {

   public static void main(String[] args) throws JSONException{
	   JSONObject obj = new JSONObject();

      obj.put("name", "foo");
      obj.put("num", new Integer(100));
      obj.put("balance", new Double(1000.21));
      obj.put("is_vip", new Boolean(true));
 
      JSONArray arr = new JSONArray(obj);
      Stream.of(arr).filter( (curr) -> curr instanceof Integer ).forEach(action);
      
      
   }
}