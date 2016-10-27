package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class RatingSummary {

    @SerializedName("ratingTemplate")
    @Expose
    private RatingTemplate ratingTemplate;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("_id")
    @Expose
    private String Id;

    /**
     *
     * @return
     * The ratingTemplate
     */
    public RatingTemplate getRatingTemplate() {
        return ratingTemplate;
    }

    /**
     *
     * @param ratingTemplate
     * The ratingTemplate
     */
    public void setRatingTemplate(RatingTemplate ratingTemplate) {
        this.ratingTemplate = ratingTemplate;
    }

    /**
     *
     * @return
     * The score
     */
    public Double getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Double score) {
        this.score = score;
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

}