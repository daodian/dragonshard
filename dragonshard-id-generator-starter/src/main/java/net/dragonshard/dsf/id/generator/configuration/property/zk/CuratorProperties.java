/*
 *   Copyright 1999-2018 dragonshard.net.
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package net.dragonshard.dsf.id.generator.configuration.property.zk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * curator 配置
 *
 * @author mayee
 * @version v1.0
 * @date 2019-07-08
 **/
@Component
@ConfigurationProperties(prefix = "dragonshard.id-generator.zookeeper.curator")
@Data
public class CuratorProperties {

  private String connectString;
  private Integer sessionTimeoutMs = 15000;
  private Integer connectionTimeoutMs = 15000;
  private String retryType;

  @NestedConfigurationProperty
  private ExponentialBackoffRetryProperties exponentialBackoffRetry = new ExponentialBackoffRetryProperties();

  @NestedConfigurationProperty
  private BoundedExponentialBackoffRetryProperties boundedExponentialBackoffRetry = new BoundedExponentialBackoffRetryProperties();

  @NestedConfigurationProperty
  private RetryNTimesProperties retryNTimes = new RetryNTimesProperties();

  @NestedConfigurationProperty
  private RetryForeverProperties retryForever = new RetryForeverProperties();

  @NestedConfigurationProperty
  private RetryUntilElapsedProperties retryUntilElapsed = new RetryUntilElapsedProperties();

}
