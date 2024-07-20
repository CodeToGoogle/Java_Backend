package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.TransactionResponse;
import com.example.librarymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/transaction/issue")
    public ResponseEntity<TransactionResponse> issueTxn(@RequestParam("name") String name,
                                                       @RequestParam("studentId") int studentId
                           ) throws Exception{
         TransactionResponse response=transactionService.issueTxn(name, studentId);
         return ResponseEntity.ok(response);

    }
    @PostMapping("/transaction/return")
    public String returnTxn(@RequestParam("bookId")int bookId,
                            @RequestParam("studentId") int studentId) throws Exception {
        return transactionService.returnTxn(bookId,studentId);
    }
}
