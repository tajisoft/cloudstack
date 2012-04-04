// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.storage.swift;

import java.util.List;

import com.cloud.agent.api.to.SwiftTO;
import com.cloud.api.commands.AddSwiftCmd;
import com.cloud.api.commands.DeleteIsoCmd;
import com.cloud.api.commands.DeleteTemplateCmd;
import com.cloud.api.commands.ListSwiftsCmd;
import com.cloud.exception.DiscoveryException;
import com.cloud.storage.Swift;
import com.cloud.storage.SwiftVO;
import com.cloud.storage.VMTemplateSwiftVO;
import com.cloud.utils.component.Manager;
public interface SwiftManager extends Manager {

    SwiftTO getSwiftTO(Long swiftId);

    SwiftTO getSwiftTO();

    Swift addSwift(AddSwiftCmd cmd) throws DiscoveryException;

    boolean isSwiftEnabled();

    public boolean isTemplateInstalled(Long templateId);

    void deleteIso(DeleteIsoCmd cmd);

    void deleteTemplate(DeleteTemplateCmd cmd);

    void propagateTemplateOnAllZones(Long tmpltId);

    void propagateSwiftTmplteOnZone(Long zoneId);

    Long chooseZoneForTmpltExtract(Long tmpltId);

    List<SwiftVO> listSwifts(ListSwiftsCmd cmd);

    VMTemplateSwiftVO findByTmpltId(Long tmpltId);
}
