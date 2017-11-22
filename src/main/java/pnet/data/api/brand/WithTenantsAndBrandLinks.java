/* Copyright 2017 Porsche Informatik GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pnet.data.api.brand;

import java.util.Collection;
import java.util.stream.Collectors;

import pnet.data.api.tenant.Tenant;
import pnet.data.api.tenant.WithTenants;

/**
 * Provides tenants based on brands.
 *
 * @author ham
 */
public interface WithTenantsAndBrandLinks extends WithTenants, WithBrandLinks
{

    @Override
    default Collection<Tenant> getTenants()
    {
        return getBrands().stream().map(prerequisite -> prerequisite.getTenant()).collect(Collectors.toSet());
    }

}
