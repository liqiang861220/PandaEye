package com.pandaq.pandaeye.modules.dishorder.fragments;


import android.os.Bundle;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.CreateOrderActivity;
import com.pandaq.pandaeye.modules.dishorder.Views.ListContainer;
import com.pandaq.pandaeye.modules.dishorder.adapters.FoodAdapter;
import com.pandaq.pandaeye.modules.dishorder.adapters.TypeAdapter;
import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.shizhefei.fragment.LazyFragment;

public class FirstFragment extends LazyFragment {

	private ListContainer listContainer;
	private GroupsAndFoods groupsAndFoods;

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_first);
		listContainer = (ListContainer) findViewById(R.id.listcontainer);
		groupsAndFoods = (GroupsAndFoods) getArguments().getSerializable("initData");
		listContainer.initViewAndLoadData(groupsAndFoods.getCategories(),groupsAndFoods.getFoods());
		listContainer.setAddClick((CreateOrderActivity) getActivity());
	}

	public FoodAdapter getFoodAdapter() {
		return listContainer.foodAdapter;
	}

	public TypeAdapter getTypeAdapter() {
		return listContainer.typeAdapter;
	}

}
