package cn.bugstack.api;

import cn.bugstack.api.response.Response;

/**
 * @author zhaoshunyi
 * @description DCC 动态配置中心
 * @create 2025-01-03 19:16
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
