package com.example.basurapk;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class mapa extends FragmentActivity implements OnMapReadyCallback {
    SupportMapFragment mapFrag;
    private GoogleMap mMap;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int status= GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if(status == ConnectionResult.SUCCESS){


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        }else{

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }







    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                mMap.setMyLocationEnabled(true);
            }
        } else {

            mMap.setMyLocationEnabled(true);



}

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);




        LatLng ContenedorI = new LatLng(17.961532, -102.196813);
        mMap.addMarker(new MarkerOptions().position(ContenedorI).title("PALACIO MUNICIPAL INICIO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        float zoomlevelR2=14;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ContenedorI,zoomlevelR2));



        //Ingresar rutas


    ruta9();
    contenedorRuta9();


    ruta11();
    ruta10();


    }


    public void ruta9(){
        Polyline r9 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.956919, -102.194146), new LatLng(17.956550, -102.192714 ))
                .add(new LatLng(17.956550, -102.192714), new LatLng(17.955735, -102.189651 ))
                .add(new LatLng(17.955735, -102.189651), new LatLng(17.955513, -102.188605 ))
                .add(new LatLng(17.955513, -102.188605), new LatLng(17.956054, -102.188506 ))
                .add(new LatLng(17.956054, -102.188506), new LatLng(17.956526, -102.190123 ))
                .add(new LatLng(17.956526, -102.190123), new LatLng(17.957439, -102.193476 ))
                .add(new LatLng(17.957439, -102.193476), new LatLng(17.957938, -102.192789 ))
                .add(new LatLng(17.957938, -102.192789), new LatLng(17.957637, -102.191685 ))
                .add(new LatLng(17.957637, -102.191685), new LatLng(17.957134, -102.189976 ))
                .add(new LatLng(17.957134, -102.189976), new LatLng(17.956973, -102.189295 ))
                .add(new LatLng(17.956973, -102.189295), new LatLng(17.956700, -102.188318 ))
                .add(new LatLng(17.956700, -102.188318), new LatLng(17.956983, -102.188238 ))
                .add(new LatLng(17.956983, -102.188238), new LatLng(17.957394, -102.188235 ))
                .add(new LatLng(17.957394, -102.188235), new LatLng(17.957738, -102.189783 ))
                .add(new LatLng(17.957738, -102.189783), new LatLng(17.958363, -102.192119 ))
                .add(new LatLng(17.958563, -102.191907), new LatLng(17.963603, -102.195843 ))
                .add(new LatLng(17.963455, -102.194814), new LatLng(17.958974, -102.191333 ))
                 .width(15)
                .color(Color.GREEN));


        Polyline r91 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.963679, -102.196993), new LatLng(17.958085, -102.192636 ))
                .width(15)
                .color(Color.GREEN));

        Polyline r92 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.959296, -102.194395), new LatLng(17.957713, -102.193160 ))
                .width(15)
                .color(Color.GREEN));

        Polyline r93 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.958877, -102.194997), new LatLng(17.957301, -102.193735 ))
                .width(15)
                .color(Color.GREEN));

        Polyline r94 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.963204, -102.197816), new LatLng(17.959137, -102.194711 ))
                .width(15)
                .color(Color.GREEN));

    }


    public void ruta10(){
       Polyline r10 = mMap.addPolyline(new PolylineOptions()
               .add(new LatLng(17.962845, -102.199289), new LatLng(17.962445, -102.198956 ))
               .add(new LatLng(17.962445, -102.198956), new LatLng(17.962195, -102.198735 ))
               .add(new LatLng(17.962195, -102.198735), new LatLng(17.962145, -102.198687 ))
               .add(new LatLng(17.962145, -102.198687), new LatLng(17.959746, -102.196780 ))
               .add(new LatLng(17.959746, -102.196780), new LatLng(17.958396, -102.195735 ))
               .add(new LatLng(17.958396, -102.195735), new LatLng(17.957624, -102.195109 ))
               .add(new LatLng(17.957624, -102.195109), new LatLng(17.956744, -102.194444 ))
               .add(new LatLng(17.956744, -102.194444), new LatLng(17.955681, -102.193655 ))
               .add(new LatLng(17.955681, -102.193655), new LatLng(17.955597, -102.193603 ))
               .add(new LatLng(17.955597, -102.193603), new LatLng(17.954506, -102.192782 ))
               .add(new LatLng(17.954506, -102.192782), new LatLng(17.954029, -102.192355 ))
               .add(new LatLng(17.954029, -102.192355), new LatLng(17.954029, -102.192355 ))
               .add(new LatLng(17.954029, -102.192355), new LatLng(17.953670, -102.192112 ))
               .add(new LatLng(17.953670, -102.192112), new LatLng(17.951674, -102.190537 ))


               //Venustiano Carranza
               .add(new LatLng(17.951674, -102.190537), new LatLng(17.951719, -102.190867 ))
               .add(new LatLng(17.951719, -102.190867), new LatLng(17.951786, -102.191013 ))
               .add(new LatLng(17.951786, -102.191013), new LatLng(17.952035, -102.192154 ))
               .add(new LatLng(17.952035, -102.192154), new LatLng(17.952118, -102.193028 ))
               .add(new LatLng(17.952118, -102.193028), new LatLng(17.952040, -102.193786 ))
               .add(new LatLng(17.952040, -102.193786), new LatLng(17.952016, -102.194713 ))
               .add(new LatLng(17.952016, -102.194713), new LatLng(17.952042, -102.195368 ))


               //Rector Hidalgo
               .add(new LatLng(17.952042, -102.195368), new LatLng(17.952503, -102.195725 ))
               .add(new LatLng(17.952503, -102.195725), new LatLng(17.953030, -102.196137 ))
               .add(new LatLng(17.953030, -102.196137), new LatLng(17.953556, -102.196529 ))
               .add(new LatLng(17.953556, -102.196529), new LatLng(17.953919, -102.196835 ))
               .add(new LatLng(17.953919, -102.196835), new LatLng(17.954197, -102.197017 ))
               .add(new LatLng(17.954197, -102.197017), new LatLng(17.954647, -102.197354 ))
               .add(new LatLng(17.954647, -102.197354), new LatLng(17.955202, -102.197801 ))
               .add(new LatLng(17.955202, -102.197801), new LatLng(17.956285, -102.198639 ))
               .add(new LatLng(17.956285, -102.198639), new LatLng(17.957214, -102.199357 ))
               .add(new LatLng(17.957214, -102.199357), new LatLng(17.959250, -102.200915 ))
               .add(new LatLng(17.959250, -102.200915), new LatLng(17.960444, -102.201845 ))

       //Heroica naval

               .add(new LatLng(17.960444, -102.201845), new LatLng(17.961891, -102.199846 ))
               .add(new LatLng(17.961891, -102.199846), new LatLng(17.962462, -102.198981 ))
               .width(15)
               .color(Color.RED));

       //Constitucion


        Polyline r101 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.953713, -102.192151), new LatLng(17.953203, -102.193083 ))
                .add(new LatLng(17.953203, -102.193083), new LatLng(17.953203, -102.193083 ))
                .add(new LatLng(17.953203, -102.193083), new LatLng(17.952917, -102.193738 ))
                .add(new LatLng(17.952917, -102.193738), new LatLng(17.952596, -102.194273 ))
                .add(new LatLng(17.952596, -102.194273), new LatLng(17.952046, -102.195367 ))
                .width(15)
                .color(Color.RED));

        //Francisco y Madero


        Polyline r102 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.952209, -102.190947), new LatLng(17.952629, -102.192468 ))
                .add(new LatLng(17.952629, -102.192468), new LatLng(17.952791, -102.192775 ))
                .add(new LatLng(17.952791, -102.192775), new LatLng(17.953202, -102.193083 ))
                .add(new LatLng(17.953202, -102.193083), new LatLng(17.953925, -102.193670 ))
                .add(new LatLng(17.953925, -102.193670), new LatLng(17.954472, -102.194068 ))
                .add(new LatLng(17.954472, -102.194068), new LatLng(17.955651, -102.194979 ))
                .add(new LatLng(17.955651, -102.194979), new LatLng(17.957771, -102.196589 ))
                .add(new LatLng(17.957771, -102.196589), new LatLng(17.957723, -102.196676 ))
                .add(new LatLng(17.957723, -102.196676), new LatLng(17.961252, -102.199422 ))
                .add(new LatLng(17.961252, -102.199422), new LatLng(17.959845, -102.201364 ))

                .width(15)
                .color(Color.RED));

        //Venustiano Carranza

        Polyline r103 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.952039, -102.193813), new LatLng(17.952603, -102.194273 ))
                .add(new LatLng(17.952603, -102.194273), new LatLng(17.954241, -102.195526 ))
                .add(new LatLng(17.954241, -102.195526), new LatLng(17.954881, -102.196060 ))
                .add(new LatLng(17.954881, -102.196060), new LatLng(17.955301, -102.196379 ))
                .add(new LatLng(17.955301, -102.196379), new LatLng(17.956161, -102.197106 ))
                .add(new LatLng(17.956161, -102.197106), new LatLng(17.957869, -102.198462 ))
                .add(new LatLng(17.957869, -102.198462), new LatLng(17.957929, -102.198382 ))
                .add(new LatLng(17.957929, -102.198382), new LatLng(17.958353, -102.198731 ))
                .add(new LatLng(17.958353, -102.198731), new LatLng(17.960528, -102.200422 ))

                .width(15)
                .color(Color.RED));


        //Francisco Villa
        Polyline r104 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.952925, -102.193742), new LatLng(17.953537, -102.194216 ))
                .add(new LatLng(17.953537, -102.194216), new LatLng(17.954227, -102.194728 ))
                .add(new LatLng(17.954227, -102.194728), new LatLng(17.954608, -102.195037 ))
                .add(new LatLng(17.954608, -102.195037), new LatLng(17.955272, -102.195512 ))
                .add(new LatLng(17.955272, -102.195512), new LatLng(17.956574, -102.196572 ))
                .add(new LatLng(17.956574, -102.196572), new LatLng(17.957013, -102.196032 ))

                .width(15)
                .color(Color.RED));

        //Verdusco
        Polyline r105 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.958621, -102.197392), new LatLng(17.957216, -102.199364 ))

                .width(15)
                .color(Color.RED));

        //Benito Juarez


        Polyline r106 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.956151, -102.193810), new LatLng(17.954818, -102.188857 ))

                .width(15)
                .color(Color.RED));

        //Guillermo Prieto
        Polyline r107 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.954365, -102.188917), new LatLng(17.955080, -102.191664 ))
                .add(new LatLng(17.955080, -102.191664), new LatLng(17.955477, -102.193280 ))
                .width(15)
                .color(Color.RED));

        //Ignacio Zaragosa

        Polyline r108 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.953739, -102.189114), new LatLng(17.954046, -102.190189 ))
                .add(new LatLng(17.954046, -102.190189), new LatLng(17.954437, -102.191844 ))
                .add(new LatLng(17.954437, -102.191844), new LatLng(17.954650, -102.192522 ))
                .width(15)
                .color(Color.RED));

        //Melchor Ocampo

        Polyline r109 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.953125, -102.189188), new LatLng(17.953780, -102.192000 ))
                .width(15)
                .color(Color.RED));

        //Lerdo de Tejada
        Polyline r110 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.953527, -102.190956), new LatLng(17.953057, -102.191138 ))
                .add(new LatLng(17.953057, -102.191138), new LatLng(17.952751, -102.191225 ))
                .width(15)
                .color(Color.RED));


        // Ignacio Comfort
        Polyline r111 = mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(17.953399, -102.190341), new LatLng(17.952111, -102.190743 ))
                .width(15)
                .color(Color.RED));




    }


    public void ruta11(){
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.962718, -102.190656), new LatLng(17.960490, -102.189021))
                .add(new LatLng(17.960490, -102.189021), new LatLng(17.960329, -102.189042))
                .add(new LatLng(17.960329, -102.189042), new LatLng(17.959451, -102.189310))
                .add(new LatLng(17.959451, -102.189310), new LatLng(17.959510, -102.188374))
                .add(new LatLng(17.959510, -102.188374), new LatLng(17.962187, -102.188422))
                .add(new LatLng(17.962187, -102.188422), new LatLng(17.962373, -102.188494))
                .add(new LatLng(17.962373, -102.188494), new LatLng(17.962531, -102.188692))
                .add(new LatLng(17.962531, -102.188692), new LatLng(17.962631, -102.189588))
                .add(new LatLng(17.962631, -102.189588), new LatLng(17.962764, -102.189797))
                .add(new LatLng(17.962764, -102.189797), new LatLng(17.963874, -102.196855))
                .add(new LatLng(17.963874, -102.196855), new LatLng(17.963782, -102.197220))
                .add(new LatLng(17.963782, -102.197220), new LatLng(17.963333, -102.197939))
                .add(new LatLng(17.963333, -102.197939), new LatLng(17.963593, -102.198053))
                .add(new LatLng(17.963593, -102.198053), new LatLng(17.964996, -102.197954))
                .add(new LatLng(17.964996, -102.197954), new LatLng(17.965488, -102.198753))
                .add(new LatLng(17.965488, -102.198753), new LatLng(17.965572, -102.199179))
                .add(new LatLng(17.965572, -102.199179), new LatLng(17.965483, -102.199624))
                .add(new LatLng(17.965483, -102.199624), new LatLng(17.965266, -102.200241))
                .add(new LatLng(17.965266, -102.200241), new LatLng(17.965228, -102.200869))
                .add(new LatLng(17.965228, -102.200869), new LatLng(17.966894, -102.202167))
                .add(new LatLng(17.966894, -102.202167), new LatLng(17.967501, -102.202577))
                .add(new LatLng(17.967501, -102.202577), new LatLng(17.967879, -102.202188))
                .add(new LatLng(17.967879, -102.202188), new LatLng(17.968707, -102.201113))
                .add(new LatLng(17.968707, -102.201113), new LatLng(17.969853, -102.199702))
                .add(new LatLng(17.969853, -102.199702), new LatLng(17.969108, -102.199128))
                .add(new LatLng(17.969108, -102.199128), new LatLng(17.969011, -102.198924))
                .add(new LatLng(17.969011, -102.198924), new LatLng(17.967296, -102.198586))


                .width(10)
                .color(Color.BLUE));

        Polyline r111 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.959389, -102.190786), new LatLng(17.963240, -102.193743))
                .width(15)
                .color(Color.BLUE));

        Polyline r112 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.963067, -102.192724), new LatLng(17.959777, -102.190210))
                .width(15)
                .color(Color.BLUE));

        Polyline r113 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.960236, -102.189620), new LatLng(17.962899, -102.191691))
                .width(15)
                .color(Color.BLUE));

        Polyline r114 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.966440, -102.201223), new LatLng(17.966483, -102.201086))
                .add(new LatLng(17.966483, -102.201086), new LatLng(17.966557, -102.201046))
                .add(new LatLng(17.966557, -102.201046), new LatLng(17.966845, -102.200888))
                .add(new LatLng(17.966845, -102.200888), new LatLng(17.966904, -102.200698))
                .add(new LatLng(17.966904, -102.200698), new LatLng(17.967384, -102.197961))
                .add(new LatLng(17.967384, -102.197961), new LatLng(17.966960, -102.195901))
                .add(new LatLng(17.966960, -102.195901), new LatLng(17.966468, -102.195929))

                .width(15)
                .color(Color.BLUE));



        Polyline r115 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.967371, -102.197991), new LatLng(17.966958, -102.197902))
                .add(new LatLng(17.966958, -102.197902), new LatLng(17.964779, -102.197964))
                .add(new LatLng(17.964779, -102.197964), new LatLng(17.964907, -102.197618))
                .add(new LatLng(17.964907, -102.197618), new LatLng(17.964985, -102.196955))
                .add(new LatLng(17.964985, -102.196955), new LatLng(17.965194, -102.196097))
                .add(new LatLng(17.965194, -102.196097), new LatLng(17.965344, -102.190232))
                .add(new LatLng(17.965344, -102.190232), new LatLng(17.965331, -102.190004))
                .add(new LatLng(17.965331, -102.190004), new LatLng(17.965277, -102.189789))
                .add(new LatLng(17.965277, -102.189789), new LatLng(17.965116, -102.189440))
                .add(new LatLng(17.965116, -102.189440), new LatLng(17.964825, -102.189113))
                .add(new LatLng(17.964825, -102.189113), new LatLng(17.964427, -102.188893))
                .add(new LatLng(17.964427, -102.188893), new LatLng(17.964100, -102.188842))
                .add(new LatLng(17.964100, -102.188842), new LatLng(17.963698, -102.188839))
                .add(new LatLng(17.963698, -102.188839), new LatLng(17.963167, -102.189064))
                .add(new LatLng(17.963167, -102.189064), new LatLng(17.962884, -102.189410))
                .add(new LatLng(17.962884, -102.189410), new LatLng(17.962744, -102.189740))

                .width(15)
                .color(Color.BLUE));

        Polyline r116 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.967107, -102.196578), new LatLng(17.967367, -102.196481))
                .add(new LatLng(17.967367, -102.196481), new LatLng(17.967594, -102.196520))
                .add(new LatLng(17.967594, -102.196520), new LatLng(17.969321, -102.197512))
                .width(15)
                .color(Color.BLUE));

        Polyline r117 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.959389, -102.190786), new LatLng(17.963240, -102.193743))
                .width(15)
                .color(Color.BLUE));

        Polyline r1178 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.965272, -102.193854), new LatLng(17.964706, -102.193929))
                .add(new LatLng(17.964706, -102.193929), new LatLng(17.964520, -102.193890))
                .add(new LatLng(17.964520, -102.193890), new LatLng(17.964298, -102.193917))
                .add(new LatLng(17.964298, -102.193917), new LatLng(17.963961, -102.194102))
                .add(new LatLng(17.963961, -102.194102), new LatLng(17.963468, -102.194182))

                .width(15)
                .color(Color.BLUE));


        Polyline r119 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.965241, -102.195739), new LatLng(17.964759, -102.195821))
                .add(new LatLng(17.964759, -102.195821), new LatLng(17.964610, -102.195829))
                .add(new LatLng(17.964610, -102.195829), new LatLng(17.964237, -102.195799))
                .add(new LatLng(17.964237, -102.195799), new LatLng(17.963728, -102.195856))
                .width(15)
                .color(Color.BLUE));


        Polyline r1110 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(17.963038, -102.191707), new LatLng(17.964509, -102.191410))
                .add(new LatLng(17.964509, -102.191410), new LatLng(17.964488, -102.191265))
                .add(new LatLng(17.964488, -102.191265), new LatLng(17.964788, -102.191212))
                .width(15)
                .color(Color.BLUE));

    }

    public void contenedorRuta9(){

        LatLng Contenedor1 = new LatLng(17.953134, -102.195945);
        mMap.addMarker(new MarkerOptions().position(Contenedor1).title("Ruta 9 Contenedor #067 ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cont_red)).anchor(0.0f, 1.0f));

        LatLng Contenedor2 = new LatLng(17.953732, -102.196682);
        mMap.addMarker(new MarkerOptions().position(Contenedor2).title("Ruta 9 Contenedor #079 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor3 = new LatLng(17.956762, -102.195811);
        mMap.addMarker(new MarkerOptions().position(Contenedor3).title("Ruta 9 Contenedor #077 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor4 = new LatLng(17.955960, -102.195267);
        mMap.addMarker(new MarkerOptions().position(Contenedor4).title("Ruta 9 Contenedor #074 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor5 = new LatLng(17.955543, -102.194870);
        mMap.addMarker(new MarkerOptions().position(Contenedor5).title("Ruta 9 Contenedor #073 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor6 = new LatLng(170954535, -102.194095);
        mMap.addMarker(new MarkerOptions().position(Contenedor6).title("Ruta 9 Contenedor #069 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor7 = new LatLng(17.953593, -102.193411);
        mMap.addMarker(new MarkerOptions().position(Contenedor7).title("Ruta 9 Contenedor #065 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor8 = new LatLng(17.952636, -102.192239);
        mMap.addMarker(new MarkerOptions().position(Contenedor8).title("Ruta 9 Contenedor #064 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor9 = new LatLng(17.953101, -102.194686);
        mMap.addMarker(new MarkerOptions().position(Contenedor9).title("Ruta 9 Contenedor #066 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor10 = new LatLng(17.954333, -102.195541);
        mMap.addMarker(new MarkerOptions().position(Contenedor10).title("Ruta 9 Contenedor # ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor11 = new LatLng(17.954925, -102.196123);
        mMap.addMarker(new MarkerOptions().position(Contenedor11).title("Ruta 9 Contenedor #072 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor12 = new LatLng(17.955387, -102.196398);
        mMap.addMarker(new MarkerOptions().position(Contenedor12).title("Ruta 9 Contenedor #075 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor13 = new LatLng(17.956267, -102.197105);
        mMap.addMarker(new MarkerOptions().position(Contenedor13).title("Ruta 9 Contenedor #076 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor14 = new LatLng(17.956820, -102.197662);
        mMap.addMarker(new MarkerOptions().position(Contenedor14).title("Ruta 9 Contenedor #078 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor15 = new LatLng(17.958006, -102.198510);
        mMap.addMarker(new MarkerOptions().position(Contenedor15).title("Ruta 9 Contenedor #080 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor16 = new LatLng(17.958318, -102.198616);
        mMap.addMarker(new MarkerOptions().position(Contenedor16).title("Ruta 9 Contenedor #082 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor17 = new LatLng(17.958802, -102.199022);
        mMap.addMarker(new MarkerOptions().position(Contenedor17).title("Ruta 9 Contenedor #083 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor18 = new LatLng(17.959235, -102.199353);
        mMap.addMarker(new MarkerOptions().position(Contenedor18).title("Ruta 9 Contenedor #084 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor19 = new LatLng(17.959807, -102.199789);
        mMap.addMarker(new MarkerOptions().position(Contenedor19).title("Ruta 9 Contenedor #085 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor20 = new LatLng(17.960363, -102.200586);
        mMap.addMarker(new MarkerOptions().position(Contenedor20).title("Ruta 9 Contenedor #086 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng Contenedor21 = new LatLng(17.960694, -102.200234);
        mMap.addMarker(new MarkerOptions().position(Contenedor21).title("Ruta 9 Contenedor # ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //  TODO: Prompt with explanation!

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay!
                    if (ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

        }
    }

    }



