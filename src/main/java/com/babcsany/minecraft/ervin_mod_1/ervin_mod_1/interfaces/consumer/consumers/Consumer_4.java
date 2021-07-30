/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers;

import org.apache.logging.log4j.util.ReadOnlyStringMap;

/**
 * An operation that accepts 4 input arguments and returns no result.
 *
 * @param <K> type of the 1. argument
 * @param <V> type of the 2. argument
 * @param <S> type of the 3. argument
 * @param <D> type of the 4. argument
 * @see ReadOnlyStringMap
 * @since 2.7
 */
public interface Consumer_4<K, V, S, D> {

    /**
     * Performs the operation given the specified arguments.
     * @param k the 1. input argument
     * @param v the 2. input argument
     * @param s the 3. input argument
     * @param d the 4. input argument
     */
    void accept(K k, V v, S s, D d);
}