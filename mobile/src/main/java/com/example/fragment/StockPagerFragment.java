package com.example.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.example.R;
import com.example.databinding.FragmentStockPagerBinding;
import com.example.ui.StockPagerView;
import com.example.viewmodel.StockPagerViewModel;

import org.alfonz.adapter.SimpleDataBoundPagerAdapter;


public class StockPagerFragment extends BaseFragment<StockPagerViewModel, FragmentStockPagerBinding> implements StockPagerView
{
	@Override
	public StockPagerViewModel setupViewModel()
	{
		StockPagerViewModel viewModel = ViewModelProviders.of(this).get(StockPagerViewModel.class);
		getLifecycle().addObserver(viewModel);
		return viewModel;
	}


	@Override
	public FragmentStockPagerBinding inflateBindingLayout(@NonNull LayoutInflater inflater)
	{
		return FragmentStockPagerBinding.inflate(inflater);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setupAdapter();
	}


	private void setupAdapter()
	{
		SimpleDataBoundPagerAdapter adapter = new SimpleDataBoundPagerAdapter(
				R.layout.fragment_stock_pager_item,
				this,
				getViewModel().lookups);
		getBinding().fragmentStockPagerPager.setAdapter(adapter);
	}
}
