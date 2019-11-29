package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "oms_order")
public class Order implements Serializable {

    @Id
    private Long id;
    @Column
    private Long memberId;

    private Long shopId;

    private Long groupPromotionId;

    private Long couponId;

    private String orderSn;

    private Date createTime;

    private String memberUsername;

    private BigDecimal totalAmount;

    private BigDecimal payAmount;

    private BigDecimal freightAmount;

    private BigDecimal promotionAmount;

    private BigDecimal integrationAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountAmount;

    private Integer payType;

    private Integer sourceType;

    private Integer status;

    private Integer orderType;

    private String deliveryCompany;

    private String deliverySn;

    private Integer autoConfirmDay;

    private Integer integration;

    private Integer growth;

    private String promotionInfo;

    private Integer billType;

    private String billHeader;

    private String billContent;

    private String billReceiverPhone;

    private String billReceiverEmail;

    private String receiverName;

    private String receiverPhone;

    private String receiverPostCode;

    private String receiverProvince;

    private String receiverCity;

    private String receiverRegion;

    private String receiverDetailAddress;

    private String note;

    private Integer confirmStatus;

    private Integer deleteStatus;

    private Integer useIntegration;

    private Date paymentTime;

    private Date deliveryTime;

    private Date receiveTime;

    private Date commentTime;

    private Date modifyTime;
}