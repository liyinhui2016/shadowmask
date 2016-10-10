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

import org.json4s._
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.servlet.FileUploadSupport
import org.scalatra.swagger._
import org.shadowmask.web.common.user.{ConfiguredAuthProvider, User}
import org.shadowmask.web.model.{LoginResult, LoginResultData, SchemaResult, TableResult}

class DataApi(implicit val swagger: Swagger) extends ScalatraServlet
  with FileUploadSupport
  with JacksonJsonSupport
  with SwaggerSupport
  with ConfiguredAuthProvider {

  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "DataApi"
  override protected val applicationName: Option[String] = Some("data")

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }



  val dataSchemaGetOperation = (apiOperation[SchemaResult]("dataSchemaGet")
    summary "Adminstrator login api"
    parameters(formParam[String]("source").description(""))
    )

  get("/schema",operation(dataSchemaGetOperation)) {


    val source = params.getAs[String]("source")

    println("source: " + source)
  }



  val dataTableGetOperation = (apiOperation[TableResult]("dataTableGet")
    summary "get n-first record of a table"
    parameters(formParam[String]("table").description(""), formParam[Int]("rows").description(""))
    )

  get("/table",operation(dataTableGetOperation)) {


    val table = params.getAs[String]("table")

    println("table: " + table)


    val rows = params.getAs[Int]("rows")

    println("rows: " + rows)
  }


}
