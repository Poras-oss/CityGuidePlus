package com.minor.cityguideplus;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;


import org.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FetchData extends AsyncTask<String,String,String> {
    String nearbyPlaceData = "";
    String url;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<LatLng> latlong = new ArrayList<>();
    ArrayList<Boolean> openOrNot = new ArrayList<>();
    ArrayList<Integer> Rating = new ArrayList<>();
    ArrayList<Integer> total_user_rating = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();
    Context context;



    public FetchData(MainActivity mainActivity) {
        this.context = mainActivity;
    }


    @Override
    protected String doInBackground(String... strings) {
        // network call

      try {
            url = strings[0];
            DownloadUrl downloadUrl = new DownloadUrl();
            nearbyPlaceData = downloadUrl.retrieveUrl(url);


        } catch (IOException e) {
            e.printStackTrace();
        }



        return nearbyPlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(s.length() < 1){
            s = "{\n" +
                    "  \"html_attributions\": [],\n" +
                    "  \"results\":\n" +
                    "    [\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8587323, \"lng\": 151.2100055 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.85739847010727, \"lng\": 151.2112436298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86009812989271, \"lng\": 151.2085439701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/bar-71.png\",\n" +
                    "        \"icon_background_color\": \"#FF9E67\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/bar_pinlet\",\n" +
                    "        \"name\": \"Cruise Bar\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 608,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/112582655193348962755\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uECvJIZuXT-uLDYm4DPbrV7gXVPeplbTWUgcOJ6rnfc4bUYCEAwPU_AmXGIaj0PDhWPbmrjQC8hhuXRJQjnA1-iREGEn7I0ZneHg5OP1mDT7lYVpa1hUPoz7cn8iCGBN9MynjOPSUe-UooRrFw2XEXOLgRJ-uKr6tGQUp77CWVocpcoG\",\n" +
                    "              \"width\": 1080,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJi6C1MxquEmsR9-c-3O48ykI\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46R6+G2 The Rocks, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46R6+G2\",\n" +
                    "          },\n" +
                    "        \"price_level\": 2,\n" +
                    "        \"rating\": 4,\n" +
                    "        \"reference\": \"ChIJi6C1MxquEmsR9-c-3O48ykI\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\"bar\", \"restaurant\", \"food\", \"point_of_interest\", \"establishment\"],\n" +
                    "        \"user_ratings_total\": 1269,\n" +
                    "        \"vicinity\": \"Level 1, 2 and 3, Overseas Passenger Terminal, Circular Quay W, The Rocks\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8675219, \"lng\": 151.2016502 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86614532010728, \"lng\": 151.2031259298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86884497989272, \"lng\": 151.2004262701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Sydney Harbour Dinner Cruises\",\n" +
                    "        \"opening_hours\": { \"open_now\": true },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 835,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/109764923610545394994\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEBVsYnNcrpRixtrlHBztigZh70CwYkNWZzQnqJ39SjeBo_wvgKf-kXc6tgaMLBdQrRKmxmSKjOezoZrv-sHKVbTX0OI48HBqYYVnQiZQ-WGeuQDsLEPwX7LaVPa68nUAxX114Zpqt7bryoO9wL4qXdgEnopbOp5WWLALhKEHoIEH7f7\",\n" +
                    "              \"width\": 1200,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJM1mOVTS6EmsRKaDzrTsgids\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+XM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+XM\",\n" +
                    "          },\n" +
                    "        \"rating\": 4.8,\n" +
                    "        \"reference\": \"ChIJM1mOVTS6EmsRKaDzrTsgids\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"tourist_attraction\",\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 9,\n" +
                    "        \"vicinity\": \"32 The Promenade, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8676569, \"lng\": 151.2017213 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86629922010728, \"lng\": 151.2031712798927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86899887989272, \"lng\": 151.2004716201073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Clearview Sydney Harbour Cruises\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 685,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/114394575270272775071\">Clearview Glass Boat Cruises</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEAlExjnXA0VWyb_oYwCJ8utWG_Ennhwmn_xadpgenMNUgTuxrvgf1Xdw4bsbL6kFSWH7bhbpVHK1esdNY37ancJvbL_Gnsc7EZ5KEBNPvYZ_ZEyLco4a5v34LFkodxfFZbJ-ejO3zN4W_0C37P5jAmTnLWMNFYUPvoU3UMi70qHRNF5\",\n" +
                    "              \"width\": 1024,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJNQfwZTiuEmsR1m1x9w0E2V0\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+WM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+WM\",\n" +
                    "          },\n" +
                    "        \"rating\": 3.8,\n" +
                    "        \"reference\": \"ChIJNQfwZTiuEmsR1m1x9w0E2V0\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 49,\n" +
                    "        \"vicinity\": \"32 The Promenade King Street Wharf 5, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8677035, \"lng\": 151.2017297 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86634597010728, \"lng\": 151.2031781298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86904562989272, \"lng\": 151.2004784701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Sydney Harbour Lunch Cruise\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 545,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/102428257696490257922\">Sydney Harbour Lunch Cruise</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEBFyQ2xDzHk7dGF_FTvNeJ01NQD6GROq89rufdGQl5Gi0zVfpnETBjPK2v7UEDl_6F-m8aR5FcEWJMqPaH4Oh_CQh2jaUAUAesUInucpCe7OFdleSYJ_8kgunhsIvGf1D1s_pes6Rk2JMVEs8rEs6ZHSTmUQXX2Yh-Gt9MuPQdYNuNv\",\n" +
                    "              \"width\": 969,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJUbf3iDiuEmsROJxXbhYO7cM\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+WM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+WM\",\n" +
                    "          },\n" +
                    "        \"rating\": 3.9,\n" +
                    "        \"reference\": \"ChIJUbf3iDiuEmsROJxXbhYO7cM\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 23,\n" +
                    "        \"vicinity\": \"5/32 The Promenade, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8675883, \"lng\": 151.2016452 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86623847010728, \"lng\": 151.2029950298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86893812989273, \"lng\": 151.2002953701073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Sydney Showboats - Dinner Cruise With Show\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 4912,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/105311284660389698992\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uED1aGaMs8xYfiuzeBqVcFsk3yguUujdE4S3rNThMpLtoU0RukF40KCt0CAxgHP1HoY8Z7NYcWvax6qmMMVPBbmzGhoaiwiAAyv2GGA9vhcgsJ5w0LweT0y1lgRGZxU3nZIdNLiYAp9JHM171UkN04H6UqYSxKVZ8N_f2aslkqOaBF_e\",\n" +
                    "              \"width\": 7360,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJjRuIiTiuEmsRCHhYnrWiSok\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+XM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+XM\",\n" +
                    "          },\n" +
                    "        \"rating\": 4.1,\n" +
                    "        \"reference\": \"ChIJjRuIiTiuEmsRCHhYnrWiSok\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 119,\n" +
                    "        \"vicinity\": \"32 The Promenade, King Street Wharf, 5, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8677035, \"lng\": 151.2017297 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86634597010728, \"lng\": 151.2031781298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86904562989272, \"lng\": 151.2004784701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Magistic Cruises\",\n" +
                    "        \"opening_hours\": { \"open_now\": true },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 1536,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/103073818292552522030\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEC8bq-YphfIDcdxANBfgGMBIX2B0ggNep9ddVoePj6sfdcdusIn07x8biaxevZ_6BpzDDRsUL8No5P3ftI4on_pqbAbIEUL5gFGgezpVZ3M9GWvKdJm3njO_aJaghWl4_aQb75c0WGYDRFPhn6fWsLkD7KxodviJeCX4OCGt1eRJnlK\",\n" +
                    "              \"width\": 2048,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJxRjqYTiuEmsRGebAA_chDLE\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+WM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+WM\",\n" +
                    "          },\n" +
                    "        \"rating\": 3.9,\n" +
                    "        \"reference\": \"ChIJxRjqYTiuEmsRGebAA_chDLE\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"tourist_attraction\",\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 99,\n" +
                    "        \"vicinity\": \"King Street Wharf, 32 The Promenade, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8609391, \"lng\": 151.2098735 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.85958927010727, \"lng\": 151.2112233298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86228892989272, \"lng\": 151.2085236701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Australian Cruise Group\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 1536,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/113088009011192061895\">Keith Bauman</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uED7aBwIbN6iuoZi8e9xCrt6F_EhppGCBfzYCgypetw8cGn4Ui0Y3JZe3QJ0buf0zc54BtPz-SWXxecPd6kDvNNZD5Eu_ZzTP13rXMzSDJa6UcwFiXU4y3qYrWAyJ6mtYrd2PJgw0KzvYaZoPze7Ka6zG6k3IOjeSICDYH6YOzkXhelj\",\n" +
                    "              \"width\": 2048,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJpU8KgUKuEmsRKErVGEaa11w\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46Q5+JW Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46Q5+JW\",\n" +
                    "          },\n" +
                    "        \"rating\": 4.4,\n" +
                    "        \"reference\": \"ChIJpU8KgUKuEmsRKErVGEaa11w\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 5,\n" +
                    "        \"vicinity\": \"6 Cirular Quay, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8686058, \"lng\": 151.2018206 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86730002010728, \"lng\": 151.2032717798927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86999967989272, \"lng\": 151.2005721201073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Rhythmboat Cruises\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 2269,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/104066891898402903288\">Rhythmboat Sydney Harbour Cruises</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEAT8eop-IsfSAQ3KP6YXRNRsFkESXDecsaPnaVhq5bZzny5guvhS4smciianRGbZgDtFtAcU-ZXTaBfuh80CFw8vpJyKaB4grgW_CW64rU1JF9FDy_M8HtEk3rOrMhPDiF8ns-mc16E4rWSuAQIc76Du_eCd63ofoErESOtSWAQVcew\",\n" +
                    "              \"width\": 4032,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJyWEHuEmuEmsRm9hTkapTCrk\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+HP Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+HP\",\n" +
                    "          },\n" +
                    "        \"rating\": 3.9,\n" +
                    "        \"reference\": \"ChIJyWEHuEmuEmsRm9hTkapTCrk\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 30,\n" +
                    "        \"vicinity\": \"King Street Wharf, King St, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8712692, \"lng\": 151.1898651 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86952792010727, \"lng\": 151.1914560298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.87222757989272, \"lng\": 151.1887563701073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Glass Island\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 4480,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/117745044320706972021\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEAaToCBaHP7Gfdjc740gwIkQcjeUD97NO0TKXJ5IXB0CLGQA6slEpHn4k9LwyhoAzzbSTXJduYyFIkHVmQWGp34NggRxrtOWp7sJf5N6j0ASYlJPmAtWUaaCWnbx_pxdndsopeJ7PYn9kTiMgFcSs-GeipI8hDZgAJswMBnfsO0xWQ-\",\n" +
                    "              \"width\": 6720,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJnScuboavEmsRyh-FGxhc3pw\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"45HQ+FW Pyrmont, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH45HQ+FW\",\n" +
                    "          },\n" +
                    "        \"rating\": 4.1,\n" +
                    "        \"reference\": \"ChIJnScuboavEmsRyh-FGxhc3pw\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\"bar\", \"restaurant\", \"food\", \"point_of_interest\", \"establishment\"],\n" +
                    "        \"user_ratings_total\": 90,\n" +
                    "        \"vicinity\": \"37 Bank St, Pyrmont\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.85876140000001, \"lng\": 151.2100004 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.85737742010728, \"lng\": 151.2111319298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86007707989272, \"lng\": 151.2084322701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png\",\n" +
                    "        \"icon_background_color\": \"#FF9E67\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet\",\n" +
                    "        \"name\": \"Junk Lounge\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 608,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/104473997089847488714\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEDaHF9VZFV88tQqFyIgmPlcbCsK-ScCGuUVGh0mTAP4OzWh_0q0T5rPbeC7bas7vD5vC9oS95jtdr4oOnQmhGDAIbHkv4E6UHrQIl0f3XZ-3-RRDjn293w4qQb_BfhbPPO3nokU7npfMfVvCcelWf9WHiWNHT4EEHrFtvuhAWKobTnC\",\n" +
                    "              \"width\": 1080,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJq9W3HZOvEmsRYtKNTRmq34M\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46R6+F2 The Rocks, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46R6+F2\",\n" +
                    "          },\n" +
                    "        \"price_level\": 2,\n" +
                    "        \"rating\": 4.1,\n" +
                    "        \"reference\": \"ChIJq9W3HZOvEmsRYtKNTRmq34M\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\": [\"restaurant\", \"food\", \"point_of_interest\", \"establishment\"],\n" +
                    "        \"user_ratings_total\": 63,\n" +
                    "        \"vicinity\": \"Level 2, Overseas Passenger Terminal, Circular Quay W, The Rocks\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8677035, \"lng\": 151.2017297 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86634597010728, \"lng\": 151.2031781298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86904562989272, \"lng\": 151.2004784701072 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#7B9EB0\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"Sydney New Year's Eve Cruises\",\n" +
                    "        \"opening_hours\": { \"open_now\": true },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 1600,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/115281801304517408477\">A Google User</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEDceKHtQ9Hf2eHwnQYXLqrwZ1X2LYVhsfXbqrpIm3_lXZ9apURjAXtVgRVTGxJPD7BtaqR8C7bwaSTakmi0Pazn7g3suj8ZaQRBqheT3KVJDhZ9_GwVInLkWbxqnhivEXs1a-MC_J8XF1SL_5AQ3mAETgiLRQ04116IAEV5vHyIGRsa\",\n" +
                    "              \"width\": 2400,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJ__8_hziuEmsR27ucFXECfOg\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46J2+WM Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46J2+WM\",\n" +
                    "          },\n" +
                    "        \"rating\": 5,\n" +
                    "        \"reference\": \"ChIJ__8_hziuEmsR27ucFXECfOg\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"travel_agency\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 5,\n" +
                    "        \"vicinity\": \"King Street Wharf 5, 32 The Promenade, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.8669866, \"lng\": 151.2017231 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86563197010727, \"lng\": 151.2031347298927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.86833162989272, \"lng\": 151.2004350701073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                    "        \"icon_background_color\": \"#13B5C7\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\n" +
                    "        \"name\": \"King Street Wharf Darling Harbour\",\n" +
                    "        \"opening_hours\": { \"open_now\": true },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 3024,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/101920674986627213698\">朱品貞</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEDwKXVOjIaCj3LptOdd86B5umsdG7Z3jcvqcpUVLwHS6w8VGEkphgC8-shAx95CrsuXpnKz-XVIixVmgagQHKPH3vSLLqJ6LOAR7Q-_jiyx3ELXD0pm7AARiAtQAMBN9A-oqbtvGbE27yDpvBS1lKe9PCm-dMfrHIIcsS91Qeq2E4b6\",\n" +
                    "              \"width\": 4032,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJkfDzJ72vEmsR8xtYbk5f0p0\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"46M2+6M Sydney, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH46M2+6M\",\n" +
                    "          },\n" +
                    "        \"rating\": 4.4,\n" +
                    "        \"reference\": \"ChIJkfDzJ72vEmsR8xtYbk5f0p0\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\":\n" +
                    "          [\n" +
                    "            \"tourist_attraction\",\n" +
                    "            \"convenience_store\",\n" +
                    "            \"bowling_alley\",\n" +
                    "            \"travel_agency\",\n" +
                    "            \"bar\",\n" +
                    "            \"restaurant\",\n" +
                    "            \"food\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"store\",\n" +
                    "            \"establishment\",\n" +
                    "          ],\n" +
                    "        \"user_ratings_total\": 3213,\n" +
                    "        \"vicinity\": \"The Promenade, Lime St, Sydney\",\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"business_status\": \"OPERATIONAL\",\n" +
                    "        \"geometry\":\n" +
                    "          {\n" +
                    "            \"location\": { \"lat\": -33.870383, \"lng\": 151.1979245 },\n" +
                    "            \"viewport\":\n" +
                    "              {\n" +
                    "                \"northeast\":\n" +
                    "                  { \"lat\": -33.86901092010727, \"lng\": 151.1991702798927 },\n" +
                    "                \"southwest\":\n" +
                    "                  { \"lat\": -33.87171057989271, \"lng\": 151.1964706201073 },\n" +
                    "              },\n" +
                    "          },\n" +
                    "        \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png\",\n" +
                    "        \"icon_background_color\": \"#FF9E67\",\n" +
                    "        \"icon_mask_base_uri\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet\",\n" +
                    "        \"name\": \"The Little Snail Restaurant\",\n" +
                    "        \"opening_hours\": { \"open_now\": false },\n" +
                    "        \"photos\":\n" +
                    "          [\n" +
                    "            {\n" +
                    "              \"height\": 900,\n" +
                    "              \"html_attributions\":\n" +
                    "                [\n" +
                    "                  '<a href=\"https://maps.google.com/maps/contrib/114727320476039103791\">The Little Snail</a>',\n" +
                    "                ],\n" +
                    "              \"photo_reference\": \"Aap_uEA9aHKkB_6VoFx4VHRSp19PCwnTOuGfpmDYw1NdYNbzncfdjjfEmiiFz-E4tIJ6iGVZjR_bejX6wNr5thJjqlcdQ2PvPyTTo1jGtxk31JG9b6Vd0vu_v4Ep7yutzf3KTzBjYFBIGsYPf3Pj0DptMWPLP7fn33SBT7YmRqDEoGcUsBzw\",\n" +
                    "              \"width\": 1350,\n" +
                    "            },\n" +
                    "          ],\n" +
                    "        \"place_id\": \"ChIJtwapWjeuEmsRcxV5JARHpSk\",\n" +
                    "        \"plus_code\":\n" +
                    "          {\n" +
                    "            \"compound_code\": \"45HX+R5 Pyrmont, New South Wales\",\n" +
                    "            \"global_code\": \"4RRH45HX+R5\",\n" +
                    "          },\n" +
                    "        \"price_level\": 2,\n" +
                    "        \"rating\": 4.5,\n" +
                    "        \"reference\": \"ChIJtwapWjeuEmsRcxV5JARHpSk\",\n" +
                    "        \"scope\": \"GOOGLE\",\n" +
                    "        \"types\": [\"restaurant\", \"food\", \"point_of_interest\", \"establishment\"],\n" +
                    "        \"user_ratings_total\": 1916,\n" +
                    "        \"vicinity\": \"3/50 Murray St, Pyrmont\",\n" +
                    "      },\n" +
                    "    ],\n" +
                    "  \"status\": \"OK\",\n" +
                    "}";
        }


        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i=0; i<jsonArray.length(); i++){

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONObject getLocation = jsonObject1.getJSONObject("geometry").getJSONObject("location");

                JSONObject getName = jsonArray.getJSONObject(i);
               //coordinates
                Double lat = getLocation.getDouble("lat");;
                Double lng =  getLocation.getDouble("lng");
                latlong.add(new LatLng(lat,lng));
                String name = getName.getString("name");
                names.add(name);
                Boolean status = getName.getJSONObject("opening_hours").getBoolean("open_now");
                openOrNot.add(status);
                int rating = getName.getInt("rating");
                Rating.add(rating);
                int totaluserrating = getName.getInt("user_ratings_total");
                total_user_rating.add(totaluserrating);
                String addr = getName.getString("vicinity");
                address.add(addr);
                JSONArray imagearray = jsonObject1.getJSONArray("photos");

                for(int k=0; k<imagearray.length(); k++){
                    JSONObject jsonObject2 = imagearray.getJSONObject(k);
                    String url = jsonObject2.getString("photo_reference");
                    System.out.println(url);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("error_response", "onPostExecute: "+e.toString());
        }
       // adding sample data to list


        names.add("poras");
        address.add("1768 shakti nagar");
        Rating.add(5);
        total_user_rating.add(450);
        openOrNot.add(true);

        Intent i = new Intent(context,PlaceViewer.class);
        i.putExtra("names",names);
        context.startActivity(i);


    }

    public ArrayList<String> getNames(){
        return names;
    }
    public ArrayList<String> getAddress(){
        return address;
    }
    public ArrayList<Integer> getRating(){
        return Rating;
    }
    public ArrayList<Integer> getTotal_user_rating(){
        return total_user_rating;
    }
    public ArrayList<LatLng> getLatlong(){
        return latlong;
    }
    public ArrayList<Boolean> getOpenOrNot(){
        return openOrNot;
    }
}
