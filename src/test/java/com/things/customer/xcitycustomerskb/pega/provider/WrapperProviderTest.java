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
        List<ShortlistedMoviesForWrapper> shortedListedMoviesList = new ArrayList<>();

        ShortlistedMoviesForWrapper slmw = new ShortlistedMoviesForWrapper();
        slmw.setBigIndustry("mock-industry-name");

        List<SelectedMovieDetails> selectedMoviesDetailList = new ArrayList<>();
        SelectedMovieDetails smd = new SelectedMovieDetails();
        smd.setMovieName("House MD");
        smd.setPlotGlance("what is the message");
        smd.setReleasedYear(1992);
        List<GA> gaList = new ArrayList<>();
        GA ga = new GA();
        ga.setGenres(new ArrayList<>(Arrays.asList("comedy", "humor", "dark-jokes")));

        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist();
        artist.setFemaleLead("Angelina");
        artist.setMaleLead("Tom");
        artist.setRottenTomatoesRating(5);
        artistList.add(artist);
        ga.setArtists(artistList);

        gaList.add(ga);
        smd.setGenreNActors(gaList);

        selectedMoviesDetailList.add(smd);
        slmw.setSelectedMovieDetails(selectedMoviesDetailList);

        shortedListedMoviesList.add(slmw);
        wrapperResponse.setShortlistedMoviesForWrappers(shortedListedMoviesList);
        return wrapperResponse;
    }

    private List<PegaResponse> mockPegaResponse() {
        List<PegaResponse> pegaResponseList = new ArrayList<>();

        PegaResponse pegaResponse = new PegaResponse();
        pegaResponse.setBoxOfficeID("mock-box-office-id");
        pegaResponse.setStatus("OK");


        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie();
        movie.setStatus("OK");
        movie.setIndustryName("mock-industry-name");

        List<Detail> detailList = new ArrayList<>();
        Detail detail = new Detail();
        detail.setChannel("mock-channel");
        detail.setBoxOfficeID("test-oy-pe-tt-iuop90");
        detail.setDirection("outbound");
        detail.setDirector("Gregory");
        detail.setZoneID("zone-7689");
        detail.setPictureName("House MD");
        detail.setPosterUrl("https://funny");
        detail.setTestID("90po");
        detail.setPlot("what is the message");
        detail.setYear(1992);

        List<GnaPega> gnaPegaList = new ArrayList<>();

        GnaPega gnaPega = new GnaPega();
        gnaPega.setGenres(new ArrayList<>(Arrays.asList("comedy", "humor", "dark-jokes")));

        List<Actor> actorList = new ArrayList<>();
        Actor actor = new Actor();

        actor.setMaleLeadActor("Tom");
        actor.setFemaleLeadActor("Angelina");
        actor.setVote(5);
        actorList.add(actor);
        gnaPega.setActors(actorList);
        gnaPegaList.add(gnaPega);
        detail.setGenreNActors(gnaPegaList);

        detailList.add(detail);

        movie.setDetails(detailList);
        movieList.add(movie);
        pegaResponse.setMovies(movieList);

        pegaResponseList.add(pegaResponse);

        return pegaResponseList;

    }


}