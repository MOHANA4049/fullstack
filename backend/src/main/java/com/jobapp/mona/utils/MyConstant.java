package com.jobapp.mona.utils;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.HEAD;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import java.util.Arrays;
import java.util.List;


public class MyConstant {

    //RequestMapping
    //all the static variables will be present here
    public static final String AUTH = "/api/v1/auth";
    public static final String USER = "/api/v1/user";
    public static final String Joblist="/api/v1/jobs";
    public static final String Companylist="/api/v1/company";
    public static final String Applicationlist="/api/v1/app";
    //End points
    public static final String REGISTER = "/register";
    public static final String POSTAPP = "/";
    public static final String LOGIN = "/login";
    public static final String USERLIST = "/list";
    public static final String GETJOB = "/getjob";
    public static final String Getcompany = "/getcompany";
    public static final String postcompany = "/postcompany";
    public static final String GetApplication = "/getapp";
    public static final String postApplication = "/postapp";
    // public static final String APPLICATION = "/application";

    //Web security
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:4000");
    public static final List<String> HEADERS = Arrays.asList(AUTHORIZATION,CONTENT_TYPE);//HttpHeaders.AUTHORIZATION
    // in the methods everthing is given as HttpMethod.GET.name() then converted into static
    public static final List<String> METHODS = Arrays.asList(GET.name(),POST.name(),PUT.name(),
    PATCH.name(),DELETE.name(),HEAD.name());

    //JsonWebToken
    public static final String SWAGGER_LOCALHOST_URL="http://localhost:8181";
    public static final String SWAGGER_SECURITY_SCHEME_NAME="bearerAuth";
    public static final String SWAGGER_SCHEME="bearer";
    public static final String SWAGGER_BEARER_FORMAT="JWT";
    public static final String SWAGGER_DESCRIPTION="Produce a Json Web Token.";
}
 