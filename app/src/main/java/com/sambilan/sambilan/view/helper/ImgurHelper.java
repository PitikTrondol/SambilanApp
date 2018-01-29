package com.sambilan.sambilan.view.helper;

/**
 * Created by Afriandi Haryanto on 1/30/2018.
 * THIS CLASS WILL BE DELETED WHEN THE IMAGE LINK IS FIXED
 */

public class ImgurHelper {

    private String imgurUrl;
    public ImgurHelper(final String url) {
        this.imgurUrl = url;
    }

    public String getDirectLink() {
        String https = "https://";
        String direct = this.imgurUrl.substring(0, (https.length()));
        direct+="i."+(this.imgurUrl.substring(https.length()))+".jpg";

        return  direct;
    }
}
