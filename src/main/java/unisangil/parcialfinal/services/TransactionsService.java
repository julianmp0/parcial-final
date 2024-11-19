package unisangil.parcialfinal.services;

import unisangil.parcialfinal.models.Transaction;

import java.util.List;

public interface TransactionsService {

    public List<Transaction> getAllIncomes();

    void saveTransaction(Transaction transaccion);
}
