package com.example.nodb.impinfo.SharedInfoProject.mian;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusDTO {

    String statusCode;
    String statusDescription;
    int quantity;
}
