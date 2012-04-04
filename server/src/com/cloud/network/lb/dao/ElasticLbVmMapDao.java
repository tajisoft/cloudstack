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
package com.cloud.network.lb.dao;

import java.util.List;

import com.cloud.network.ElasticLbVmMapVO;
import com.cloud.network.LoadBalancerVO;
import com.cloud.utils.db.GenericDao;
import com.cloud.vm.DomainRouterVO;

public interface ElasticLbVmMapDao extends GenericDao<ElasticLbVmMapVO, Long> {
    ElasticLbVmMapVO findOneByLbIdAndElbVmId(long lbId, long elbVmId);
    ElasticLbVmMapVO findOneByIpIdAndElbVmId(long ipId, long elbVmId);
    ElasticLbVmMapVO findOneByIp(long ipId);

    List<ElasticLbVmMapVO> listByElbVmId(long elbVmId);
    List<ElasticLbVmMapVO> listByLbId(long lbId);
    int deleteLB(long lbId);
    List<DomainRouterVO> listUnusedElbVms();
    List<LoadBalancerVO> listLbsForElbVm(long elbVmId);
	
}
