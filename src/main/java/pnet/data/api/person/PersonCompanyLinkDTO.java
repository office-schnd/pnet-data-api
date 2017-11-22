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
package pnet.data.api.person;

import java.time.LocalDateTime;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds one employment of a person.
 *
 * @author ham
 */
public class PersonCompanyLinkDTO
{

    private final Integer companyId;
    private final LocalDateTime validFrom;
    private final LocalDateTime validTo;
    private final Collection<PersonBrandLinkDTO> brands;
    private final Collection<PersonNumberTypeLinkDTO> numbers;

    public PersonCompanyLinkDTO(@JsonProperty("companyId") Integer companyId,
        @JsonProperty("validFrom") LocalDateTime validFrom, @JsonProperty("validTo") LocalDateTime validTo,
        @JsonProperty("brands") Collection<PersonBrandLinkDTO> brands,
        @JsonProperty("numbers") Collection<PersonNumberTypeLinkDTO> numbers)
    {
        super();

        this.companyId = companyId;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.brands = brands;
        this.numbers = numbers;
    }

    public Integer getCompanyId()
    {
        return companyId;
    }

    public LocalDateTime getValidFrom()
    {
        return validFrom;
    }

    public LocalDateTime getValidTo()
    {
        return validTo;
    }

    public Collection<PersonBrandLinkDTO> getBrands()
    {
        return brands;
    }

    public Collection<PersonNumberTypeLinkDTO> getNumbers()
    {
        return numbers;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((validFrom == null) ? 0 : validFrom.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        PersonCompanyLinkDTO other = (PersonCompanyLinkDTO) obj;

        if (companyId == null)
        {
            if (other.companyId != null)
            {
                return false;
            }
        }
        else if (!companyId.equals(other.companyId))
        {
            return false;
        }

        if (validFrom == null)
        {
            if (other.validFrom != null)
            {
                return false;
            }
        }
        else if (!validFrom.equals(other.validFrom))
        {
            return false;
        }

        return true;
    }

    @Override
    public String toString()
    {
        return String.format("PersonCompanyLinkDTO [companyId=%s, validFrom=%s, validTo=%s, brands=%s, numbers=%s]",
            companyId, validFrom, validTo, brands, numbers);
    }

}
