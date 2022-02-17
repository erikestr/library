package com.decsef.library.service;

import com.decsef.library.dao.EditorialRepository;
import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public Editorial registerEditorial(Editorial editorial) {
        if (editorial.getName() != null && editorial.getCountry() != null && editorial.getState() != null && editorial.getCity() != null && editorial.getDateFoundation() != null){

            Editorial editorialSave = new Editorial();
            editorialSave = editorial;
            editorialSave.setId(UUID.randomUUID());

            return editorialRepository.save(editorialSave);
        }

        throw new IllegalStateException("nothing to do");
    }

    public boolean deleteEditorial(Editorial editorial) {
        if (!editorialRepository.existsById(editorial.getId())){
            throw new IllegalStateException(
                    "student with id "+editorial.getId()+" does not exist");
        }
        editorialRepository.deleteById(editorial.getId());
        return true;
    }

    public Editorial updateEditorial(Editorial editorial) {
        Editorial actualEditorial = editorialRepository.findById(editorial.getId()).orElseThrow(
                () -> new IllegalStateException(
                        "editorial with id "+editorial.getId()+" does not exist")
        );

        if (editorial.getName() != null && editorial.getName().length() > 0 &&
                !Objects.equals(actualEditorial.getName(), editorial.getName())){

            actualEditorial.setName(editorial.getName());
        }
        if (editorial.getCountry() != null && editorial.getCountry().length() > 0 &&
                !Objects.equals(actualEditorial.getCountry(), editorial.getCountry())){

            actualEditorial.setCountry(editorial.getCountry());
        }
        if (editorial.getState() != null && editorial.getState().length() > 0 &&
                !Objects.equals(actualEditorial.getState(), editorial.getState())){

            actualEditorial.setState(editorial.getState());
        }
        if (editorial.getCity() != null && editorial.getCity().length() > 0 &&
                !Objects.equals(actualEditorial.getCity(), editorial.getCity())){

            actualEditorial.setCity(editorial.getCity());
        }

        if (editorial.getDateFoundation() != null &&
                !Objects.equals(actualEditorial.getDateFoundation(), editorial.getDateFoundation())){

            actualEditorial.setDateFoundation(editorial.getDateFoundation());
        }

        return editorialRepository.save(actualEditorial);
    }
}
