package io.pivotal.pal.paluserprovidedservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private CohortRepository cohortRepository;

    public HomeController(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Cohort>> home() {
        //return "Hello PALs from Wells Fargo in Des Moines";
        return new ResponseEntity<>(cohortRepository.getNames(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cohort>> list() {
        return new ResponseEntity<>(cohortRepository.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cohort> create(@RequestBody Cohort cohort) {
        Cohort created = cohortRepository.create(cohort);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Cohort> update(@PathVariable Long id, @RequestBody Cohort cohort) {
        Cohort updatedCohort = cohortRepository.update(id, cohort);
        if (updatedCohort != null) {
            return new ResponseEntity<>(updatedCohort, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cohort> delete(@PathVariable Long id) {
        cohortRepository.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
