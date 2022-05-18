package lk.agri.repository;

import lk.agri.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
//    List<Item> findAllByCardTitle(String cardTitle);
    List<Item> findAllByUserAccountEmail(String accId);

//    @Query(value = "from card where cardTitle=?1")
//    List<Card> Title(String cardTitle);
}
