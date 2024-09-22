package com.utilitypayments.dto;


import lombok.Data;

@Data
public class PaymentAddressDTO {
    private Long id;
    private String address;
    private  UserDTO userdto;
}
