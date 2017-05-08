package com.globeshanghai.frontend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by stijnergeerts on 2/05/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class JWTDecoderTest {
    @Value("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlJESkVNRFpFUmpJeE1qY3dOVFU0TkRJd05EYzFOVUV4TkRFMU5EUXlNemcxUXpkQ056RkVRUSJ9.eyJuYW1lIjoic3Rpam5lcmdlZXJ0c0Bob3RtYWlsLmNvbSIsIm5pY2tuYW1lIjoic3Rpam5lcmdlZXJ0cyIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci8wMTg0NjQ2MzU4OTkzZTg2YzIwOGM0Zjg2ZDY4YWU2Mz9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRnN0LnBuZyIsInVwZGF0ZWRfYXQiOiIyMDE3LTA0LTI2VDA4OjA3OjQ2LjgwM1oiLCJlbWFpbCI6InN0aWpuZXJnZWVydHNAaG90bWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6Ly9nbG9iZXNoYW5naGFpLmF1LmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1OTAwNTRmZTRkZDQwMDIxZWI4YTY3ODciLCJhdWQiOiJvR2E0aWwzRVBwQVBrdVk2ODZCMjhmaE5lYTAyLTIxUCIsImV4cCI6MTQ5MzIzMDA2NiwiaWF0IjoxNDkzMTk0MDY2fQ.oVlWc5aRFUmhPR7hOSH3WnKmh2TAh7u_pafgI36nklC8UYohKkHdVI1eCAo3FnzHMKrc1W9Ak4USZSsjjsGYNqbB2FrfTl0zXLqpjxl-D9hukeIt7XG5XSOr8X60H6CdyHeg7_DZi_UbvtC0qRRi2wvdUKOsLaGbD5Mf6p3XYhIB7u1-fZnfPg8YboQLXNoxX9Os7q_sI5ZbUVWW7zgS_TkoYzGNk1_IOSGgZTBZ9oZ332fQhLj5gFBmapkxhdKRaISxRViDmiXNv5bT74OV-eq5CfL9iBAW2a4_L-AeglVGiYfAiowQ_uHruzocCo80PaSh56WMygMO_OHkCXFa0g")
    private String token;

    @Value("abc123")
    private String noToken;


    @Test
    public void testDecoder(){
        JWT jwt = JWT.decode(token);
        System.out.println("User: " + jwt.getSubject());
        System.out.println("Issuer: " + jwt.getIssuer());
        System.out.println("Expiration: " + jwt.getExpiresAt());

        assertEquals(jwt.getSubject(),"auth0|590054fe4dd40021eb8a6787");

    }


    @Test(expected = JWTDecodeException.class)
    public void testDecoderFails(){
        JWT jwt = JWT.decode(noToken);
    }

}


