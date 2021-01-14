package ru.myJsonServerTypicode;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class TestCase5 {
        @Test
        public void testCase5Step2() {
            //Correct request
            when()
                    .get("https://my-json-server.typicode.com/knastya/simpleBillingService")
                    .then().assertThat().statusCode(200);

            //incorrect request
            when()
            .get("https://my-json-server.typicode.com/knastya/simpleBillingServicesss")
                    .then().assertThat().statusCode(404);

        }

}
