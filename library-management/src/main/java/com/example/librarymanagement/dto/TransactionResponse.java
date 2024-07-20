package com.example.librarymanagement.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Component

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {


    private int id;
    private String externalTxnId;

    public  TransactionResponse fromTransaction(int bookId, String externalTxnId){

return TransactionResponse.builder()
        .id(bookId)
        .externalTxnId(externalTxnId)
        .build();
    }
}
