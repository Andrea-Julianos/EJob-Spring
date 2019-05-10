package com.zhibei.job.simple;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 简单任务，实现接口 SimpleJob
 */
@Component
public class DemoSimpleJob implements SimpleJob {
    private static final Logger log = LoggerFactory.getLogger(DemoSimpleJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("进入当前简单任务");
        // do something by sharding item 0
        log.info(String.format("Thread ID: %s, 作业分片总数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "作业名称: %s.作业自定义参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));
        switch (shardingContext.getShardingItem()) {
            case 0:
                log.info("简单任务分片-------------------0");

                break;
            case 1:
                log.info("简单任务分片-------------------1");
                // do something by sharding item 1
                break;
            case 2:
                log.info("简单任务分片-------------------2");
                // do something by sharding item 2
                break;
            default:
                System.out.println("no sharding");
                break;
        }


    }
}

