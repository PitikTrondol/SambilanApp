package com.sambilan.sambilan.view.adapter.employer;

import android.content.Context;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Employee;
import com.sambilan.sambilan.view.adapter.employee.BaseRecyclerAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;

/**
 * Created by Afriandi Haryanto on 2/12/2018.
 */

public class ListEmployeeAdapter extends BaseRecyclerAdapter<Employee, ListJobListener, ListEmployeeHolder> {

    public ListEmployeeAdapter(Context context) {
        super(context);
    }

    @Override
    public ListEmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListEmployeeHolder(inflate(R.layout.item_job, parent));
    }
}
