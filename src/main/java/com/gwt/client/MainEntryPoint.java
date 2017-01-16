package com.gwt.client;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.gwt.client.gin.Injector;
import com.gwt.client.mvp.view.layout.AppLayout;
import com.gwt.client.mvp.DemoActivityMapper;
import com.gwt.client.mvp.DemoPlaceHistoryMapper;
import com.gwt.client.mvp.place.LoginPlace;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MainEntryPoint implements EntryPoint {
	private SimplePanel containerWidget;
	private LoginPlace defaultPlace = new LoginPlace();

	@Override
	public void onModuleLoad() {
		final AppLayout mainLayout = new AppLayout();
		containerWidget = mainLayout.getAppContentHolder();
		final Injector injector = Injector.INSTANCE;
		EventBus eventBus = injector.getEventBus();
		PlaceController placeController = injector.getPlaceController();

		// activate activity manager and init display
		ActivityMapper activityMapper = new DemoActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(containerWidget);

		// display default view with activated history processing
		DemoPlaceHistoryMapper historyMapper = GWT.create(DemoPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(mainLayout);

		History.newItem("login:");
	}
}
