import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class Get200Test {

    @Test
    public void getStatus200() {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/user1")
                .get();

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void getMessageUserNotFound() {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/user8877")
                .get();

        UserNotFound actualUserNotFound = response.getBody().as(UserNotFound.class);
        Assert.assertEquals("User not found",actualUserNotFound.getMessage());
    }
    @Test
    public void  checkResponseContainsId(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/user1")
                .get();
        IdContains actualIdContains = response.getBody().as(IdContains.class);
        Assert.assertEquals("9013685127327280746",String.valueOf(actualIdContains.getId()));

    }
    @Test
    public  void getStatus200Login(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/login")
                .get();
        int statusCodeLogin = response.getStatusCode();
        Assert.assertEquals(200,statusCodeLogin);
    }
    @Test
    public void  equalsId(){
        IdPost idPost = new IdPost(12131354, 5,4, "2020-12-10T15:36:35.247Z", "placed", true);
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order")
                .contentType(ContentType.JSON)
                .body(idPost)
                .post();
        IdPost bodyValue = response.getBody().as(IdPost.class);
        Assert.assertEquals(bodyValue.getId(), 12131354);


    }



}
