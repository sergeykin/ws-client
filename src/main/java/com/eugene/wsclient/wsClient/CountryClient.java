package com.eugene.wsclient.wsClient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsdl.*;

import java.util.List;

public class CountryClient extends WebServiceGatewaySupport {

    private static final String NAMESPACE = "http://eugene.com/wsdemo/domain/";

    public List<Country> getAllCountries() {

        GetAllCountriesResponse response =
                (GetAllCountriesResponse) marshalSendAndReceive(new GetAllCountriesRequest(), "getAllCountries");

        return response.getCountry();
    }

    public Country createCountry(Country country) {
        CreateCountryRequest request = new CreateCountryRequest();
        request.setCountry(country);

        GetCountryResponse response =
                (GetCountryResponse) marshalSendAndReceive(request, "createCountry");

        return response.getCountry();
    }

    public Country getCountryByName(String name) {
        GetCountryByNameRequest request = new GetCountryByNameRequest();
        request.setName(name);

        GetCountryResponse response =
                (GetCountryResponse) marshalSendAndReceive(request, "getCountryByName");

        return response.getCountry();
    }

    public void deleteCountry(Long id) {
        DeleteCountryRequest request = new DeleteCountryRequest();
        request.setId(id);
        marshalSendAndReceive(request, "deleteCountry");
    }

    public Country updateCountry(Country country) {
        UpdateCountryRequest request = new UpdateCountryRequest();
        request.setCountry(country);
        GetCountryResponse response = (GetCountryResponse) marshalSendAndReceive(request, "updateCountry");
        return response.getCountry();
    }

    private Object marshalSendAndReceive(Object request, String endpointName) {
        return getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(NAMESPACE + endpointName));
    }

}
