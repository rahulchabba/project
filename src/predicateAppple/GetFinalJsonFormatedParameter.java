package predicateAppple;

import org.apache.wink.json4j.JSONObject;

public class GetFinalJsonFormatedParameter {
	public JSONObject dataJsonObject;
	public String responseformat;

	public GetFinalJsonFormatedParameter(JSONObject dataJsonObject, String responseformat) {
		this.dataJsonObject = dataJsonObject;
		this.responseformat = responseformat;
	}
}