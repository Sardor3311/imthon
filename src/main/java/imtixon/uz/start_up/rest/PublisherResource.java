package imtixon.uz.start_up.rest;

import imtixon.uz.start_up.dto.PublisherDTO;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherResource {
    private final PublisherService publisherService;

    @GetMapping("/get-all")
    public ResponseDTO<Page<PublisherDTO>> getAll(@RequestParam(defaultValue = "20") Integer size,
                                                  @RequestParam(defaultValue = "0") Integer page){
        return publisherService.getAllPublisher(size,page);
    }
}
