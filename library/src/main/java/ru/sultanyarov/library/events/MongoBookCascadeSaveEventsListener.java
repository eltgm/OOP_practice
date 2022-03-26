package ru.sultanyarov.library.events;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.sultanyarov.library.domain.Author;
import ru.sultanyarov.library.domain.Genre;
import ru.sultanyarov.library.domain.Resource;
import ru.sultanyarov.library.repository.AuthorRepository;
import ru.sultanyarov.library.repository.GenreRepository;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class MongoBookCascadeSaveEventsListener extends AbstractMongoEventListener<Resource> {
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Resource> event) {
        super.onBeforeConvert(event);
        var resource = event.getSource();

        actualizeAuthor(resource);
        actualizeGenre(resource);
    }

    private void actualizeAuthor(Resource resource) {
        Author author = resource.getAuthor();

        if (author == null || isEmpty(author.getFio())) {
            resource.setAuthor(null);
        } else {
            Author authorByFio = authorRepository.findByFio(author.getFio());
            if (authorByFio == null) {
                authorRepository.save(author);
            } else {
                resource.setAuthor(authorByFio);
            }
        }
    }

    private void actualizeGenre(Resource resource) {
        Genre genre = resource.getGenre();

        if (genre == null || isEmpty(genre.getName())) {
            resource.setGenre(null);
        } else {
            Genre genreByName = genreRepository.findByName(genre.getName());
            if (genreByName == null) {
                genreRepository.save(genre);
            } else {
                resource.setGenre(genreByName);
            }
        }
    }
}
