package com.restfulbooker.com.testbase;

import com.restfulbooker.com.constants.Path;
import com.restfulbooker.com.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BookingTestBase {


    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.BOOKING;
    }

}
