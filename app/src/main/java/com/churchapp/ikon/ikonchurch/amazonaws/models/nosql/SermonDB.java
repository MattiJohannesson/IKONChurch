package com.churchapp.ikon.ikonchurch.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Matti on 10/06/2017.
 */
@DynamoDBTable( tableName = "Sermons")
public class SermonDB {

    private String _Hex, _Title, _Description, _Id, _ThumbId;
    private int _totalItems;

    public int gettotalItems(){for (int i = 0; i<i++;i++){
        if (getId() != null){
            _totalItems++;
        }
        else{return _totalItems;}
    }
    return _totalItems;
    }

    public String getHex(){return _Hex;}
    public void setHex(final String Hex){this._Hex = Hex;}

    public String getTitle(){return _Title;}
    public void setTitle(final String Title){this._Title = Title;}

    public String getDescription(){return _Description;}
    public void setDescription(final String Description){this._Description = Description;}

    public String getId(){return _Id;}

    public String getThumbId(){return _ThumbId;}
    public void setThumbId(final String ThumbID){this._ThumbId = ThumbID;}
}

