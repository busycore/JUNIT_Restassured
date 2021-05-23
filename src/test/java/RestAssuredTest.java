import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    @Test
    @DisplayName("Should Return a Success Request from SWAPI API")
    public void ShouldReturnASuccessRequestFromSWAPI(){

        when()
                .get("https://swapi.dev/api/people/1/")
                .then()
                .statusCode(200)
                .body("name",equalTo("Luke Skywalker"));
    }

    @Test
    @DisplayName("Should Return an Error Request from SWAPI API")
    public void ShouldReturnAnErrorRequestFromSWAPI(){

        when()
                .get("https://swapi.dev/api/people/1337/")
                .then()
                .statusCode(404);
    }
}
