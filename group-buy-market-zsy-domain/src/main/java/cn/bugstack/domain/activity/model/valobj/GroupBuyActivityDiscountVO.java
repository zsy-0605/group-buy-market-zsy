package cn.bugstack.domain.activity.model.valobj;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyActivityDiscountVO {

    /*活动ID*/
    private String activityId;
    /*活动名称*/
    private String activityName;
    /*来源*/
    private String source;
    /*渠道*/
    private String channel;
    /*商品ID*/
    private String goodsId;
    /*折扣ID*/
    private GroupBuyDiscount groupBuyDiscount;
    /*拼团方式（0自动成团、1达成目标拼团）*/
    private String groupType;
    /*拼团次数限制*/
    private String takeLimitCount;
    /*拼团目标*/
    private Integer target;
    /**/
    private String validTime;
    /*拼团时长（分钟）*/
    private String status;
    /*活动状态（0创建、1生效、2过期、3废弃）*/
    private Date startTime;
    /*活动开始时间*/
    private Date endTime;
    /*活动结束时间*/
    private String tagId;
    /*人群标签规则标识*/
    private String tagScope;
    /*人群标签规则范围（多选；1可见限制、2参与限制）*/
    private String createTime;

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GroupBuyDiscount {
        /**
         * 折扣标题
         */
        private String discountName;

        /**
         * 折扣描述
         */
        private String discountDesc;

        /**
         * 折扣类型（0:base、1:tag）
         */
        private Byte discountType;

        /**
         * 营销优惠计划（ZJ:直减、MJ:满减、N元购）
         */
        private String marketPlan;

        /**
         * 营销优惠表达式
         */
        private String marketExpr;

        /**
         * 人群标签，特定优惠限定
         */
        private String tagId;
    }

}
