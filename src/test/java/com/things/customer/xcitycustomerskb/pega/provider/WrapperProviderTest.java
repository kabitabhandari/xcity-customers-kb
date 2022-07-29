package com.things.customer.xcitycustomerskb.pega.provider;

import com.things.customer.xcitycustomerskb.config.RestTemplateConfig;
import com.things.customer.xcitycustomerskb.pega.response.pegaresponse.*;
import com.things.customer.xcitycustomerskb.pega.response.wrapperresponse.*;
import com.things.customer.xcitycustomerskb.pega.util.MappingUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class WrapperProviderTest {
    @Mock
    MappingUtility mappingUtility;

    @Mock
    RestTemplateConfig restTemplateConfig;

    @InjectMocks
    WrapperProvider wrapperProvider;

    @Test
    public void mapToInteractionShouldReturnWrapperResponse() {
        WrapperResponse expectedWrapperResponse = wrapperProvider.mapToInteraction(mockPegaResponse());

        Assertions.assertEquals(expectedWrapperResponse, actualWrapperResponse(), "Wrapper response mis-match");
    }

    private WrapperResponse actualWrapperResponse() {
        WrapperResponse wrapperResponse = new WrapperResponse();
        wrapperResponse.setBoxOfficeID("mock-box-office-id");
        List<WrapperMovie> shortedListedMoviesList = new ArrayList<>();

        WrapperMovie slmw = new WrapperMovie();
        slmw.setBigIndustry("mock-industry-name");

        List<WrapperDetail> selectedMoviesDetailList = new ArrayList<>();
        WrapperDetail smd = new WrapperDetail();
        smd.setMovieName("House MD");
        smd.setPlotGlance("what is the message");
        smd.setReleasedYear(1992);
        List<GnaWrapper> gnaWrapperList = new ArrayList<>();
        GnaWrapper gnaWrapper = new GnaWrapper();
        gnaWrapper.setGenres(new ArrayList<>(Arrays.asList("comedy", "humor", "dark-jokes")));

        List<WrapperArtist> WrapperArtistList = new ArrayList<>();
        WrapperArtist WrapperArtist = new WrapperArtist();
        WrapperArtist.setFemaleLead("Angelina");
        WrapperArtist.setMaleLead("Tom");
        WrapperArtist.setRottenTomatoesRating(5);
        WrapperArtistList.add(WrapperArtist);
        gnaWrapper.setWrapperArtists(WrapperArtistList);

        gnaWrapperList.add(gnaWrapper);
        smd.setGenreNActors(gnaWrapperList);

        selectedMoviesDetailList.add(smd);
        slmw.setWrapperDetails(selectedMoviesDetailList);

        shortedListedMoviesList.add(slmw);
        wrapperResponse.setWrapperMovies(shortedListedMoviesList);
        return wrapperResponse;
    }

    private List<PegaResponse> mockPegaResponse() {
        List<PegaResponse> pegaResponseList = new ArrayList<>();

        PegaResponse pegaResponse = new PegaResponse();
        pegaResponse.setBoxOfficeID("mock-box-office-id");
        pegaResponse.setStatus("OK");


        List<PegaMovie> pegaMovieList = new ArrayList<>();
        PegaMovie pegaMovie = new PegaMovie();
        pegaMovie.setStatus("OK");
        pegaMovie.setIndustryName("mock-industry-name");

        List<PegaDetail> pegaDetailList = new ArrayList<>();
        PegaDetail pegaDetail = new PegaDetail();
        pegaDetail.setChannel("mock-channel");
        pegaDetail.setBoxOfficeID("test-oy-pe-tt-iuop90");
        pegaDetail.setDirection("outbound");
        pegaDetail.setDirector("Gregory");
        pegaDetail.setZoneID("zone-7689");
        pegaDetail.setPictureName("House MD");
        pegaDetail.setPosterUrl("https://funny");
        pegaDetail.setTestID("90po");
        pegaDetail.setPlot("what is the message");
        pegaDetail.setYear(1992);

        List<GnaPega> gnaPegaList = new ArrayList<>();

        GnaPega gnaPega = new GnaPega();
        gnaPega.setGenres(new ArrayList<>(Arrays.asList("comedy", "humor", "dark-jokes")));

        List<PegaActor> pegaActorList = new ArrayList<>();
        PegaActor pegaActor = new PegaActor();

        pegaActor.setMaleLeadActor("Tom");
        pegaActor.setFemaleLeadActor("Angelina");
        pegaActor.setVote(5);
        pegaActorList.add(pegaActor);
        gnaPega.setPegaActors(pegaActorList);
        gnaPegaList.add(gnaPega);
        pegaDetail.setGenreNActors(gnaPegaList);

        pegaDetailList.add(pegaDetail);

        pegaMovie.setPegaDetails(pegaDetailList);
        pegaMovieList.add(pegaMovie);
        pegaResponse.setPegaMovies(pegaMovieList);

        pegaResponseList.add(pegaResponse);

        return pegaResponseList;

    }


}