package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrailBalanceEntity;
import cn.bugstack.domain.activity.service.factory.DefaultActivityStrategyFactory;
import cn.bugstack.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{

    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrailBalanceEntity indexMarketTrial(MarketProductEntity marketProduct) throws Exception {

        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrailBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        TrailBalanceEntity trailBalanceEntity = strategyHandler.apply(new MarketProductEntity(), new DefaultActivityStrategyFactory.DynamicContext());

        return trailBalanceEntity;
    }
}
