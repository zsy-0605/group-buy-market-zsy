package cn.bugstack.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sku {

    /*自增*/
    private String id;
    /*来源*/
    private String source;
    /*渠道*/
    private String channel;
    /*商品ID*/
    private String goodsId;
    /*商品名称*/
    private String goodsName;
    /*商品原价*/
    private BigDecimal originalPrice;
    /*创建时间*/
    private String createTime;
    /*更新时间*/
    private String updateTime;

}
