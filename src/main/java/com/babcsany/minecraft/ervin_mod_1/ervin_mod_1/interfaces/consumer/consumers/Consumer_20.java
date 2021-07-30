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
 * An operation that accepts 20 input arguments and returns no result.
 *
 * @param <K> type of the 1. argument
 * @param <V> type of the 2. argument
 * @param <S> type of the 3. argument
 * @param <D> type of the 4. argument
 * @param <G> type of the 5. argument
 * @param <H> type of the 6. argument
 * @param <R> type of the 7. argument
 * @param <E> type of the 8. argument
 * @param <F> type of the 9. argument
 * @param <O> type of the 10. argument
 * @param <N> type of the 11. argument
 * @param <L> type of the 12. argument
 * @param <P> type of the 13. argument
 * @param <W> type of the 14. argument
 * @param <A> type of the 15. argument
 * @param <M> type of the 16. argument
 * @param <C> type of the 17. argument
 * @param <B> type of the 18. argument
 * @param <X> type of the 19. argument
 * @param <J> type of the 20. argument
 * @see ReadOnlyStringMap
 * @since 2.7
 */
public interface Consumer_20<K, V, S, D, G, H, R, E, F, O, N, L, P, W, A, M, C, B, X, J> {

    /**
     * Performs the operation given the specified arguments.
     * @param k the 1. input argument
     * @param v the 2. input argument
     * @param s the 3. input argument
     * @param d the 4. input argument
     * @param g the 5. input argument
     * @param h the 6. input argument
     * @param r the 7. input argument
     * @param e the 8. input argument
     * @param f the 9. input argument
     * @param o the 10. input argument
     * @param n the 11. input argument
     * @param l the 12. input argument
     * @param p the 13. input argument
     * @param w the 14. input argument
     * @param a the 15. input argument
     * @param m the 16. input argument
     * @param c the 17. input argument
     * @param b the 18. input argument
     * @param x the 19. input argument
     * @param j the 20. input argument
     */
    void accept(K k, V v, S s, D d, G g, H h, R r, E e, F f, O o, N n, L l, P p, W w, A a, M m, C c, B b, X x, J j);
}
