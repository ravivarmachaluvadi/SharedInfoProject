package com.example.nodb.impinfo.SharedInfoProject.mian;

public enum StatusCodes {

    CREATED( "1100"),
    CANCELLED("9000"),
    ReadyForInvoice("3950.100"),
    ReturnRejected("9000.01"),
    ReturnInvoiced("3950.01"),
    ShippedAndInvoiced("3700.003"),
    ReturnInitiated("3700.01"),
    ReturnApproved("3700.05");
    StatusCodes(String s) {
    }


}
