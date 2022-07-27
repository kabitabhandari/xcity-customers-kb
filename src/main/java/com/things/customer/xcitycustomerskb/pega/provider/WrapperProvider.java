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

        //set xdcId
        String generatedID = translateToGeneratedId(wrapperRequest.getShortListedMovieGUID());
        wrapperRequest.setGeneratedID(generatedID);

        //create request payload to call Pega
        PegaRequest pegaRequestBody = getPegaRequest(wrapperRequest);

        //call pega and get the response entity
        ResponseEntity<PegaResponse> responseEntity = postCallPega(pegaRequestBody);

        // convert response entity to List<PegaResponse>
        List<PegaResponse> response =  Arrays.asList(responseEntity.getBody());


        //map PegaResponse to Interaction
        WrapperResponse wrapperResponse = mapToInteraction(response);

        return wrapperResponse;

    }

    /**
     * POST call Pega and get response
     * @param pegaRequestBody
     * @return ResponseEntity<PegaResponse>
     */
    public ResponseEntity<PegaResponse>postCallPega(PegaRequest pegaRequestBody) {
        String url ="http://localhost:8089/pega" ;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<PegaRequest> requestEntity = new HttpEntity<>(pegaRequestBody, headers);
        ResponseEntity<PegaResponse> response =
                restTemplate.myRestTemplate(new RestTemplateBuilder()).postForEntity(url, requestEntity,  PegaResponse.class);
        return response;
    }

    /**
     * Map Pega response to Wrapper response
     * @param incomingObject
     * @return WrapperResponse
     */
    public WrapperResponse mapToInteraction(List<PegaResponse> incomingObject) {  //incomingObject comes as a list [...]
      // wrapper model
        WrapperResponse outgoingObject = new WrapperResponse();

        try{
            if(incomingObject != null){
                for(PegaResponse eachIncomingResponse : incomingObject){
                    // each item from incoming object..
                    if(eachIncomingResponse.getStatus().equals("OK") && eachIncomingResponse.getMovies() != null){
                        for(Movie eachMovie : eachIncomingResponse.getMovies()){

                            List<ShortlistedMovie> shortlistedMovieArrayList = new ArrayList<>();

                            if(eachMovie.getStatus().equals("OK")){

                                for(Detail eachDetails : eachMovie.getDetails()){

                                    PictureInfo pictureInfo = new PictureInfo();
                                    pictureInfo.setMovieName(eachDetails.getPictureName());
                                    pictureInfo.setPlotGlance(eachDetails.getPlot());
                                    pictureInfo.setReleasedYear(eachDetails.getYear());

                                    List<PictureInfo> pictureInfoList = new ArrayList<>();
                                    pictureInfoList.add(pictureInfo);


                                    ShortlistedMovie shortlistedMovie = new ShortlistedMovie();
                                    shortlistedMovie.setPictureInfos(pictureInfoList);

                                    shortlistedMovie.setBanner(eachMovie.getIndustryName());
                                    shortlistedMovieArrayList.add(shortlistedMovie);

                                    for(GnaPega eachGenresAndActor : eachDetails.getGenreNActors()){
                                        outgoingObject.setBoxOfficeID(eachDetails.getBoxOfficeID());

                                        List<Artist> artistList = new ArrayList<>();
                                        List<String> genresList = new ArrayList<>();
                                        List<GnA> gnAList = new ArrayList<>();

                                        for (Actor eachActor : eachGenresAndActor.getActors()) {
                                            Artist artist = new Artist();
                                            artist.setMaleLeadActor(eachActor.getMaleLeadActor());
                                            artist.setFemaleLeadActor(eachActor.getFemaleLeadActor());
                                            artist.setRating(eachActor.getVote());
                                            artistList.add(artist);
                                        }

                                        for (String eachGenre : eachGenresAndActor.getGenres()) {
                                            genresList.add(eachGenre);
                                        }

                                        GnA gna = new GnA();
                                        gna.setArtists(artistList);
                                        gna.setGenres(genresList);

                                        gnAList.add(gna);
                                        pictureInfo.setGenreNActors(gnAList);
                                    }
                                }
                                outgoingObject.setShortlistedMovies(shortlistedMovieArrayList);

                            }
                        }
                    }
                }
            }
        }catch(Exception ex){
            throw new GeneralException(ex);
        }
        System.out.println(outgoingObject);
        return outgoingObject;


    }

    public PegaRequest getPegaRequest(WrapperRequest incomingObject) {
        PegaRequest outgoingObject = new PegaRequest();
        if(incomingObject.getName() != null && incomingObject.getName().isEmpty()){
            outgoingObject.setName(incomingObject.getName());
        }else{
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
        if(cir.getMovieID() == null || cir.getMovieID().isEmpty()){
            resultList.add("pageId cannot be null or blank ");
        }
        if(cir.getChannel() == null || cir.getChannel().isEmpty()){
            resultList.add("channel cannot be null or blank ");
        }
        if(cir.getShortMovieID() == null || cir.getShortMovieID().isEmpty()){
            resultList.add("shortPageId cannot be null or blank ");
        }
        if(cir.getZoneIDs() == null || cir.getZoneIDs().isEmpty()){
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
        if(!resultList.isEmpty()){
           throw new GeneralException(formattedString);
       }
    }


    private String translateToGeneratedId(String partyGuid) {
        //remove all numbers:
        return partyGuid.replaceAll("\\d","");
    }




}
