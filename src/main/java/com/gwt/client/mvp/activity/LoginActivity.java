package com.gwt.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwt.client.gin.Injector;
import com.gwt.client.mvp.view.ILoginView;


public class LoginActivity extends AbstractActivity implements ILoginView.ILoginPresenter {

	private final Injector injector = Injector.INSTANCE;

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		final ILoginView view = injector.getLoginView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
