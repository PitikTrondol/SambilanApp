package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 * benere ini bangsat, bikin class cuman isi nya satu variable aja.
 * cen og Sasmito ki
 */

public class ApplyJobBody {

    @SerializedName("job_id")
    int jobID;

    public ApplyJobBody(int jobID) {
        this.jobID = jobID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }
}
