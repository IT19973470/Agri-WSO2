package lk.agri.repository;

import lk.agri.entity.Cart;
import lk.agri.entity.CartPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartPK> {
    List<Cart> findAllByUserAccountEmail(String nic);
    long deleteByUserAccountEmailAndItemItemId(String nic, String item);
}