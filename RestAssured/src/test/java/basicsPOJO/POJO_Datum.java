package basicsPOJO;

import java.util.HashMap;
import java.util.Map;

public class POJO_Datum {

private int id;
private String email;
private String first_name;
private String last_name;
private String avatar;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getFirstName() {
return first_name;
}

public void setFirstName(String firstName) {
this.first_name = firstName;
}

public String getLastName() {
return last_name;
}

public void setLastName(String lastName) {
this.last_name = lastName;
}

public String getAvatar() {
return avatar;
}

public void setAvatar(String avatar) {
this.avatar = avatar;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
