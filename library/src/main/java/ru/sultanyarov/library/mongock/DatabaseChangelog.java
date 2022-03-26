package ru.sultanyarov.library.mongock;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.mongodb.client.MongoDatabase;
import ru.sultanyarov.library.domain.*;
import ru.sultanyarov.library.dto.ClientResourceDto;

import java.time.LocalDate;
import java.util.List;

import static ru.sultanyarov.library.mapper.ResourceMapper.mapPaperResourceToResourceDto;

@ChangeLog
public class DatabaseChangelog {
    public static final String RESOURCE_COLLECTION = "resource";
    public static final String USER_COLLECTION = "user";

    private Genre social;
    private Genre fantasy;
    private Genre compMagazine;

    private Author orwell;
    private Author sapkowski;
    private Author mathers;
    private Author ivanov;

    private Book lastWish;

    private Reader client;

    @ChangeSet(order = "000", id = "dropDB", author = "vs", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "addGenres", author = "vs", runAlways = true)
    public void insertGenres(MongockTemplate template) {
        social = template.save(Genre.builder()
                .name("Social science fiction")
                .ageLimit(18)
                .firstMention(LocalDate.of(1900, 1, 1))
                .build());
        template.save(Genre.builder()
                .name("Satire")
                .ageLimit(20)
                .firstMention(LocalDate.of(1920, 12, 25))
                .build());
        fantasy = template.save(Genre.builder()
                .name("Fantasy")
                .ageLimit(0)
                .firstMention(LocalDate.of(1940, 12, 25))
                .build());

        compMagazine = template.save(Genre.builder()
                .name("Computer magazine")
                .ageLimit(0)
                .firstMention(LocalDate.of(1940, 12, 25))
                .build());
    }

    @ChangeSet(order = "002", id = "addAuthors", author = "vs", runAlways = true)
    public void insertAuthors(MongockTemplate template) {
        orwell = template.save(Author.builder()
                .birthDate(LocalDate.of(1903, 6, 25))
                .fio("Джордж О́руэлл")
                .build());
        sapkowski = template.save(Author.builder()
                .birthDate(LocalDate.of(1948, 6, 21))
                .fio("А́нджей Сапко́вский")
                .build());

        mathers = template.save(Author.builder()
                .birthDate(LocalDate.of(1972, 10, 17))
                .fio("Ма́ршалл Брюс Мэ́терс III")
                .build());

        ivanov = template.save(Author.builder()
                .birthDate(LocalDate.of(2000, 10, 17))
                .fio("Иванов Иван Иванович")
                .build());
    }

    @ChangeSet(order = "003", id = "addBooks", author = "vs", runAlways = true)
    public void insertBooks(MongockTemplate template) {
        lastWish = template.save(Book.builder()
                .content("Вошла осторожно, тихо, бесшумно ступая, плывя по комнате, словно призрак, привидение, а единственным звуком, выдававшим ее движение, был шорох накидки, прикасавшейся к голому телу.")
                .author(sapkowski)
                .genre(fantasy)
                .size(640)
                .releaseDate(LocalDate.of(1993, 1, 1))
                .availability(true)
                .name("Последнее желание")
                .carrierType(CarrierType.PAPER)
                .build(), RESOURCE_COLLECTION);

        template.save(Book.builder()
                .content("На поляне в полном вооружении, без шлема, в откинутом на плечо карминовом плаще ордена стоял Фальвик.")
                .author(sapkowski)
                .genre(fantasy)
                .size(600)
                .releaseDate(LocalDate.of(1993, 2, 1))
                .availability(false)
                .name("Глас рассудка")
                .carrierType(CarrierType.PAPER)
                .build(), RESOURCE_COLLECTION);

        template.save(Book.builder()
                .content("Был холодный ясный апрельский день, и часы пробили тринадцать.")
                .author(orwell)
                .genre(social)
                .size(328)
                .releaseDate(LocalDate.of(1949, 6, 8))
                .availability(true)
                .name("1984")
                .carrierType(CarrierType.PAPER)
                .build(), RESOURCE_COLLECTION);
    }

    @ChangeSet(order = "004", id = "addCDs", author = "vs", runAlways = true)
    public void insertCDs(MongockTemplate template) {
        template.save(CD.builder()
                .author(mathers)
                .availability(true)
                .length(78)
                .content("123123")
                .releaseDate(LocalDate.of(2002, 5, 26))
                .name("The Eminem Show")
                .carrierType(CarrierType.DIGITAL)
                .build(), RESOURCE_COLLECTION);
    }

    @ChangeSet(order = "005", id = "addEmployers", author = "vs", runAlways = true)
    public void insertEmployers(MongockTemplate template) {
        template.save(Employer.builder()
                .fio("admin")
                .birthDate(LocalDate.of(1971, 1, 1))
                .position("Администратор")
                .username("admin")
                .password("$2a$10$uDRsYqPIII7QfkKxpf6zv.fOM61TP3G3G.kI0ePgaMZGcrvyLsFNq")
                .build(), USER_COLLECTION);

        template.save(Employer.builder()
                .fio("admin2")
                .birthDate(LocalDate.of(1991, 1, 1))
                .position("admin")
                .build(), USER_COLLECTION);
    }

    @ChangeSet(order = "006", id = "addFlashs", author = "vs", runAlways = true)
    public void insertFlashs(MongockTemplate template) {
        template.save(Flash.builder()
                .author(ivanov)
                .availability(true)
                .content("Диплом.docx")
                .releaseDate(LocalDate.of(2020, 5, 26))
                .name("Дипломная работа.Иванов")
                .carrierType(CarrierType.DIGITAL)
                .build(), RESOURCE_COLLECTION);
    }

    @ChangeSet(order = "007", id = "addMagazines", author = "vs", runAlways = true)
    public void insertMagazines(MongockTemplate template) {
        template.save(Magazine.builder()
                .content("Беспроводная сеть масштаба микрорайона")
                .genre(compMagazine)
                .size(328)
                .releaseDate(LocalDate.of(2010, 6, 8))
                .availability(true)
                .name("ПРОграммист")
                .carrierType(CarrierType.PAPER)
                .build(), RESOURCE_COLLECTION);
    }

    @ChangeSet(order = "008", id = "addReaders", author = "vs", runAlways = true)
    public void insertReaders(MongockTemplate template) {
        client = template.save(Reader.builder()
                .fio("client")
                .birthDate(LocalDate.of(1991, 1, 1))
                .isBlocked(false)
                .sex(Sex.M)
                .username("client")
                .password("$2a$10$gys7ZL5zkwqdcKqQusTfw.WzXUhVLjO3T3ijr1OoFU470X6KVUgt2")
                .build(), USER_COLLECTION);
        template.save(Reader.builder()
                .fio("client1")
                .birthDate(LocalDate.of(1991, 1, 1))
                .isBlocked(true)
                .sex(Sex.W)
                .username("client1")
                .password("$2a$10$gys7ZL5zkwqdcKqQusTfw.WzXUhVLjO3T3ijr1OoFU470X6KVUgt2")
                .build(), USER_COLLECTION);
    }

    @ChangeSet(order = "009", id = "addReviews", author = "vs", runAlways = true)
    public void insertReviews(MongockTemplate template) {
        Review review = Review.builder()
                .comment("Отличная книга")
                .rate(10)
                .reader(client)
                .resource(mapPaperResourceToResourceDto(lastWish))
                .build();
        template.save(review);

        lastWish.setResourceReviews(List.of(review));
        template.save(lastWish, RESOURCE_COLLECTION);
    }

    @ChangeSet(order = "010", id = "addResources", author = "vs", runAlways = true)
    public void insertResourceInUse(MongockTemplate template) {
        client.setResourcesInUse(List.of(new ClientResourceDto(lastWish.getId(), lastWish.getCarrierType())));

        template.save(client);
    }
}
