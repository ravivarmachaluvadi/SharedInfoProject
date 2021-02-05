package com.example.nodb.impinfo.SharedInfoProject.mian;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class OrderLine {

    String lineNumber;
    String orderLineKey;

    List<StatusDTO> statusDTOS= new ArrayList<>();

}
