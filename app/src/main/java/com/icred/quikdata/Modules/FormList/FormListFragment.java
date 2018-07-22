package com.icred.quikdata.Modules.FormList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icred.quikdata.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormListFragment extends Fragment {


    public FormListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_list, container, false);
    }

}
