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
package pnet.data.api.function;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import pnet.data.api.brand.WithBrandLinks;
import pnet.data.api.companytype.WithTenantsAndCompanyTypeLinks;
import pnet.data.api.util.WithDescriptions;
import pnet.data.api.util.WithLabels;
import pnet.data.api.util.WithLastUpdate;
import pnet.data.api.util.WithMatchcode;

/**
 * Holds a Function.
 *
 * @author ham
 */
public class FunctionDataDTO implements WithMatchcode<FunctionMatchcode>, WithLabels, WithDescriptions, WithBrandLinks,
    WithTenantsAndCompanyTypeLinks, WithLastUpdate
{

    private final FunctionMatchcode matchcode;

    private Map<Locale, String> labels;
    private Map<Locale, String> descriptions;
    private Collection<FunctionBrandLinkDTO> brands;
    private Collection<FunctionCompanyTypeLinkDTO> companyTypes;
    private Collection<FunctionContractTypeLinkDTO> contractTypes;
    private Collection<FunctionNumberTypeLinkDTO> numberTypes;
    private Collection<FunctionActivityLinkDTO> activities;
    private Collection<FunctionInfoareaLinkDTO> infoareas;
    private LocalDateTime lastUpdate;

    public FunctionDataDTO(@JsonProperty("matchcode") FunctionMatchcode matchcode)
    {
        super();

        this.matchcode = matchcode;
    }

    @Override
    public FunctionMatchcode getMatchcode()
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
    public Collection<FunctionBrandLinkDTO> getBrands()
    {
        return brands;
    }

    public void setBrands(Collection<FunctionBrandLinkDTO> brands)
    {
        this.brands = brands;
    }

    @Override
    public Collection<FunctionCompanyTypeLinkDTO> getCompanyTypes()
    {
        return companyTypes;
    }

    public void setCompanyTypes(Collection<FunctionCompanyTypeLinkDTO> companyTypes)
    {
        this.companyTypes = companyTypes;
    }

    /**
     * @return This function is only available, if the company has one of these contracts. This collection is only
     *         relevant, if the company type of the company says so.
     */
    public Collection<FunctionContractTypeLinkDTO> getContractTypes()
    {
        return contractTypes;
    }

    public void setContractTypes(Collection<FunctionContractTypeLinkDTO> contractTypes)
    {
        this.contractTypes = contractTypes;
    }

    /**
     * @return The number types necessary for this function.
     */
    public Collection<FunctionNumberTypeLinkDTO> getNumberTypes()
    {
        return numberTypes;
    }

    public void setNumberTypes(Collection<FunctionNumberTypeLinkDTO> numberTypes)
    {
        this.numberTypes = numberTypes;
    }

    /**
     * @return The activities, that are linked to this function.
     */
    public Collection<FunctionActivityLinkDTO> getActivities()
    {
        return activities;
    }

    public void setActivities(Collection<FunctionActivityLinkDTO> activities)
    {
        this.activities = activities;
    }

    /**
     * @return The inforareas, that are linked to this function.
     */
    public Collection<FunctionInfoareaLinkDTO> getInfoareas()
    {
        return infoareas;
    }

    public void setInfoareas(Collection<FunctionInfoareaLinkDTO> infoareas)
    {
        this.infoareas = infoareas;
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
            "FunctionDataDTO [matchcode=%s, labels=%s, descriptions=%s, brands=%s, companyTypes=%s, contractTypes=%s, numberTypes=%s, activities=%s, infoareas=%s, lastUpdate=%s]",
            matchcode, labels, descriptions, brands, companyTypes, contractTypes, numberTypes, activities, infoareas,
            lastUpdate);
    }

}
