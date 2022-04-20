package imtixon.uz.start_up.rest;

import imtixon.uz.start_up.dto.BookDTO;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookResource {
    private final BookService bookService;

    @GetMapping("/get-all")
    public ResponseDTO<List<BookDTO>> getAll(){
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseDTO<BookDTO> add(@RequestBody BookDTO bookDTO){
        return bookService.addNew(bookDTO);
    }
}
