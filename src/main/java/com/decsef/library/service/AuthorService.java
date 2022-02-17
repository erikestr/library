package com.decsef.library.service;

import com.decsef.library.dao.AuthorRepository;
import com.decsef.library.entity.Author;
import com.decsef.library.entity.Editorial;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author registerAuthor(Author author) {
        System.out.println("author = " + author);
        if (author.getFirstName() != null && author.getLastName() != null && author.getNationality() != null &&
                author.getBornCountry() != null && author.getBornState() != null &&
                author.getBornCity() != null && author.getDateBorn() != null && author.getOccupation() != null &&
                author.getEducation() != null && author.getRemarkableWork() != null){

            Author authorSave = new Author();
            authorSave = author;
            authorSave.setId(UUID.randomUUID());

            return authorRepository.save(authorSave);
        }

        throw new IllegalStateException("nothing to do");
    }

    public boolean deleteAuthor(Author author) {
        if (!authorRepository.existsById(author.getId())){
            throw new IllegalStateException(
                    "student with id "+author.getId()+" does not exist");
        }
        authorRepository.deleteById(author.getId());
        return true;
    }

    public Author updateAuthor(Author author) {
        Author actualAuthor = authorRepository.findById(author.getId()).orElseThrow(
                () -> new IllegalStateException(
                        "author with id "+author.getId()+" does not exist")
        );

        if (author.getFirstName() != null && author.getFirstName().length() > 0 &&
                !Objects.equals(actualAuthor.getFirstName(), author.getFirstName())){

            actualAuthor.setFirstName(author.getFirstName());
        }
        if (author.getLastName() != null && author.getLastName().length() > 0 &&
                !Objects.equals(actualAuthor.getLastName(), author.getLastName())){

            actualAuthor.setLastName(author.getLastName());
        }
        if (author.getNationality() != null && author.getNationality().length() > 0 &&
                !Objects.equals(actualAuthor.getNationality(), author.getNationality())){

            actualAuthor.setNationality(author.getNationality());
        }
        if (author.getBornCountry() != null && author.getBornCountry().length() > 0 &&
                !Objects.equals(actualAuthor.getBornCountry(), author.getBornCountry())){

            actualAuthor.setBornCountry(author.getBornCountry());
        }
        if (author.getBornState() != null && author.getBornState().length() > 0 &&
                !Objects.equals(actualAuthor.getBornState(), author.getBornState())){

            actualAuthor.setBornState(author.getBornState());
        }
        if (author.getBornCity() != null && author.getBornCity().length() > 0 &&
                !Objects.equals(actualAuthor.getBornCity(), author.getBornCity())){

            actualAuthor.setBornCity(author.getBornCity());
        }
        if (author.getDateBorn() != null &&
                !Objects.equals(actualAuthor.getDateBorn(), author.getDateBorn())){

            actualAuthor.setDateBorn(author.getDateBorn());
        }
        if (author.getDateDeath() != null &&
                !Objects.equals(actualAuthor.getDateDeath(), author.getDateDeath())){

            actualAuthor.setDateDeath(author.getDateDeath());
        }
        if (author.getOccupation() != null && author.getOccupation().length() > 0 &&
                !Objects.equals(actualAuthor.getOccupation(), author.getOccupation())){

            actualAuthor.setOccupation(author.getOccupation());
        }
        if (author.getEducation() != null && author.getEducation().length() > 0 &&
                !Objects.equals(actualAuthor.getEducation(), author.getEducation())){

            actualAuthor.setEducation(author.getEducation());
        }
        if (author.getRemarkableWork() != null && author.getRemarkableWork().length() > 0 &&
                !Objects.equals(actualAuthor.getRemarkableWork(), author.getRemarkableWork())){

            actualAuthor.setRemarkableWork(author.getRemarkableWork());
        }

        return authorRepository.save(actualAuthor);
    }
}
