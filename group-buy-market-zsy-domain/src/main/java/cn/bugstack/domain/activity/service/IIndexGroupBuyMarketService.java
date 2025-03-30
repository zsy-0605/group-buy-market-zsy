package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrailBalanceEntity;

public interface IIndexGroupBuyMarketService {

    TrailBalanceEntity indexMarketTrial(MarketProductEntity marketProduct) throws Exception;

}
