package com.gwt.client.mvp.view.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.client.i18n.Message;

public class AppLayout extends Composite {
	interface AppLayoutUiBinder extends UiBinder<Widget, AppLayout> { }
	private static AppLayoutUiBinder uiBinder = GWT.create(AppLayoutUiBinder.class);
	
	@UiField SimplePanel appContent;
	@UiField(provided = true)
	final Message i18n;
	@UiField
	Anchor login;
	@UiField
	Anchor greeting;
	public AppLayout() {
		this.i18n = GWT.create(Message.class);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public SimplePanel getAppContentHolder() {
		return this.appContent;
	}

	public Anchor getGreeting() {
		return greeting;
	}

	public void setGreeting(Anchor greeting) {
		this.greeting = greeting;
	}

	public Message getI18n() {
		return i18n;
	}

	public Anchor getLogin() {
		return login;
	}

	public void setLogin(Anchor login) {
		this.login = login;
	}

	public static AppLayoutUiBinder getUiBinder() {
		return uiBinder;
	}

	public static void setUiBinder(AppLayoutUiBinder uiBinder) {
		AppLayout.uiBinder = uiBinder;
	}
}
