package unisangil.parcialfinal.services;

import unisangil.parcialfinal.models.Transaction;

import java.util.List;

public interface TransactionsService {

    void saveTransaction(Transaction transaccion);

    List<Transaction> getAllTransactions();

    Double getTotalIncome();

    Double getTotalExpense();

    Double getTotalNet();
}
