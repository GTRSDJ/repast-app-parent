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
public class CommentVo implements Serializable {


    private Long id;
    private Long usi_shop_id;
    private Long um_shop_id;
    private String usi_name;
    private String  um_username;
    private Long shopId;
    private Long orderId;
    private Long productId;

    private String memberNickName;

    private String productName;

    private Integer star;

    private String memberIp;

    private Date createTime;

    private Integer showStatus;

    private String productAttribute;

    private Integer collectCouont;

    private Integer readCount;

    private String pics;

    private String memberIcon;

    private Integer replayCount;

    private String content;

}
