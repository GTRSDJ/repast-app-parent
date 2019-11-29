package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderCommentVo extends Order implements Serializable {

    @Column(name = "shop_id")
    private Long or_shopId;
    private Long orderId;
    private Long productId;
    private String memberNickName;

    private String productName;

    private Integer star;

    private String memberIp;


    private Integer showStatus;

    private String productAttribute;

    private Integer collectCouont;

    private Integer readCount;

    private String pics;

    private String memberIcon;

    private Integer replayCount;

    private String content;


}
