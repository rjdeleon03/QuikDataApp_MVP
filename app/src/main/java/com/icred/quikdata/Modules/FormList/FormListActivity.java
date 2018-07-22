package com.icred.quikdata.Modules.FormList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.icred.quikdata.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormListActivity extends AppCompatActivity {

    @BindView(R.id.menu_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }
}
