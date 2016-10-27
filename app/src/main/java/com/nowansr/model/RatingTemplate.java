package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class RatingTemplate {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("scale")
    @Expose
    private Integer scale;
    @SerializedName("expert")
    @Expose
    private Boolean expert;

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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     *
     * @param slug
     * The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
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
     * The scale
     */
    public Integer getScale() {
        return scale;
    }

    /**
     *
     * @param scale
     * The scale
     */
    public void setScale(Integer scale) {
        this.scale = scale;
    }

    /**
     *
     * @return
     * The expert
     */
    public Boolean getExpert() {
        return expert;
    }

    /**
     *
     * @param expert
     * The expert
     */
    public void setExpert(Boolean expert) {
        this.expert = expert;
    }

}