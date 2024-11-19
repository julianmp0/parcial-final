package unisangil.parcialfinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisangil.parcialfinal.models.TransactionType;
import unisangil.parcialfinal.models.Transaction;
import unisangil.parcialfinal.repository.TransactionsRepository;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;


    @Override
    public List<Transaction> getAllIncomes() {
        List<Transaction> transactions = transactionsRepository.findTransactionsByType(TransactionType.INCOME);
        return transactions;
    }

    @Override
    public void saveTransaction(Transaction transaccion) {
        transactionsRepository.save(transaccion);
    }
}
