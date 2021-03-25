package geocoding;

import connection.ISimpleHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock ISimpleHttpClient HTTPClient;

    @InjectMocks AddressResolver addressResolver;


    @Test
    void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException {

        String r = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2020 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2020 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Cais do Alboi\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3800-246\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-563893378\",\"roadMetadata\":null}]}]}";
        when(HTTPClient.get(anyString())).thenReturn(r);


        Address result = addressResolver.findAddressForLocation(40.640661, -8.656688);


        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

    }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {

        String r = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2020 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2020 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":35.765,\"lng\":-7.2743}},\"locations\":[]}]}";
        when(HTTPClient.get(anyString())).thenReturn(r);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            addressResolver.findAddressForLocation(40.1453, -7.1916);

        });
    }
}