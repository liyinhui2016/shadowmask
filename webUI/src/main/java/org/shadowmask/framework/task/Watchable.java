/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.shadowmask.framework.task;

import java.util.List;

/**
 * @Description: class that can be watched by ProcedureWatcher.
 */
public interface Watchable<W extends ProcedureWatcher> {

  /**
   * register a Watcher
   *
   * @param watcher
   */
  void registerWatcher(W watcher);

  /**
   * unregister a Wather
   *
   * @param watcher
   */
  void unregisterWater(W watcher);

  /**
   * clear all watchers .
   */
  void clearAll();

  /**
   * get all registed watchers .
   *
   * @return
   */
  List<W> getAllWatchers();

}
