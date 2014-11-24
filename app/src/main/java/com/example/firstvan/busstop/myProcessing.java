package com.example.firstvan.busstop;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import android.content.res.AssetManager;

/**
 * Created by firstvan on 23/11/14.
 */
public class myProcessing {

    //private HashMap<String, ArrayList<Megallok>> hm = new HashMap<String, ArrayList<Megallok>>();
    private ArrayList<Megallok> hm = new ArrayList<Megallok>();

    public myProcessing(AssetManager assetmanager) throws XmlPullParserException, IOException {
        /*map.put("10",new Megallok("NagyPista",30.12, 1123234.432));
        map.put("10",new Megallok("kispista",343.12, 1234.432));
        */
        XmlPullParserFactory fact = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = fact.newPullParser();

        xpp.setInput(assetmanager.open("megallok.xml"), null);

        int eventType = xpp.getEventType();

        String name = null;
        int szamlalo = 0;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (xpp.getName().equals("jarat")) {
                    name = xpp.getAttributeValue(0);
                }

                if (xpp.getName().equals("item")) {
                    String name1 = xpp.getAttributeValue(0);
                    double lat = Double.parseDouble(xpp.getAttributeValue(1));
                    double lng = Double.parseDouble(xpp.getAttributeValue(2));

                    hm.add(new Megallok(name, name1, lat, lng));
                }

            }
            eventType = xpp.next();
        }
    }

    public ArrayList<Megallok> getJaratok(){
        return hm;
    }

    public HashSet<String> getJaratNev()
    {
        HashSet<String> temp = new HashSet<String>();

        for(Megallok a : hm)
        {
            temp.add(a.getJarat());
        }

        return temp;
    }
}
