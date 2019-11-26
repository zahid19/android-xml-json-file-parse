package com.temp.jsonparseexample.model;

import android.content.Context;

import com.temp.jsonparseexample.model.MapModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseXML {

    public static String parse(Context context)
    {
        StringBuilder sb;
        sb = new StringBuilder();
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = parserFactory.newPullParser();
            //InputStream is = getAssets().open("map_api.json");
            InputStream is =  context.getAssets().open("map.xml");
            pullParser.setFeature( XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            pullParser.setInput(is, null);

            ArrayList<MapModel> mapModels = new ArrayList<>();
            int eventType = pullParser.getEventType();

            MapModel mapModel = null ;

            while(eventType != XmlPullParser.END_DOCUMENT)
            {
                String eltName = null ;
                switch (eventType)
                {
                    case XmlPullParser.START_TAG:
                        eltName = pullParser.getName();
                        if ("result".equals(eltName)) {
                            mapModel = new MapModel();
                            mapModels.add(mapModel);
                        } else if (mapModel != null) {
                            if ("name".equals(eltName)) {
                                mapModel.setName( pullParser.nextText() ) ;
                            }else if ("vicinity".equals(eltName)) {
                                mapModel.setVicinity( pullParser.nextText() ); ;
                            }else if ("rating".equals(eltName)) {
                                mapModel.setRating( pullParser.nextText() ); ;
                            }
                        }
                        break ;
                }
                eventType = pullParser.next();
            }
            for( MapModel m : mapModels)
            {
                System.out.println( m.getName() + m.getVicinity() + m.getRating() );
                sb.append("Name:" );
                sb.append( m.getName() );
                sb.append("\n");
                sb.append( "Address:");
                sb.append(  m.getVicinity() );
                sb.append("\n");
                sb.append("Rating:");
                sb.append(m.getRating());
                sb.append("\n");
                sb.append("\n");
            }
        }
        catch (XmlPullParserException e)
        {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}//END OF CLASS
// https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=23.869683,90.3999081&radius=250&type=atm&key=YOUR_GOOGLE_API_KEY