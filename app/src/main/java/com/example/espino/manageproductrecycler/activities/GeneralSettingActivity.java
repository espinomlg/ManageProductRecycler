package com.example.espino.manageproductrecycler.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.espino.manageproductrecycler.R;


public class GeneralSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }
}
