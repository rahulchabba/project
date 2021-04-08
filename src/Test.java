
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResponseValidationTypeCodes s = new ResponseValidationTypeCodes();
		System.out.println(s.getValueByCode("http_port"));
		System.out.println(ResponseValidationTypeCodes.getInstance().getValueByCode("http_port"));
	}

}
