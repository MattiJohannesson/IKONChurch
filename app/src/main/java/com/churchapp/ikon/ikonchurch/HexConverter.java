package com.churchapp.ikon.ikonchurch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattijoh on 28/04/2017.
 */

public class HexConverter {

    List<Integer> HexList= new ArrayList<Integer>();
    String Hex;
    public void FromDECTOHEX(float DEC){
        FromDECtoHEX(DEC);
    }

    public String FromDECtoHEX(float DEC){

        while (DEC >= 16){
            DEC /=16;
            float Remainder = DEC - (int)DEC;
            DEC = DEC - Remainder;
            Remainder*= 16;
            HexList.add((int) Remainder);
        }
        HexList.add((int)DEC);
        for (int i = HexList.size() - 1; i != -1;i--){
            if(HexList.get(i)<10){
                if (Hex != null){
                Hex += HexList.get(i);
            }
            else {
                    Hex = HexList.get(i).toString();
                }
            }

            if (HexList.get(i) == 10){
               if (Hex != null){
                Hex += "A";
               }
               else {
                   Hex = "A";
               }
            }

            if (HexList.get(i) == 11){
                if (Hex != null){
                    Hex += "B";
                }
                else {
                    Hex = "B";
                }
            }

            if (HexList.get(i) == 12){
                if (Hex != null){
                    Hex += "C";
                }
                else {
                    Hex = "C";
                }
            }

            if (HexList.get(i) == 13){
                if (Hex != null){
                    Hex += "D";
                }
                else {
                    Hex = "D";
                }
            }

            if (HexList.get(i) == 14){
                if (Hex != null){
                    Hex += "E";
                }
                else {
                    Hex = "E";
                }
            }

            if (HexList.get(i) == 15){
                if (Hex != null){
                    Hex += "F";
                }
                else {
                    Hex = "F";
                }
            }

        }
        new StringBuilder(Hex).reverse().toString();
        return Hex;
    }
}
