package com.example.nodb.impinfo.SharedInfoProject.mian;

import java.util.*;
import java.util.stream.Collectors;

public class MainMethodClass {

    public static void main(String[] args) {

        Map<String, Set<String>> lineKeyStatusSetMap=new HashMap<>();

        StatusDTO sstatusDTO1=new StatusDTO();
        sstatusDTO1.setQuantity(1);
        sstatusDTO1.setStatusCode("3700.01");
        sstatusDTO1.setStatusDescription("Return Initiated");

        OrderLine sLine1=new OrderLine();
        sLine1.setLineNumber("1");
        sLine1.setOrderLineKey("11");
        sLine1.getStatusDTOS().add(sstatusDTO1);

        Order saleOrder1=new Order();
        saleOrder1.setOmsOrderKey("101");
        saleOrder1.setOrderNumber("1");
        saleOrder1.setOrderType("Sales");
        saleOrder1.getOrderLines().add(sLine1);


        StatusDTO sstatusDTO2=new StatusDTO();
        sstatusDTO2.setQuantity(1);
        sstatusDTO2.setStatusCode("3700.05");
        sstatusDTO2.setStatusDescription("Return Approved");

        StatusDTO sstatusDTO3=new StatusDTO();
        sstatusDTO3.setQuantity(1);
        sstatusDTO3.setStatusCode("3700.003");
        sstatusDTO3.setStatusDescription("Shipped And Invoiced");

        OrderLine sLine2=new OrderLine();
        sLine2.setLineNumber("2");
        sLine2.setOrderLineKey("22");
        sLine2.getStatusDTOS().add(sstatusDTO2);
        sLine2.getStatusDTOS().add(sstatusDTO3);

        Order saleOrder2=new Order();
        saleOrder2.setOmsOrderKey("101");
        saleOrder2.setOrderNumber("1");
        saleOrder2.setOrderType("Sales");
        saleOrder2.getOrderLines().add(sLine2);


        OrderLine sLine3=new OrderLine();

        Order returnOrder1=new Order();

        OrderLine rLine1=new OrderLine();
        OrderLine rLine2=new OrderLine();
        OrderLine rLine3=new OrderLine();

        StatusDTO rStatusDTO1=new StatusDTO();
        StatusDTO rStatusDTO2=new StatusDTO();
        StatusDTO rStatusDTO3=new StatusDTO();

        List<Order> orderList=new ArrayList<>();

        orderList.add(saleOrder1);
        orderList.add(saleOrder2);


        List<String> statusList=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().map(statusDTO -> statusDTO.getStatusCode()))).collect(Collectors.toList());

        List<StatusDTO> filteredStatusDTOS=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().filter(statusDTO -> statusDTO.getStatusCode()==StatusCodes.ReturnInitiated.name()))).collect(Collectors.toList());

        List<StatusDTO> filteredStatusDTOSV1=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().filter(statusDTO -> statusDTO.getStatusCode().equalsIgnoreCase("3700.01")))).collect(Collectors.toList());

       List<String> filteredStatusCodes= orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().filter(statusDTO -> statusDTO.getStatusCode().equalsIgnoreCase("3700.01")))).map(statusDTO -> statusDTO.getStatusDescription()).collect(Collectors.toList());


        System.out.println(statusList);

        System.out.println(filteredStatusDTOS);

        System.out.println(filteredStatusDTOSV1);

        System.out.println(filteredStatusCodes);

        List<String> sortedList=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().map(statusDTO -> statusDTO.getStatusCode()))).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());

        System.out.println(sortedList);

        String maxStatus=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().map(statusDTO -> statusDTO.getStatusCode()))).collect(Collectors.toList()).stream().max(String::compareTo).get();

        System.out.println(maxStatus);

        String misStatus=orderList.stream().flatMap(order -> order.getOrderLines().stream().flatMap(orderLine -> orderLine.getStatusDTOS().stream().map(statusDTO -> statusDTO.getStatusCode()))).collect(Collectors.toList()).stream().min(String::compareTo).get();

        System.out.println(misStatus);

        orderList.stream().flatMap(order -> order.getOrderLines().stream().map(orderLine -> lineKeyStatusSetMap.put(orderLine.orderLineKey,orderLine.getStatusDTOS().stream().map(statusDTO -> statusDTO.getStatusDescription()).collect(Collectors.toSet())))).collect(Collectors.toSet());

        for (Map.Entry<String,Set<String>> entry: lineKeyStatusSetMap.entrySet()) {

            System.out.println("Key :"+entry.getKey()+"  Value Set :"+entry.getValue());

        }

    }
}
