package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Card {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("address_city")
    @Expose
    private Object addressCity;
    @SerializedName("address_country")
    @Expose
    private Object addressCountry;
    @SerializedName("address_line1")
    @Expose
    private Object addressLine1;
    @SerializedName("address_line1_check")
    @Expose
    private Object addressLine1Check;
    @SerializedName("address_line2")
    @Expose
    private Object addressLine2;
    @SerializedName("address_state")
    @Expose
    private Object addressState;
    @SerializedName("address_zip")
    @Expose
    private Object addressZip;
    @SerializedName("address_zip_check")
    @Expose
    private Object addressZipCheck;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("cvc_check")
    @Expose
    private String cvcCheck;
    @SerializedName("dynamic_last4")
    @Expose
    private Object dynamicLast4;
    @SerializedName("exp_month")
    @Expose
    private Integer expMonth;
    @SerializedName("exp_year")
    @Expose
    private Integer expYear;
    @SerializedName("funding")
    @Expose
    private String funding;
    @SerializedName("last4")
    @Expose
    private String last4;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("tokenization_method")
    @Expose
    private Object tokenizationMethod;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The object
     */
    public String getObject() {
        return object;
    }

    /**
     *
     * @param object
     * The object
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     *
     * @return
     * The addressCity
     */
    public Object getAddressCity() {
        return addressCity;
    }

    /**
     *
     * @param addressCity
     * The address_city
     */
    public void setAddressCity(Object addressCity) {
        this.addressCity = addressCity;
    }

    /**
     *
     * @return
     * The addressCountry
     */
    public Object getAddressCountry() {
        return addressCountry;
    }

    /**
     *
     * @param addressCountry
     * The address_country
     */
    public void setAddressCountry(Object addressCountry) {
        this.addressCountry = addressCountry;
    }

    /**
     *
     * @return
     * The addressLine1
     */
    public Object getAddressLine1() {
        return addressLine1;
    }

    /**
     *
     * @param addressLine1
     * The address_line1
     */
    public void setAddressLine1(Object addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     *
     * @return
     * The addressLine1Check
     */
    public Object getAddressLine1Check() {
        return addressLine1Check;
    }

    /**
     *
     * @param addressLine1Check
     * The address_line1_check
     */
    public void setAddressLine1Check(Object addressLine1Check) {
        this.addressLine1Check = addressLine1Check;
    }

    /**
     *
     * @return
     * The addressLine2
     */
    public Object getAddressLine2() {
        return addressLine2;
    }

    /**
     *
     * @param addressLine2
     * The address_line2
     */
    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     *
     * @return
     * The addressState
     */
    public Object getAddressState() {
        return addressState;
    }

    /**
     *
     * @param addressState
     * The address_state
     */
    public void setAddressState(Object addressState) {
        this.addressState = addressState;
    }

    /**
     *
     * @return
     * The addressZip
     */
    public Object getAddressZip() {
        return addressZip;
    }

    /**
     *
     * @param addressZip
     * The address_zip
     */
    public void setAddressZip(Object addressZip) {
        this.addressZip = addressZip;
    }

    /**
     *
     * @return
     * The addressZipCheck
     */
    public Object getAddressZipCheck() {
        return addressZipCheck;
    }

    /**
     *
     * @param addressZipCheck
     * The address_zip_check
     */
    public void setAddressZipCheck(Object addressZipCheck) {
        this.addressZipCheck = addressZipCheck;
    }

    /**
     *
     * @return
     * The brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     * The brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The cvcCheck
     */
    public String getCvcCheck() {
        return cvcCheck;
    }

    /**
     *
     * @param cvcCheck
     * The cvc_check
     */
    public void setCvcCheck(String cvcCheck) {
        this.cvcCheck = cvcCheck;
    }

    /**
     *
     * @return
     * The dynamicLast4
     */
    public Object getDynamicLast4() {
        return dynamicLast4;
    }

    /**
     *
     * @param dynamicLast4
     * The dynamic_last4
     */
    public void setDynamicLast4(Object dynamicLast4) {
        this.dynamicLast4 = dynamicLast4;
    }

    /**
     *
     * @return
     * The expMonth
     */
    public Integer getExpMonth() {
        return expMonth;
    }

    /**
     *
     * @param expMonth
     * The exp_month
     */
    public void setExpMonth(Integer expMonth) {
        this.expMonth = expMonth;
    }

    /**
     *
     * @return
     * The expYear
     */
    public Integer getExpYear() {
        return expYear;
    }

    /**
     *
     * @param expYear
     * The exp_year
     */
    public void setExpYear(Integer expYear) {
        this.expYear = expYear;
    }

    /**
     *
     * @return
     * The funding
     */
    public String getFunding() {
        return funding;
    }

    /**
     *
     * @param funding
     * The funding
     */
    public void setFunding(String funding) {
        this.funding = funding;
    }

    /**
     *
     * @return
     * The last4
     */
    public String getLast4() {
        return last4;
    }

    /**
     *
     * @param last4
     * The last4
     */
    public void setLast4(String last4) {
        this.last4 = last4;
    }

    /**
     *
     * @return
     * The name
     */
    public Object getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The tokenizationMethod
     */
    public Object getTokenizationMethod() {
        return tokenizationMethod;
    }

    /**
     *
     * @param tokenizationMethod
     * The tokenization_method
     */
    public void setTokenizationMethod(Object tokenizationMethod) {
        this.tokenizationMethod = tokenizationMethod;
    }

}
