package com.nowansr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import com.nowansr.model.Charges;

//@Generated("org.jsonschema2pojo")
public class PaymentsInfo {

    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("paymentInfo")
    @Expose
    private PaymentInfo paymentInfo;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("default")
    @Expose
    private Boolean _default;
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("charges")
    @Expose
    private Charges charges;
    @SerializedName("paymentProvider")
    @Expose
    private String paymentProvider;

    /**
     *
     * @return
     * The paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @param paymentType
     * The paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     *
     * @return
     * The paymentInfo
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     *
     * @param paymentInfo
     * The paymentInfo
     */
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The _default
     */
    public Boolean getDefault() {
        return _default;
    }

    /**
     *
     * @param _default
     * The default
     */
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     *
     * @return
     * The valid
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     *
     * @param valid
     * The valid
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     *
     * @return
     * The charges
     */
    public Charges getCharges() {
        return charges;
    }

    /**
     *
     * @param charges
     * The charges
     */
    public void setCharges(Charges charges) {
        this.charges = charges;
    }

    /**
     *
     * @return
     * The paymentProvider
     */
    public String getPaymentProvider() {
        return paymentProvider;
    }

    /**
     *
     * @param paymentProvider
     * The paymentProvider
     */
    public void setPaymentProvider(String paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

}