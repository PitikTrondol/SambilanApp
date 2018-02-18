package com.sambilan.sambilan.view.adapter.employer;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Employee;
import com.sambilan.sambilan.utils.Base64ImageManager;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.adapter.employee.viewholder.BaseViewHolder;

/**
 * Created by Afriandi Haryanto on 2/12/2018.
 */

public class ListEmployeeHolder extends BaseViewHolder<Employee, ListJobListener> {

    private TextView tvTitle;
    private TextView tvCompany;
    private TextView tvLokasi;
    private TextView tvFee;

    private ImageView ivImage;
    private ImageView ivFee;
    private ImageView ivGedung;

    public ListEmployeeHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_jobTitle);
        tvCompany = itemView.findViewById(R.id.tv_company);
        tvLokasi = itemView.findViewById(R.id.tv_alamat);
        tvFee = itemView.findViewById(R.id.tv_bayaran);
        ivImage = itemView.findViewById(R.id.iv_item_image);

        ivGedung = itemView.findViewById(R.id.iv_gedung);
        ivGedung.setImageResource(R.drawable.ic_grade_black_24dp);

        ivFee = itemView.findViewById(R.id.iv_duit);
        ivFee.setImageResource(R.drawable.ic_phone_black_24dp);
    }

    @Override
    public void onBind(Employee data, @Nullable ListJobListener listener) {
        tvTitle.setText(data.getFullname());
        tvCompany.setText("Megang Baliho, Menyangga Gapura Kecamatan");
        tvLokasi.setText(data.getAddress());
        tvFee.setText(data.getPhone());

        if(null != data.getAvatarUrl() && !data.getAvatarUrl().equals("")) {
            ivImage.setImageBitmap(Base64ImageManager.getManager().decodeFromBase64ToBitmap(data.getAvatarUrl()));
        }
        else {
            //sementara
            ivImage.setImageBitmap(Base64ImageManager.getManager().setDefaultImage());
        }

    }
}
