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

    private final String base64Image = "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";

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
            ivImage.setImageBitmap(Base64ImageManager.getManager().decodeFromBase64ToBitmap(base64Image));
        }

    }
}
