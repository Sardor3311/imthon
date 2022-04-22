package imtixon.uz.start_up.repository;


import imtixon.uz.start_up.dao.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepostory  extends JpaRepository<Publisher, Integer> {
}
