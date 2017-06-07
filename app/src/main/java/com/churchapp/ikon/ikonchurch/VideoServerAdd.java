package com.churchapp.ikon.ikonchurch;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.churchapp.ikon.ikonchurch.amazonaws.mobile.AWSConfiguration;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.VideosDO;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * Created by mattijoh on 26/05/2017.
 */

public class VideoServerAdd {

    String _title, _description, _tags, _Videolink, _thumbLink;

    public void AddVideosToServer(String title, String Description, String tags, String videoLink, String thumbLink, CognitoCachingCredentialsProvider provider){
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(provider.getCredentials());
        ddbClient.setRegion(Region.getRegion(AWSConfiguration.AMAZON_DYNAMODB_REGION));

        VideosDO viddb = new VideosDO();
        viddb.setUserId(provider.getCachedIdentityId());
        viddb.setDescription(_description);
        viddb.setTags(_tags);
        viddb.setTitle(_title);
        viddb.setVideoLink(_Videolink);
        viddb.setThumbnailLink(_thumbLink);
    }
}
