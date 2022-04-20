package imtixon.uz.start_up.service;

import imtixon.uz.start_up.dao.Book;
import imtixon.uz.start_up.dto.BookDTO;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.mapping.BookMapping;
import imtixon.uz.start_up.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public ResponseDTO<BookDTO> addNew(BookDTO bookDTO){
        try {
            Book book = BookMapping.toEntity(bookDTO);
            bookRepository.save(book);
            return new ResponseDTO<>(true, 1, "OK", BookMapping.toDto(book));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "Error saving", null);
        }
    }

    public ResponseDTO<List<BookDTO>> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        if(!books.isEmpty()) {
            List<BookDTO> response = new ArrayList<>();
            for (Book book : books){
                response.add(BookMapping.toDto(book));
            }
            return new ResponseDTO<>(true,0,"OK", response);
        }
        return new ResponseDTO<>(false, -1, "ERROR", null);
    }

}
