package com.example.espino.manageproductrecycler.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.espino.manageproductrecycler.R;

/**
 * Created by espino on 8/11/16.
 */

public class AccountSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);

    }
}
