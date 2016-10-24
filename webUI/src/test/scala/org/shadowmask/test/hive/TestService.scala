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

package org.shadowmask.test.hive

import org.shadowmask.framework.datacenter.hive.HiveDcContainer
import org.shadowmask.web.service.HiveService


object TestService {

  var dcContainer: HiveDcContainer = null;

  def initDcContainer(): Unit = {
    dcContainer = new HiveDcContainer
    dcContainer.initFromPropFile("hive_dc")
  }

  def testService(): Unit = {
    val service = new HiveService
    val res = service.getAllSchemas(dcContainer.getDc("dc1"))
    println(res)
  }

  def testAllSchemas(): Unit = {
    val service = new HiveService
    val res = service.getAllDcSchemas()
    println(res)
  }

  def testGetTables(): Unit = {
    val service = new HiveService
    val res = service.getAllTables("dc1", "testdb")
    println(res)
  }

  def getViewObject(): Unit = {
    val service = new HiveService
    val res = service.getSchemaViewObject()
    println(res)
  }

  def main(args: Array[String]) {
    initDcContainer()

    //    testService()

    //    testAllSchemas

    //    testGetTables()

    getViewObject()
  }

}
