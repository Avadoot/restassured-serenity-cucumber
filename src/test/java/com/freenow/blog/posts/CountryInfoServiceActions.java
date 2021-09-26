package com.freenow.blog.posts;

import com.freenow.blog.commontasks.CommonRequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CountryInfoServiceActions {

    FileInputStream fileInputStream;

    public Response getCurrency() throws IOException {
        fileInputStream = new FileInputStream("src/test/resources/xmls/currency.xml");

        return SerenityRest.given().spec(CommonRequestSpec.httpSoapReqSpecBuilder())
                .basePath("CountryInfoService.wso")
                .body(IOUtils.toString(fileInputStream, StandardCharsets.UTF_8))
                .post().then().extract().response();
    }

    public Response getPhoneCode() throws IOException {
        fileInputStream = new FileInputStream("src/test/resources/xmls/phonecode.xml");

        return SerenityRest.given().spec(CommonRequestSpec.httpSoapReqSpecBuilder())
                .basePath("CountryInfoService.wso")
                .body(IOUtils.toString(fileInputStream, StandardCharsets.UTF_8))
                .post().then().extract().response();
    }

    public Response getCapitalCity() throws IOException {
        fileInputStream = new FileInputStream("src/test/resources/xmls/capital.xml");

        return SerenityRest.given().spec(CommonRequestSpec.httpSoapReqSpecBuilder())
                .basePath("CountryInfoService.wso")
                .body(IOUtils.toString(fileInputStream, StandardCharsets.UTF_8))
                .post().then().extract().response();
    }
}
