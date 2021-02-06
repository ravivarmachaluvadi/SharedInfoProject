package com.example.nodb.impinfo.SharedInfoProject.mian;

public enum StatusCodes {

    ShippedAndInvoiced("3700.003"),
    ReturnInitiated("3700.01"),
    ReturnApproved("3700.05"),
    CREATED( "1100"),
    ReturnInvoiced("3950.01"),
    ReadyForInvoice("3950.100"),
    CANCELLED("9000"),
    ReturnRejected("9000.01");
    StatusCodes(String s) {
    }


}
