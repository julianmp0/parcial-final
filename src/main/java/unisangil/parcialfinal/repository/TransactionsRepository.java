package unisangil.parcialfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisangil.parcialfinal.models.TransactionType;
import unisangil.parcialfinal.models.Transaction;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {

    //find all transactions by type income
    public List<Transaction> findTransactionsByType(TransactionType type);

}
