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

package org.shadowmask.core.mask.rules;

import org.apache.commons.lang.StringUtils;

public class MobileStrategy extends MaskEngineStrategy {
  public String evaluate(String mobile, int mask) {
    String sMask = Integer.toBinaryString(mask);
    char [] cMask = sMask.toCharArray();
    String [] subs = new String[3];
    if (subs.length < cMask.length) {
      throw new RuntimeException("Please input correct mask code!");
    }
    int distance = subs.length - cMask.length;

    subs[0] = mobile.substring(0, 3);
    subs[1] = mobile.substring(3, 7);
    subs[2] = mobile.substring(7, 11);

    for (int i = 0; i < cMask.length; i++) {
      if (cMask[i] == '1') {
        subs[distance + i] = subs[distance + i].replaceAll("\\d", "*");
      }
    }

    return StringUtils.join(subs, "");
  }

}