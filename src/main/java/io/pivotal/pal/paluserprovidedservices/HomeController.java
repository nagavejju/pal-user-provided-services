package io.pivotal.pal.paluserprovidedservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello PALs from Wells Fargo in Des Moines";
    }

}
