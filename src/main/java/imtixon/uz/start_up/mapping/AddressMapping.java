package imtixon.uz.start_up.mapping;

import imtixon.uz.start_up.dao.Address;
import imtixon.uz.start_up.dto.AddressDTO;


public class AddressMapping {
    public static AddressDTO toAddressDTO(Address address){
        return address == null ? null : new AddressDTO(
                address.getId(),
                address.getRegion_id(),
                address.getDistrict_id(),
                address.getStreet(),
                address.getHomeNumber(),
                address.getOrient()
        );
    }
}
