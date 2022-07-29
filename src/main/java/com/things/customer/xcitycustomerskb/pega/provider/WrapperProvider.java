package com.things.customer.xcitycustomerskb.pega.provider;

import com.things.customer.xcitycustomerskb.Exception.GeneralException;
import com.things.customer.xcitycustomerskb.config.RestTemplateConfig;
import com.things.customer.xcitycustomerskb.pega.response.pegaresponse.*;
import com.things.customer.xcitycustomerskb.pega.request.pega.PegaRequest;
import com.things.customer.xcitycustomerskb.pega.request.pega.PlaceholderRequestContext;
import com.things.customer.xcitycustomerskb.pega.request.wrapper.WrapperRequest;
import com.things.customer.xcitycustomerskb.pega.response.pegaresponse.GnaPega;
import com.things.customer.xcitycustomerskb.pega.response.wrapperresponse.*;
import com.things.customer.xcitycustomerskb.pega.util.MappingUtility;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class WrapperProvider {
    private final MappingUtility mapUtil;
    private final RestTemplateConfig restTemplate;

    public WrapperProvider(MappingUtility mapUtil, RestTemplateConfig restTemplate) {
        this.mapUtil = mapUtil;
        this.restTemplate = restTemplate;
    }

    public WrapperResponse getMovies(String stringRequestFromPostman) {
        //convert string to request model
        WrapperRequest wrapperRequest = mapUtil.mapStringToCreateWrapperRequest(stringRequestFromPostman);

        //validate request
        validateWrapperRequest(wrapperRequest);

        //set generatedId
        String generatedID = translateToGeneratedId(wrapperRequest.getShortListedMovieGUID());
        wrapperRequest.setGeneratedID(generatedID);

        //create request payload to call Pega
        PegaRequest pegaRequestBody = getPegaRequest(wrapperRequest);

        //call pega and get the response entity
        ResponseEntity<PegaResponse> responseEntity = postCallPega(pegaRequestBody);

        // convert response entity to List<PegaResponse>
        List<PegaResponse> response = Arrays.asList(responseEntity.getBody());


        //map PegaResponse to Wrapper
        WrapperResponse wrapperResponse = mapToInteraction(response);

        return wrapperResponse;

    }

    /**
     * POST call Pega and get response
     *
     * @param pegaRequestBody
     * @return ResponseEntity<PegaResponse>
     */
    public ResponseEntity<PegaResponse> postCallPega(PegaRequest pegaRequestBody) {
        String url = "http://localhost:8089/pega";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<PegaRequest> requestEntity = new HttpEntity<>(pegaRequestBody, headers);
        ResponseEntity<PegaResponse> response =
                restTemplate.myRestTemplate(new RestTemplateBuilder()).postForEntity(url, requestEntity, PegaResponse.class);
        return response;
    }

    /**
     * Map Pega response to Wrapper response
     *
     * @param pegaResponseList
     * @return WrapperResponse
     */
    public WrapperResponse mapToInteraction(List<PegaResponse> pegaResponseList) {  //pegaResponseList comes as a list [...]
        try {
            WrapperResponse wrapperResponse = new WrapperResponse();

            Optional<List<PegaResponse>> b = Optional.ofNullable(pegaResponseList);
            System.out.println("b >>> " + b);
            if(b.isPresent()){
                for (PegaResponse eachPegaResponse : pegaResponseList) {
                    // Iterate each item from incoming object
                    if (eachPegaResponse.getStatus().equals("OK") && eachPegaResponse.getPegaMovies() != null) {

                        List<WrapperMovie> wrapperMovieList = new ArrayList<>();

                        for (PegaMovie eachPegaMovie : eachPegaResponse.getPegaMovies()) {
                            if (eachPegaMovie.getStatus().equals("OK")) {
                                for (PegaDetail eachDetails : eachPegaMovie.getPegaDetails()) {
                                    List<WrapperDetail> WrapperDetailList = new ArrayList<>();
                                    WrapperDetail wrapperDetail = new WrapperDetail();
                                    List<GnaWrapper> GnaWrapperList = new ArrayList<>();
                                    GnaWrapper gnaWrapper = new GnaWrapper();

                                    for (GnaPega eachGenresAndActor : eachDetails.getGenreNActors()) {

                                        List<WrapperArtist> WrapperArtistList = new ArrayList<>();

                                        for (PegaActor eachPegaActor : eachGenresAndActor.getPegaActors()) {
                                            WrapperArtist WrapperArtist = new WrapperArtist();
                                            WrapperArtist.setMaleLead(eachPegaActor.getMaleLeadActor());
                                            WrapperArtist.setFemaleLead(eachPegaActor.getFemaleLeadActor());
                                            WrapperArtist.setRottenTomatoesRating(eachPegaActor.getVote());
                                            WrapperArtistList.add(WrapperArtist);
                                            gnaWrapper.setWrapperArtists(WrapperArtistList);

                                        }
                                        List<String> genresList = new ArrayList<>();

                                        for (String eachGenre : eachGenresAndActor.getGenres()) {
                                            genresList.add(eachGenre);
                                            gnaWrapper.setGenres(genresList);
                                        }
                                        GnaWrapperList.add(gnaWrapper);

                                        wrapperDetail.setGenreNActors(GnaWrapperList);
                                    }
                                    wrapperDetail.setMovieName(eachDetails.getPictureName());
                                    wrapperDetail.setReleasedYear(eachDetails.getYear());
                                    wrapperDetail.setPlotGlance(eachDetails.getPlot());

                                    WrapperDetailList.add(wrapperDetail);

                                    WrapperMovie wrapperMovie = new WrapperMovie();

                                    wrapperMovie.setWrapperDetails(WrapperDetailList);
                                    wrapperMovie.setBigIndustry(eachPegaMovie.getIndustryName());

                                    wrapperMovieList.add(wrapperMovie);


                                    wrapperResponse.setWrapperMovies(wrapperMovieList);
                                    wrapperResponse.setBoxOfficeID(eachPegaResponse.getBoxOfficeID());

                                }
                            }
                        }
                        System.out.println(wrapperResponse);
                        return wrapperResponse;
                    }
                }
            }
        } catch (Exception ex) {
            throw new GeneralException(ex);
        }
        return null;
    }

    public PegaRequest getPegaRequest(WrapperRequest incomingObject) {
        PegaRequest outgoingObject = new PegaRequest();
        if (incomingObject.getName() != null && incomingObject.getName().isEmpty()) {
            outgoingObject.setName(incomingObject.getName());
        } else {
            outgoingObject.setName("Best-Movies"); //Hardcoding
        }
        outgoingObject.setMovieBoard("WorldWide");
        outgoingObject.setChannel(incomingObject.getChannel());
        outgoingObject.setMovieBoard("Board");
        outgoingObject.setMovieID(incomingObject.getMovieID());
        outgoingObject.setZoneID(incomingObject.getZoneIDs());
        outgoingObject.setShortListedMovieGUID(incomingObject.getShortListedMovieGUID());
        outgoingObject.setMovieBoard(incomingObject.getMovieBoard());

        List<PlaceholderRequestContext> placeholderRequestContextList = new ArrayList<>();
        PlaceholderRequestContext prc = new PlaceholderRequestContext();
        prc.setKey("key");
        prc.setType("type");
        prc.setValue("value");

        placeholderRequestContextList.add(prc);

        outgoingObject.setContexts(placeholderRequestContextList);
        return outgoingObject;
    }


    private void validateWrapperRequest(WrapperRequest cir) {
        List<String> resultList = new ArrayList<>();
        if (cir.getMovieID() == null || cir.getMovieID().isEmpty()) {
            resultList.add("movieID cannot be null or blank ");
        }
        if (cir.getChannel() == null || cir.getChannel().isEmpty()) {
            resultList.add("channel cannot be null or blank ");
        }
        if (cir.getShortMovieID() == null || cir.getShortMovieID().isEmpty()) {
            resultList.add("shortMovieId cannot be null or blank ");
        }
        if (cir.getZoneIDs() == null || cir.getZoneIDs().isEmpty()) {
            resultList.add("zoneId cannot be null or blank");
        }
//        String formattedString = resultList.toString()
//                .replace(",", "")  //remove the commas
//                .replace("[", "")  //remove the right bracket
//                .replace("]", "")  //remove the left bracket
//                .trim();


        StringBuilder builder = new StringBuilder();
        for (String value : resultList) {
            builder.append(value);
        }
        String formattedString = builder.toString();
        if (!resultList.isEmpty()) {
            throw new GeneralException(formattedString);
        }
    }


    private String translateToGeneratedId(String partyGuid) {
        //remove all numbers:
        return partyGuid.replaceAll("\\d", "");
    }


}
