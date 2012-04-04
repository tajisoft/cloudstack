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
package com.cloud.agent.api.proxy;

import com.cloud.agent.api.CronCommand;

public class WatchConsoleProxyLoadCommand extends ProxyCommand implements CronCommand {

	private long proxyVmId;
	private String proxyVmName;
	private String proxyManagementIp;
	private int proxyCmdPort;
	int interval;
	
    public WatchConsoleProxyLoadCommand(int interval, long proxyVmId, String proxyVmName,
    	String proxyManagementIp, int proxyCmdPort) {
        this.interval = interval;
    	this.proxyVmId = proxyVmId;
		this.proxyVmName = proxyVmName;
		this.proxyManagementIp = proxyManagementIp;
		this.proxyCmdPort = proxyCmdPort;
    }
	
	protected WatchConsoleProxyLoadCommand() {
	}
	
	public long getProxyVmId() {
		return proxyVmId;
	}
	
	public String getProxyVmName() {
		return proxyVmName;
	}
	
	public String getProxyManagementIp() {
		return proxyManagementIp;
	}
	
	public int getProxyCmdPort() {
		return proxyCmdPort;
	}
	
	public int getInterval() {
	    return interval;
	}
	
	@Override
    public boolean executeInSequence() {
	    return false;
	}
}
