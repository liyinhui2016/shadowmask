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

package org.shadowmask.jdbc.connection;

import org.shadowmask.jdbc.connection.description.JDBCConnectionDesc;
import org.shadowmask.utils.ReThrow;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * a connection provider which can get() Connection from
 * a connection descriptor and release() Connection via method release();
 *
 * @param <DESC>
 */
public abstract class ConnectionProvider<DESC extends JDBCConnectionDesc>
    implements Supplier<Connection> {

  /**
   * get a connection from an jdbc connection description
   *
   * @param desc
   * @return
   */
  public abstract Connection get(DESC desc);

  /**
   * release a connection .
   *
   * @param connection
   */
  public void release(Connection connection) {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      ReThrow.rethrow(e);
    }
  }

}
