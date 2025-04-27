package com.admin.admin_service.Service;



import com.admin.admin_service.dto.TransactionDTO;
import com.admin.admin_service.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(TransactionDTO dto);

    List<Transaction> getAllTransactions();
}
