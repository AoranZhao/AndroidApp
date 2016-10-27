package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class CardInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("client_ip")
    @Expose
    private String clientIp;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("livemode")
    @Expose
    private Boolean livemode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("used")
    @Expose
    private Boolean used;

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
     * The card
     */
    public Card getCard() {
        return card;
    }

    /**
     *
     * @param card
     * The card
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     *
     * @return
     * The clientIp
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     *
     * @param clientIp
     * The client_ip
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     *
     * @return
     * The created
     */
    public Integer getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The livemode
     */
    public Boolean getLivemode() {
        return livemode;
    }

    /**
     *
     * @param livemode
     * The livemode
     */
    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The used
     */
    public Boolean getUsed() {
        return used;
    }

    /**
     *
     * @param used
     * The used
     */
    public void setUsed(Boolean used) {
        this.used = used;
    }

}