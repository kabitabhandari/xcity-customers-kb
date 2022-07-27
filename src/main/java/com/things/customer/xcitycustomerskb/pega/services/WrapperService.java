package com.things.customer.xcitycustomerskb.pega.services;

import com.things.customer.xcitycustomerskb.pega.response.wrapperresponse.WrapperResponse;
import com.things.customer.xcitycustomerskb.pega.provider.WrapperProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class WrapperService {
    private final WrapperProvider wrapperProvider;

    public WrapperService(WrapperProvider wrapperProvider) {
        this.wrapperProvider = wrapperProvider;
    }


    public ResponseEntity<WrapperResponse> getWrapperMovies(@Valid @RequestBody String stringRequestFromPostman) {
        WrapperResponse wrapperResponse = wrapperProvider.getMovies(stringRequestFromPostman);
        return ResponseEntity.status(HttpStatus.CREATED).body(wrapperResponse);
    }

}
