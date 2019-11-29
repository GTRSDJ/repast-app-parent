package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_comment_replay")
public class CommentReplay implements Serializable {
    @Id
    private Long id;

    private Long commentId;

    private String memberNickName;

    private String memberIcon;

    private String content;

    private Date createTime;

    private Integer type;


}