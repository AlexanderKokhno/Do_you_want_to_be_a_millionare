
import org.json.JSONArray;
import java.util.Arrays;

public class JSONtoJAVA {
  public static String[] convertJSONArrayToStringArray(JSONArray jsonArray) {
    String[] stringArray = new String[jsonArray.length()];
    for (int i = 0; i < jsonArray.length(); i++) {
      stringArray[i] = jsonArray.getString(i);
    }

    return stringArray;

  }

}
