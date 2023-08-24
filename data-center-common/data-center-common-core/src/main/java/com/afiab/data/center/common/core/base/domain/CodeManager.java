package com.afiab.data.center.common.core.base.domain;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 14:38
 * @Description:
 */
public class CodeManager {

    public interface SystemCode {
        /**
         * metadata系统-数据资产
         */
        String CODE_METADATA = "01";
        /**
         * scheduler系统-调度系统
         */
        String CODE_SCHEDULER = "02";
        /**
         * worker系统-作业执行系统
         */
        String CODE_WORKER = "03";
        /**
         * notifier系统 - 告警通知系统
         */
        String CODE_NOTIFIER = "04";
        /**
         * script系统 - 脚本系统
         */
        String CODE_SCRIPT = "05";
    }

    /**
     * 通用返回码
     */
    public interface CommonCode {

        /**
         * 操作成功
         */
        String CODE_200 = "200";

        /**
         * 操作失败
         */
        String CODE_500 = "500";

    }
}
