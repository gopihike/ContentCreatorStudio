package com.hackathon.contentcreatorstudio.contentstudio.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackathon.contentcreatorstudio.R;
import com.hackathon.contentcreatorstudio.contentstudio.adapters.ItemContentThemeAdapter;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;
import com.hackathon.contentcreatorstudio.contentstudio.viewmodels.ContentThemeVM;

import java.util.List;

public class ContentStudioThemeFragment extends Fragment {

    private ContentThemeVM contentThemeVM;
    private TextView contentTitleTv;
    private RecyclerView contentRv;
    private ItemContentThemeAdapter itemContentThemeAdapter;

    public ContentStudioThemeFragment() {}

    public static ContentStudioThemeFragment newInstance() {
        ContentStudioThemeFragment fragment = new ContentStudioThemeFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initViews();
        contentThemeVM = ViewModelProviders.of(this).get(ContentThemeVM.class);
        contentThemeVM.contentThemeLiveData.observe(this, new Observer<List<ContentStudioThemeCategory>>() {
            @Override
            public void onChanged(@Nullable List<ContentStudioThemeCategory> contentStudioThemeCategories) {
                if (contentStudioThemeCategories != null && !contentStudioThemeCategories.isEmpty()) {
                    itemContentThemeAdapter.updateData(contentStudioThemeCategories);
                }
            }
        });
        return inflater.inflate(R.layout.fragment_content_studio_theme, container, false);
    }

    private void initViews() {
        contentTitleTv = (TextView) getActivity().findViewById(R.id.content_title_tv);
        contentRv = (RecyclerView) getActivity().findViewById(R.id.content_rv);
        itemContentThemeAdapter = new ItemContentThemeAdapter(getActivity());
        contentRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        contentRv.setAdapter(itemContentThemeAdapter);
    }

}
