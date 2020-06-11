package com.example.imlogin.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.imlogin.R;
import com.example.imlogin.adapter.ContactsAdapter;
import com.example.imlogin.utils.SharedPreferencesUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private ArrayList<String> list;
    private ContactsAdapter contactsAdapter;

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_contacts, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
        String curName = (String) SharedPreferencesUtils.getParam(getActivity(), "data", "a");
        ArrayList<String> names = new ArrayList<>();

        if (!curName.equals("a")) {
            names.add("a");
        }
        if (!curName.equals("b")) {
            names.add("b");
        }
        if (!curName.equals("c")) {
            names.add("c");
        }
        if (list.size() <= 0) {
            list.addAll(names);
        }
        contactsAdapter.notifyDataSetChanged();
    }

    private void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));

        list = new ArrayList<>();
        contactsAdapter = new ContactsAdapter(getActivity(), list);
        recycler.setAdapter(contactsAdapter);

        contactsAdapter.setOnClickListenerContacks(new ContactsAdapter.OnClickListenerContacks() {
            @Override
            public void onClick(String name) {
                Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
