//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.17
//
package com.churchapp.ikon.ikonchurch.amazonaws.mobile;

import com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.config.AWSMobileHelperConfiguration;
import com.amazonaws.regions.Regions;

/**
 * This class defines constants for the developer's resource
 * identifiers and API keys. This configuration should not
 * be shared or posted to any public source code repository.
 */
public class AWSConfiguration {
    //The Videos database
    public static  final String AWS_DYNAMODB_TABLENAME_VIDEOS = "VideosDB";
    // AWS MobileHub user agent string
    public static final String AWS_MOBILEHUB_USER_AGENT =
        "MobileHub 6f193131-031d-4708-903c-33a947422435 aws-my-sample-app-android-v0.17";
    // AMAZON COGNITO
    public static final Regions AMAZON_COGNITO_REGION =
      Regions.fromName("us-east-1");
    public static final String  AMAZON_COGNITO_IDENTITY_POOL_ID =
        "us-east-1:e717b72c-1df0-4190-a789-e0ce9881320e";
    // AMAZON MOBILE ANALYTICS
    public static final String  AMAZON_MOBILE_ANALYTICS_APP_ID =
        "64e899b09e2d4575ada6d9127b9dc052";
    // Amazon Mobile Analytics region
    public static final Regions AMAZON_MOBILE_ANALYTICS_REGION = Regions.US_EAST_1;
    public static final String AMAZON_CONTENT_DELIVERY_S3_BUCKET =
        "ikonapp-contentdelivery-mobilehub-1505785601";
    public static final Regions AMAZON_CONTENT_DELIVERY_S3_REGION =
       Regions.fromName("us-east-1");
    // S3 BUCKET
    public static final String AMAZON_S3_USER_FILES_BUCKET =
        "ikonapp-userfiles-mobilehub-1505785601";
    // S3 BUCKET REGION
    public static final Regions AMAZON_S3_USER_FILES_BUCKET_REGION =
        Regions.fromName("us-east-1");
    public static final Regions AMAZON_DYNAMODB_REGION =
       Regions.fromName("us-east-1");
    public static final String AMAZON_COGNITO_USER_POOL_ID =
        "us-east-1_Am84nJR4a";
    public static final String AMAZON_COGNITO_USER_POOL_CLIENT_ID =
        "1ljthjdd7cgb9lus6luvc2r43l";
    public static final String AMAZON_COGNITO_USER_POOL_CLIENT_SECRET =
        "pd5bhroud5qqpv958hcdk4t1o6i0bgvob374ephbmt6iitvjifr";

    private static final AWSMobileHelperConfiguration helperConfiguration = new AWSMobileHelperConfiguration.Builder()
        .withCognitoRegion(AMAZON_COGNITO_REGION)
        .withCognitoIdentityPoolId(AMAZON_COGNITO_IDENTITY_POOL_ID)
        .withCognitoUserPool(AMAZON_COGNITO_USER_POOL_ID,
            AMAZON_COGNITO_USER_POOL_CLIENT_ID, AMAZON_COGNITO_USER_POOL_CLIENT_SECRET)
        .build();
    /**
     * @return the configuration for AWSKit.
     */
    public static AWSMobileHelperConfiguration getAWSMobileHelperConfiguration() {
        return helperConfiguration;
    }
}
