package com.churchapp.ikon.ikonchurch.amazonaws.models.nosql;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.s3.AmazonS3Client;
import com.churchapp.ikon.ikonchurch.R;

/**
 * Created by Matti on 10/06/2017.
 */
@DynamoDBTable( tableName = "Sermons")
public class SermonDB extends AsyncTask{

    private String _Hex, _Title, _Description, _Id, _ThumbId;
    private AmazonDynamoDBClient _DBClient;
    private Object[] param;
private Exception exception;

    @Override
    protected TableDescription doInBackground(Object[] params) {
        try{
        TableDescription tableDescription = _DBClient.describeTable("ikonapp-mobilehub-1505785601-Sermons").getTable();

        return tableDescription;
        }
        catch (Exception e)
        {
            this.exception = e;

            return null;

        }
    }

    public int getItemCount(AmazonDynamoDBClient DBClient){
        _DBClient = DBClient;
        TableDescription tableDescription = doInBackground(param);
        return tableDescription.getItemCount().intValue();
    }

    public String getHex(){return _Hex;}
    public void setHex(final String Hex){this._Hex = Hex;}

    public String getSermonTitle(){return _Title;}
    public void setTitle(final String Title){this._Title = Title;}

    public String getDescription(){return _Description;}
    public void setDescription(final String Description){this._Description = Description;}

    public String getId(){return _Id;}

    public String getThumbId(){return _ThumbId;}
    public void setThumbId(final String ThumbID){this._ThumbId = ThumbID;}
}

