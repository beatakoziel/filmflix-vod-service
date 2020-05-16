package com.filmflix.vodservice.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

import static com.filmflix.vodservice.utilities.TestConstants.VIDEO_TEST_URL_RESOURCE;

@RunWith(SpringRunner.class)
public class VideoServiceTest {

    @InjectMocks
    private VideoService videoService;

    @Test
    public void resourceRegion_shouldReturnResourceRegion() throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("range","bytes=50-100");
        ResourceRegion resourceRegion = videoService.resourceRegion(
                new UrlResource(VIDEO_TEST_URL_RESOURCE),
                        httpHeaders);
        assertThat(resourceRegion).isNotNull();
    }
}
