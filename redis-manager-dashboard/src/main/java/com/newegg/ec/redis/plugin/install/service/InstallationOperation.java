package com.newegg.ec.redis.plugin.install.service;

import com.newegg.ec.redis.entity.Machine;
import com.newegg.ec.redis.entity.RedisNode;
import com.newegg.ec.redis.plugin.install.entity.InstallationParam;

import java.util.List;

/**
 * @author Jay.H.Zou
 * @date 7/26/2019
 */
public interface InstallationOperation {

    int MIN_MEMORY_FREE = 10;

    /**
     *
     * @return
     */
    List<String> getImageList();

    /**
     * 检查机器内存CPU资源
     * 不同安装方式的环境监测
     * 检查所有机器之间是否网络相通, n! 次
     *
     * @param installationParam
     * @param machineList
     * @return
     */
    boolean checkEnvironment(InstallationParam installationParam, List<Machine> machineList);

    /**
     * 1.从内存中获取相应版本的配置
     * 2.根据不同安装方式更改相应的配置
     * 3.根据安装的集群模式更改配置
     *
     * @return
     */
    boolean buildConfig(InstallationParam installationParam);

    boolean pullImage(InstallationParam installationParam, List<Machine> machineList);

    boolean install(InstallationParam installationParam, List<Machine> machineList, List<RedisNode> redisNodeList);

}
