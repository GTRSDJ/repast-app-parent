package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ums_shop_information")
public class Shop implements Serializable {

    @Id
    private Long id;
    @Column
    private Long ownerId;

    private String name;

    private String province;

    private String city;

    private String borough;

    private String address;

    private String lng;

    private String lat;

    private Byte closed;

    private String openTime;

    private String phone;

    private String images;

    private Byte status;

    private Date authStartTime;

    private Integer authLong;

    private Integer templateId;

    private String businessLicense;

    private String foodLicense;

    private String sanitationLicense;

    private String assess;

    private Long contractId;


}
