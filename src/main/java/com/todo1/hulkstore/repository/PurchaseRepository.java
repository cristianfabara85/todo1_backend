package com.todo1.hulkstore.repository;

import com.todo1.hulkstore.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
