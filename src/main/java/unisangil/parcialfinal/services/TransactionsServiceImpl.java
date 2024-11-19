package unisangil.parcialfinal.services;

import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisangil.parcialfinal.models.TransactionType;
import unisangil.parcialfinal.models.Transaction;
import unisangil.parcialfinal.repository.TransactionsRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public void saveTransaction(Transaction transaccion) {
        transactionsRepository.save(transaccion);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionsRepository.findAllByOrderByDateDesc(10);
    }

    @Override
    public Double getTotalIncome() {
        var allIncomes = transactionsRepository.findTransactionsByType(TransactionType.INCOME);
        return allIncomes.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
    }

    @Override
    public Double getTotalExpense() {
        var allExpenses = transactionsRepository.findTransactionsByType(TransactionType.EXPENSE);
        return allExpenses.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
    }

    @Override
    public Double getTotalNet() {
        return getTotalIncome() - getTotalExpense();
    }

}
