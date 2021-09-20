package net.spring.springsecuritydemo.rest;

import net.spring.springsecuritydemo.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/developers")
public class DevelopersRestController {

    private List<Developer> developerList = Stream.of(
            new Developer(1L, "Nikita", "Dolboeb"),
            new Developer(2L, "Oleg", "Evgenich"),
            new Developer(3L, "Lox", "Kapustnii")

    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return developerList;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return developerList.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer){
        this.developerList.add(developer);
        return developer;
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id){
        this.developerList.removeIf(developer -> developer.getId().equals(id));
    }

}
