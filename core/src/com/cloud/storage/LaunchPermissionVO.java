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
package com.cloud.storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="launch_permission")
public class LaunchPermissionVO {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="template_id")
    private long templateId;

    @Column(name="account_id")
    private long accountId;

    public LaunchPermissionVO() { }

    public LaunchPermissionVO(long templateId, long accountId) {
        this.templateId = templateId;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public long getTemplateId() {
        return templateId;
    }

    public long getAccountId() {
        return accountId;
    }
}
