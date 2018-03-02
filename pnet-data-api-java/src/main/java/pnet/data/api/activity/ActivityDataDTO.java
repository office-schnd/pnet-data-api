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
package pnet.data.api.activity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import pnet.data.api.brand.BrandLinkDTO;
import pnet.data.api.companytype.CompanyTypeLinkDTO;
import pnet.data.api.contracttype.ContractTypeLinkDTO;
import pnet.data.api.util.WithDescriptions;
import pnet.data.api.util.WithLabels;
import pnet.data.api.util.WithLastUpdate;
import pnet.data.api.util.WithMatchcode;
import pnet.data.api.util.WithTenants;

/**
 * Holds an activity.
 *
 * @author ham
 */
public class ActivityDataDTO
    implements WithMatchcode, WithLabels, WithDescriptions, WithTenants, WithLastUpdate, Serializable
{

    private static final long serialVersionUID = 5133673955487263429L;

    private final String matchcode;

    private Map<Locale, String> labels;
    private Map<Locale, String> descriptions;
    private Collection<String> tenants;
    private Collection<BrandLinkDTO> brands;
    private Collection<CompanyTypeLinkDTO> companyTypes;
    private Collection<ContractTypeLinkDTO> contractTypes;
    private LocalDateTime lastUpdate;

    public ActivityDataDTO(@JsonProperty("matchcode") String matchcode)
    {
        super();

        this.matchcode = matchcode;
    }

    @Override
    public String getMatchcode()
    {
        return matchcode;
    }

    @Override
    public Map<Locale, String> getLabels()
    {
        return labels;
    }

    public void setLabels(Map<Locale, String> labels)
    {
        this.labels = labels;
    }

    @Override
    public Map<Locale, String> getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Map<Locale, String> descriptions)
    {
        this.descriptions = descriptions;
    }

    @Override
    public Collection<String> getTenants()
    {
        return tenants;
    }

    public void setTenants(Collection<String> tenants)
    {
        this.tenants = tenants;
    }

    public Collection<BrandLinkDTO> getBrands()
    {
        return brands;
    }

    public void setBrands(Collection<BrandLinkDTO> brands)
    {
        this.brands = brands;
    }

    public Collection<CompanyTypeLinkDTO> getCompanyTypes()
    {
        return companyTypes;
    }

    public void setCompanyTypes(Collection<CompanyTypeLinkDTO> companyTypes)
    {
        this.companyTypes = companyTypes;
    }

    /**
     * @return This activity is only available, if the company has one of these contracts. This collection is only
     *         relevant, if the company type of the company says so.
     */
    public Collection<ContractTypeLinkDTO> getContractTypes()
    {
        return contractTypes;
    }

    public void setContractTypes(Collection<ContractTypeLinkDTO> contractTypes)
    {
        this.contractTypes = contractTypes;
    }

    @Override
    public LocalDateTime getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString()
    {
        return String.format(
            "ActivityDataDTO [matchcode=%s, labels=%s, descriptions=%s, tenants=%s, brands=%s, companyTypes=%s, "
                + "contractTypes=%s, lastUpdate=%s]",
            matchcode, labels, descriptions, tenants, brands, companyTypes, contractTypes, lastUpdate);
    }

}
