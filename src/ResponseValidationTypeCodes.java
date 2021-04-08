import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class ResponseValidationTypeCodes {

private final HashMap<String, String> codes;

private static ResponseValidationTypeCodes instance;

public static ResponseValidationTypeCodes getInstance() {
    if (instance == null) {
        instance = new ResponseValidationTypeCodes();
    }
    return instance;
}

ResponseValidationTypeCodes() {
    super();
    codes = new HashMap<String, String>();
    initEntry();
}

private void initEntry() {
    Properties prop = new Properties();
    try {
        prop.load(new FileInputStream(
                "C:\\Users\\Rahul Sharma\\peoplestrongcode\\Test\\resources\\altadmin.properties"));
        for (Entry<Object, Object> element : prop.entrySet()) {
            codes.put(element.getKey().toString(), element.getValue()
                    .toString());
        }

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

public String getValueByCode(String string) {
    return codes.get(string);
}
}