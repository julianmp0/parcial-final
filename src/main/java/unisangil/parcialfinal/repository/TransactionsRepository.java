package unisangil.parcialfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisangil.parcialfinal.models.TransactionType;
import unisangil.parcialfinal.models.Transaction;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findTransactionsByType(TransactionType type);

    @Query(value = "SELECT * FROM transactions ORDER BY date DESC LIMIT :limit", nativeQuery = true)
    List<Transaction> findAllByOrderByDateDesc(@Param("limit") int limit);
}
