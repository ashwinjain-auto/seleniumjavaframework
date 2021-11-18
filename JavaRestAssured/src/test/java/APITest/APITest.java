package APITest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class APITest {
	
	@Test
	public void GetAPI_test() {
	
		given()
			.param("page","2")
			.auth().none()
			.get("https://reqres.in/api/users")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.log().all();
		
	}
	
	@Test
	public void PostAPI_test() {
	
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name","morpheus");
		map1.put("job", "leader");
		JSONObject body1 = new JSONObject(map1);
		
		given()
			.auth().none()
			.body(body1.toJSONString())
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}

}
