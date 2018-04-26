package io.pivotal.pal.paluserprovidedservices;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class HomeControllerTest {
    private CohortRepository cohortRepository;
    private HomeController controller;

    @Before
    public void setUp() throws Exception {
        cohortRepository = mock(CohortRepository.class);
        controller = new HomeController(cohortRepository);
    }

    @Test
    public void testCreate() throws Exception {
        Cohort cohortToCreate = new Cohort("nageswara", "nagesh");
        Cohort expectedResult = new Cohort(1L, "nageswara", "nagesh");
        doReturn(expectedResult)
            .when(cohortRepository)
            .create(any(Cohort.class));


        ResponseEntity response = controller.create(cohortToCreate);


        verify(cohortRepository).create(cohortToCreate);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResult);
    }





    @Test
    public void testList() throws Exception {
        List<Cohort> expected = asList(
            new Cohort(1L, "nageswara", "nagesh"),
            new Cohort(2L, "Patrick", "pat")
        );
        doReturn(expected).when(cohortRepository).list();

        ResponseEntity<List<Cohort>> response = controller.list();

        verify(cohortRepository).list();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void testUpdate() throws Exception {
        Cohort expected = new Cohort(1L, "nageswara", "nagesh");
        doReturn(expected)
            .when(cohortRepository)
            .update(eq(1L), any(Cohort.class));

        ResponseEntity response = controller.update(1L, expected);

        verify(cohortRepository).update(1L, expected);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void testUpdate_NotFound() throws Exception {
        doReturn(null)
            .when(cohortRepository)
            .update(eq(1L), any(Cohort.class));

        ResponseEntity response = controller.update(1L, new Cohort());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testDelete() throws Exception {
        ResponseEntity<Cohort> response = controller.delete(1L);
        verify(cohortRepository).delete(1L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
