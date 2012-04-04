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
package com.cloud.api.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cloud.api.ApiConstants;
import com.cloud.api.BaseListCmd;
import com.cloud.api.Implementation;
import com.cloud.api.Parameter;
import com.cloud.api.response.ConfigurationResponse;
import com.cloud.api.response.ListResponse;
import com.cloud.configuration.Configuration;

@Implementation(description = "Lists all configurations.", responseObject = ConfigurationResponse.class)
public class ListCfgsByCmd extends BaseListCmd {
    public static final Logger s_logger = Logger.getLogger(ListCfgsByCmd.class.getName());

    private static final String s_name = "listconfigurationsresponse";

    // ///////////////////////////////////////////////////
    // ////////////// API parameters /////////////////////
    // ///////////////////////////////////////////////////

    @Parameter(name = ApiConstants.CATEGORY, type = CommandType.STRING, description = "lists configurations by category")
    private String category;

    @Parameter(name = ApiConstants.NAME, type = CommandType.STRING, description = "lists configuration by name")
    private String configName;

    // ///////////////////////////////////////////////////
    // ///////////////// Accessors ///////////////////////
    // ///////////////////////////////////////////////////

    public String getCategory() {
        return category;
    }

    public String getConfigName() {
        return configName;
    }

    @Override
    public Long getPageSizeVal() {
        Long pageSizeVal = 500L;
        Integer pageSize = getPageSize();
        if (pageSize != null) {
            pageSizeVal = pageSize.longValue();
        }
        return pageSizeVal;
    }

    // ///////////////////////////////////////////////////
    // ///////////// API Implementation///////////////////
    // ///////////////////////////////////////////////////

    @Override
    public String getCommandName() {
        return s_name;
    }

    @Override
    public void execute() {
        List<? extends Configuration> result = _mgr.searchForConfigurations(this);
        ListResponse<ConfigurationResponse> response = new ListResponse<ConfigurationResponse>();
        List<ConfigurationResponse> configResponses = new ArrayList<ConfigurationResponse>();
        for (Configuration cfg : result) {
            ConfigurationResponse cfgResponse = _responseGenerator.createConfigurationResponse(cfg);
            cfgResponse.setObjectName("configuration");
            configResponses.add(cfgResponse);
        }

        response.setResponses(configResponses);
        response.setResponseName(getCommandName());
        this.setResponseObject(response);
    }
}
