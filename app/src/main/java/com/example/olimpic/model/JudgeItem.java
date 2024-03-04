package com.example.olimpic.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class JudgeItem implements Parcelable {
    private Judge judge;
    private boolean isChecked;

    public JudgeItem() {
    }

    public JudgeItem(Judge judge, boolean isChecked) {
        this.judge = judge;
        this.isChecked = isChecked;
    }

    protected JudgeItem(Parcel in) {
        isChecked = in.readByte() != 0;
    }

    public static final Creator<JudgeItem> CREATOR = new Creator<JudgeItem>() {
        @Override
        public JudgeItem createFromParcel(Parcel in) {
            return new JudgeItem(in);
        }

        @Override
        public JudgeItem[] newArray(int size) {
            return new JudgeItem[size];
        }
    };

    public Judge getJudge() {
        return judge;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "JudgeItem{" +
                "judge=" + judge +
                ", isChecked=" + isChecked +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (isChecked ? 1 : 0));
    }
}