package com.restfulbooker.com.bookinginfo;

import com.restfulbooker.com.model.AuthPojo;
import com.restfulbooker.com.testbase.AuthTestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class AuthenticationCRUDTest extends AuthTestBase {


    @Title("Creating a new token to use for access to PUT and DELETE booking requests")
    @Test
    public void creatingNewToken(){
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");
        String token = SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(authPojo)
                .when()
                .post()
                .then()
                .extract()
                .path("token");
        System.out.println(token);

    }
}
