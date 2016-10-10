/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.shadowmask.core.discovery.rules;

import org.shadowmask.core.discovery.RuleContext;
import org.shadowmask.core.type.DataType;

public abstract class QusiIdentifierRule extends MaskBasicRule {

    protected RuleContext context = null;

    public QusiIdentifierRule(RuleContext context) {
        this.context = context;
        setPriority(2);
    }

    @Override
    public void execute() {
        this.context.setDataType(DataType.QUSI_IDENTIFIER);
    }
}
