package com.example.nodb.impinfo.SharedInfoProject.mian;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Order {
    String orderNumber;
    String omsOrderKey;
    String orderType;
    List<OrderLine> orderLines=new ArrayList<>();

}
