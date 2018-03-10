package com.qingmei2.rximagepicker.core;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;

import com.qingmei2.rximagepicker.ui.ICustomPickerView;

public final class ImagePickerProjector {

    private ICustomPickerView pickerView;

    private final boolean singleActivity;
    private final Class<? extends Activity> activityClass;
    private FragmentActivity fragmentActivity;
    private int containerViewId;
    private String viewKey;

    public ImagePickerProjector(boolean singleActivity,
                                String viewKey,
                                ICustomPickerView pickerView,
                                FragmentActivity fragmentActivity,
                                @IdRes int containerViewId,
                                Class<? extends Activity> activityClass) {
        this.pickerView = pickerView;
        this.fragmentActivity = fragmentActivity;
        this.containerViewId = containerViewId;
        this.viewKey = viewKey;
        this.singleActivity = singleActivity;
        this.activityClass = activityClass;
    }

    public void display() {
        if (singleActivity)
            displayPickerViewAsActivity();
        else
            displayPickerViewAsFragment();
    }

    private void displayPickerViewAsActivity() {
        ActivityHolder activityHolder = ActivityHolder.getInstance();
        activityHolder.setActivityClass(activityClass);
        activityHolder.display(fragmentActivity, containerViewId, viewKey);
    }

    private void displayPickerViewAsFragment() {
        pickerView.display(fragmentActivity, containerViewId, viewKey);
    }

}
