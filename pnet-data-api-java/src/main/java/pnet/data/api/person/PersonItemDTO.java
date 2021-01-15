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

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pnet.data.api.util.WithLastUpdate;
import pnet.data.api.util.WithPersonId;
import pnet.data.api.util.WithScore;
import pnet.data.api.util.WithTenants;

/**
 * An result item for a search for persons.
 *
 * @author ham
 */
@ApiModel(description = "Holds basic information about a person")
public class PersonItemDTO implements WithPersonId, WithTenants, WithLastUpdate, WithScore, Serializable
{

    private static final long serialVersionUID = -481025382258675738L;

    @ApiModelProperty(notes = "The unique id of the person (needed scope: SC_IDENTIFIER).")
    private final Integer personId;

    @ApiModelProperty(notes = "The tenant, in which this person is administrated (no scope needed).")
    private final String administrativeTenant;

    @ApiModelProperty(notes = "The tenants where the person is valid (no scope needed).")
    private final Collection<String> tenants;

    @ApiModelProperty(notes = "The form of the adress the person prefers (needed scope: SC_GENDER).")
    private final FormOfAddress formOfAddress;

    @ApiModelProperty(notes = "The academic title of the person (needed scope: SC_NAME).")
    private final String academicTitle;

    @ApiModelProperty(notes = "The academic title of the person, placed after the name (needed scope: SC_NAME).")
    private final String academicTitlePostNominal;

    @ApiModelProperty(notes = "The first name of the person (needed scope: SC_NAME).")
    private final String firstName;

    @ApiModelProperty(notes = "The last name of the person (needed scope: SC_NAME).")
    private final String lastName;

    @ApiModelProperty(notes = "The username of the person (needed scope: SC_IDENTIFIER).")
    private final String username;

    @ApiModelProperty(notes = "The username of the person (needed scope: SC_IDENTIFIER).")
    private final Boolean credentialsAvailable;

    @ApiModelProperty(notes = "The external id of the person (needed scope: SC_IDENTIFIER).")
    private final String externalId;

    @ApiModelProperty(notes = "The global user id of the person (needed scope: SC_IDENTIFIER).")
    private final String guid;

    @ApiModelProperty(notes = "The preferred user id of the person (needed scope: SC_IDENTIFIER).")
    private final String preferredUserId;

    @ApiModelProperty(notes = "The personnel number of the person (needed scope: SC_IDENTIFIER).")
    private final String personnelNumber;

    @ApiModelProperty(notes = "The birthdate of the person (needed scope: SC_BIRTHDATE).")
    private final LocalDate birthdate;

    @ApiModelProperty(notes = "The email of the person (needed scope: SC_EMAIL).")
    private final String email;

    @ApiModelProperty(notes = "The phone number of the person (needed scope: SC_PHONE_NUMBER).")
    private final String phoneNumber;

    @ApiModelProperty(notes = "The mobile phone number of the person (needed scope: SC_PHONE_NUMBER).")
    private final String mobileNumber;

    @ApiModelProperty(notes = "The languages the person speaks (needed scope: SC_LANGUAGE).")
    private final Collection<Locale> languages;

    @ApiModelProperty(notes = "The companies of the persons (needed scope: SC_EMPLOYMENT).")
    private final Collection<ActivePersonCompanyLinkDTO> companies;

    @ApiModelProperty(notes = "All main functions of the person (needed scope: SC_ROLE).")
    private final Collection<ActivePersonFunctionLinkDTO> functions;

    @ApiModelProperty(notes = "The number types the person has at specific companies (needed scope: SC_IDENTIFIER).")
    private final Collection<ActivePersonNumberTypeLinkDTO> numbers;

    @ApiModelProperty(
        notes = "The id of the company the person is mainly busy at (needed scope: SC_PREFERRED_COMPANY).")
    private final Integer contactCompanyId;

    @ApiModelProperty(
        notes = "The matchcode of the company the person is mainly busy at (needed scope: SC_PREFERRED_COMPANY).")
    private final String contactCompanyMatchcode;

    @ApiModelProperty(
        notes = "The number of the company the person is mainly busy at (needed scope: SC_PREFERRED_COMPANY).")
    private final String contactCompanyNumber;

    @ApiModelProperty(notes = "Indicates, whether the person has a portrait available or not (needed scope: SC_IMAGE).")
    private final Boolean portraitAvailable;

    @ApiModelProperty(notes = "The time and date when this item has been changed recently (no scope needed).")
    private final LocalDateTime lastUpdate;

    @ApiModelProperty(notes = "The score this item accomplished in the search operation (no scope needed).")
    private final double score;

    public PersonItemDTO(@JsonProperty("personId") Integer personId,
        @JsonProperty("administrativeTenant") String administrativeTenant,
        @JsonProperty("tenants") Collection<String> tenants, @JsonProperty("formOfAddress") FormOfAddress formOfAddress,
        @JsonProperty("academicTitle") String academicTitle,
        @JsonProperty("academicTitlePostNominal") String academicTitlePostNominal,
        @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
        @JsonProperty("username") String username, @JsonProperty("credentialsAvailable") Boolean credentialsAvailable,
        @JsonProperty("externalId") String externalId, @JsonProperty("guid") String guid,
        @JsonProperty("preferredUserId") String preferredUserId,
        @JsonProperty("personnelNumber") String personnelNumber, @JsonProperty("birthdate") LocalDate birthdate,
        @JsonProperty("email") String email, @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("mobileNumber") String mobileNumber, @JsonProperty("languages") Collection<Locale> languages,
        @JsonProperty("companies") Collection<ActivePersonCompanyLinkDTO> companies,
        @JsonProperty("functions") Collection<ActivePersonFunctionLinkDTO> functions,
        @JsonProperty("numbers") Collection<ActivePersonNumberTypeLinkDTO> numbers,
        @JsonProperty("contactCompanyId") Integer contactCompanyId,
        @JsonProperty("contactCompanyMatchcode") String contactCompanyMatchcode,
        @JsonProperty("contactCompanyNumber") String contactCompanyNumber,
        @JsonProperty("portraitAvailable") Boolean portraitAvailable,
        @JsonProperty("lastUpdate") LocalDateTime lastUpdate, @JsonProperty("score") double score)
    {
        super();

        this.personId = personId;
        this.administrativeTenant = administrativeTenant;
        this.tenants = tenants;
        this.formOfAddress = formOfAddress;
        this.academicTitle = academicTitle;
        this.academicTitlePostNominal = academicTitlePostNominal;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.credentialsAvailable = credentialsAvailable;
        this.externalId = externalId;
        this.guid = guid;
        this.preferredUserId = preferredUserId;
        this.personnelNumber = personnelNumber;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.languages = languages;
        this.companies = companies;
        this.functions = functions;
        this.numbers = numbers;
        this.contactCompanyId = contactCompanyId;
        this.contactCompanyMatchcode = contactCompanyMatchcode;
        this.contactCompanyNumber = contactCompanyNumber;
        this.portraitAvailable = portraitAvailable;
        this.lastUpdate = lastUpdate;
        this.score = score;
    }

    @Override
    public Integer getPersonId()
    {
        return personId;
    }

    public String getAdministrativeTenant()
    {
        return administrativeTenant;
    }

    @Override
    public Collection<String> getTenants()
    {
        return tenants;
    }

    public FormOfAddress getFormOfAddress()
    {
        return formOfAddress;
    }

    public String getAcademicTitle()
    {
        return academicTitle;
    }

    public String getAcademicTitlePostNominal()
    {
        return academicTitlePostNominal;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUsername()
    {
        return username;
    }

    public Boolean getCredentialsAvailable()
    {
        return credentialsAvailable;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public String getGuid()
    {
        return guid;
    }

    public String getPreferredUserId()
    {
        return preferredUserId;
    }

    public String getPersonnelNumber()
    {
        return personnelNumber;
    }

    public LocalDate getBirthdate()
    {
        return birthdate;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public Collection<Locale> getLanguages()
    {
        return languages;
    }

    public Collection<ActivePersonCompanyLinkDTO> getCompanies()
    {
        return companies;
    }

    public Collection<ActivePersonFunctionLinkDTO> getFunctions()
    {
        return functions;
    }

    public Collection<ActivePersonNumberTypeLinkDTO> getNumbers()
    {
        return numbers;
    }

    public Integer getContactCompanyId()
    {
        return contactCompanyId;
    }

    public String getContactCompanyMatchcode()
    {
        return contactCompanyMatchcode;
    }

    public String getContactCompanyNumber()
    {
        return contactCompanyNumber;
    }

    public Boolean getPortraitAvailable()
    {
        return portraitAvailable;
    }

    @Override
    public LocalDateTime getLastUpdate()
    {
        return lastUpdate;
    }

    @Override
    public double getScore()
    {
        return score;
    }

    @Override
    public String toString()
    {
        return String
            .format(
                "PersonItemDTO [personId=%s, administrativeTenant=%s, tenants=%s, formOfAddress=%s, academicTitle=%s, "
                    + "academicTitlePostNominal=%s, firstName=%s, lastName=%s, username=%s, credentialsAvailable=%s, "
                    + "externalId=%s, guid=%s, preferredUserId=%s, personnelNumber=%s, birthdate=%s, email=%s, "
                    + "phoneNumber=%s, mobileNumber=%s, languages=%s, companies=%s, functions=%s, numbers=%s, "
                    + "contactCompanyId=%s, contactCompanyMatchcode=%s, contactCompanyNumber=%s, portraitAvailable=%s, "
                    + "lastUpdate=%s, score=%s]",
                personId, administrativeTenant, tenants, formOfAddress, academicTitle, academicTitlePostNominal,
                firstName, lastName, username, credentialsAvailable, externalId, guid, preferredUserId, personnelNumber,
                birthdate, email, phoneNumber, mobileNumber, languages, companies, functions, numbers, contactCompanyId,
                contactCompanyMatchcode, contactCompanyNumber, portraitAvailable, lastUpdate, score);
    }

}
