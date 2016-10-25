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


package org.shadowmask.web.api

import org.shadowmask.web.model.{MaskRule, MaskRuleParam, MaskType}

/**
  * mask rules supported .
  */
object MaskRules {
  implicit def t2Some[T](t: T) = Some[T](t)

  val commonParams = List(
    MaskRuleParam("hierarchyLevel", "level", "int")
  )

  val types = List(
    ("Email", "Email", "Email"),
    ("IP", "IP", "IP"),
    ("Phone", "Phone", "Phone"),
    ("Mobile", "Mobile", "Mobile"),
    ("Timestamp", "Timestamp", "Timestamp"),
    ("Cipher", "Cipher", "Cipher"),
    ("Generalizer", "Generalizer", "Generalizer"),
    ("Mask", "Mask", "Mask"),
    ("Mapping", "Mapping", "Mapping")
  )

  val commonRule = for ((name, showName, desc) <- types) yield MaskRule(name, showName, desc, commonParams)

  val rules = List(
    MaskType("1", "ID", "标示符", commonRule),
    MaskType("2", "HALF_ID", "半标示符", commonRule),
    MaskType("3","SENSITIVE","敏感数据",Nil),
    MaskType("4","NONE_SENSITIVE","非敏感数据",Nil)
  )

}
