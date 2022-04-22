package imtixon.uz.start_up.mapping;

import imtixon.uz.start_up.dao.Publisher;
import imtixon.uz.start_up.dto.PublisherDTO;

public class PublisherMapping {
    public static PublisherDTO toPublisherDTO(Publisher publisher){
        return new PublisherDTO(
                publisher.getId(),
                publisher.getName(),
                AddressMapping.toAddressDTO(publisher.getAdress())
        );
    }
}
