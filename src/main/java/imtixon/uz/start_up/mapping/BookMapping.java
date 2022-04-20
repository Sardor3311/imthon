package imtixon.uz.start_up.mapping;

import imtixon.uz.start_up.dao.Book;
import imtixon.uz.start_up.dto.BookDTO;

public class BookMapping {
    public static BookDTO toDto(Book book){
        return new BookDTO(
                book.getId(),
                book.getName_uz_ly(),
                "",
                book.getCost(),
                book.getGenre(),
                book.getAuthorId()
        );
    }

    public static Book toEntity(BookDTO bookDTO){
        return new Book(
                bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getCost(),
                1,
                bookDTO.getGenre(),
                bookDTO.getPublisherId()
        );
    }
}
