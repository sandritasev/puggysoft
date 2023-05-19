package puggysoft.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** RequestAuth. */
public final class RequestAuth {

  private static RequestAuth instance;
  private String token;

  /** Private constructor.*/
  private RequestAuth() {
    this.login();
  }

  /** get singleton. */
  protected static RequestAuth getInstance() {
    if (instance == null) {
      instance = new RequestAuth();
    }
    return instance;
  }

  /** get token . */
  protected static String getToken() {
    return getInstance().token;
  }

  /** login method */
  protected void login() {

    Map<String, String> body = new HashMap<>();
    body.put("username", RequestAuthProperties.getUsername());
    body.put("password", RequestAuthProperties.getPassword());
    String urlBase = RequestUrlProperties.getUrlBase();
    String endpoint = RequestAuthProperties.getAuthEndpoint();
    RestAssured.baseURI = urlBase;
    Response response = RestAssured
      .given()
      .contentType(ContentType.JSON)
      .when()
      .body(body)
      .post(endpoint);
    this.token = response.jsonPath().get("token");
  }
}
