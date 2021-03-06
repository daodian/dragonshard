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

package net.dragonshard.dsf.id.generator.redis;

public interface RedisIdGenerator {

  /**
   * 获取全局唯一ID ID规则： 1. ID的前半部分为yyyyMMddHHmmssSSS格式的17位数字 2. ID的后半部分为由length(最大为8位，如果length大于8，则取8)决定，取值Redis对应Value，如果小于length所对应的数位，如果不足该数位，前面补足0
   * 例如Redis对应Value为1234，length为8，那么ID的后半部分为00001234；length为2，那么ID的后半部分为34
   *
   * @param name 资源名字
   * @param key 资源Key
   * @param step 递增值
   * @param length 长度
   * @return String
   */
  String nextUniqueId(String name, String key, int step, int length) throws Exception;

  String nextUniqueId(String compositeKey, int step, int length) throws Exception;

  String[] nextUniqueIds(String name, String key, int step, int length, int count) throws Exception;

  String[] nextUniqueIds(String compositeKey, int step, int length, int count) throws Exception;
}
