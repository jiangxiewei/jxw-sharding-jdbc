/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.api.algorithm.sharding.hint;

import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.core.routing.strategy.ShardingAlgorithm;

import java.util.Collection;

/**
 * Sharding algorithm for hint without sharding keys.
 *
 * @author zhangliang
 */
public interface HintShardingAlgorithm extends ShardingAlgorithm {

    /**
     * Sharding.
     *
     * <p>sharding value injected by hint, not in SQL.</p>
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding result for data sources or tables's names
     */
    Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue);

    /**
     * 此方法为特别添加,为了在使用hint时也能解析表名,供我自己使用.
     * @param availableTargetNames available data sources or tables
     * @param logicalTableNames logical table names
     * @param shardingValue sharding value
     * @return the data sources or tables's names that you choise
     */
    Collection<String> doSharding(Collection<String> availableTargetNames, Collection<String> logicalTableNames, ShardingValue shardingValue);

}
