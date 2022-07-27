package com.things.customer.xcitycustomerskb.pega.restcontroller;


import com.things.customer.xcitycustomerskb.pega.response.wrapperresponse.WrapperResponse;
import com.things.customer.xcitycustomerskb.pega.services.WrapperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class WrapperController {
    //TODO start with /free/ --> so wont go thru security
    private static final String GAAP = "free/pega" ;
    private final WrapperService WrapperService;

    public WrapperController(WrapperService WrapperService) {
        this.WrapperService = WrapperService;
    }


    @PostMapping(path = GAAP)
    public ResponseEntity<WrapperResponse> getWrapperMoviesUsingPOST(@Valid @RequestBody String stringRequestFromPostman){
    return WrapperService.getWrapperMovies(stringRequestFromPostman);
    }
}
