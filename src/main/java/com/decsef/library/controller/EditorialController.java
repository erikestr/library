package com.decsef.library.controller;

import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import com.decsef.library.service.EditorialService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://localhost:4200"})
@RequestMapping("/api/editorial")
@AllArgsConstructor
public class EditorialController {

    private final EditorialService editorialService;

    @PostMapping
    public Editorial registerEditorial(@RequestBody Editorial editorial){
        return editorialService.registerEditorial(editorial);
    }

    @DeleteMapping
    public boolean deleteEditorial(@RequestBody Editorial editorial){
        return editorialService.deleteEditorial(editorial);
    }

    @PutMapping
    public Editorial updateEditorial(@RequestBody Editorial editorial) {
        return editorialService.updateEditorial(editorial);
    }

}
