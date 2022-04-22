package imtixon.uz.start_up.service;

import imtixon.uz.start_up.dao.Publisher;
import imtixon.uz.start_up.dto.PublisherDTO;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.mapping.PublisherMapping;
import imtixon.uz.start_up.repository.PublisherRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepostory publisherRepostory;

    public ResponseDTO<Page<PublisherDTO>> getAllPublisher(Integer size, Integer page){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Publisher> result = publisherRepostory.findAll(pageRequest);

        if(result.getContent().size() > 0) {
            List<PublisherDTO> list = result.stream()
                    .map(PublisherMapping::toPublisherDTO).collect(Collectors.toList());
            Page<PublisherDTO> responce = new PageImpl<>(list, result.getPageable(), result.getTotalElements());

            return new ResponseDTO<>(true, 0, "OK", responce);
        }
        return new ResponseDTO<>(false, -1, "Data not found", null);
    }
}
