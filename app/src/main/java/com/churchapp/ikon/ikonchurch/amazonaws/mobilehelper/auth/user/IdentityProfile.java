package com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.auth.user;
//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.18
//

import android.graphics.Bitmap;
import com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.auth.IdentityProvider;
import com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.auth.IdentityManager;

import java.io.IOException;
import java.util.Map;

/**
 * This interface provides methods for obtaining profile information about a signed in user.
 * Call {@link IdentityManager#getIdentityProfile()} when signed in
 * to obtain the currently signed in identity profile.
 */
public interface IdentityProfile {

    /**
     * Gets the user's name, assuming user is signed in.
     *
     * @return user name or null if it is not available.
     */
    String getUserName();

    /**
     * Gets the user's image url, assuming user is signed in.
     *
     * @return image or null if it is not available.
     */
    String getUserImageUrl();

    /**
     * @return the user image url or null if it is not available.
     */
    Bitmap getUserImage();

    /**
     * Get Additional User Profile data.
     *
     * @return a Map containing additional user profile data.
     */
    Map<String, String> getCustomProfileAttributesMap();

    /**
     * Load the profile information using the corresponding identity provider.
     * This method will make a network call and must not be called on the main thread.
     * @param provider  the identity provider.
     * @return self for chaining.
     * @throws ProfileRetrievalException if the profile cannot be retrieved
     */
    IdentityProfile loadProfileInfo(final IdentityProvider provider) throws ProfileRetrievalException;

    /**
     * Load the user image using the user image url.
     * This method will block and must not be called on the main thread.
     */
    void loadUserImage() throws IOException;
}
