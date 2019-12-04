# android-xml-and-json-file-parse
This Project was created using Android Studio 3.4.2 

# Language
Java

# Purpose of this project
Data Parsing of XML and JSON file and display in TextView.

# Packges used for XML Parsing:

import org.xmlpull.v1.XmlPullParser;\
import org.xmlpull.v1.XmlPullParserException;\
import org.xmlpull.v1.XmlPullParserFactory;


# Important Classes and Methods for XML file Parsing used in this project:

# Class: 	XmlPullParserFactory
Methods:

	newInstance()

	newPullParser()


# Class:	InputStream
Methods:

	context.getAssets().open("map.xml");


# Class:	XmlPullParser
Methods:

	setFeature( XmlPullParser.FEATURE_PROCESS_NAMESPACES,false)

	setInput(is, null)

	getEventType()

	getName()

	nextText()

	next()

Fields:

	XmlPullParser.END_DOCUMENT

	XmlPullParser.START_TAG

# Packges used for JSON file Parsing:

import org.json.JSONArray;\
import org.json.JSONException;\
import org.json.JSONObject;

# Important Classes and Methods for JSON file Parsing used in this project:

# Class: 	JSONObject
Methods:

	getJSONArray("results");
	getString("name");

# Class:	InputStream
Methods:

	context.getAssets().open("map.xml");\
	available();\
	read(buffer);\
	close();

# Class:	JSONArray
Methods:

	getJSONObject(i);
	length()



