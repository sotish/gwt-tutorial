package com.sansaretti.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class ChatEntry extends Composite {

	private static ChatEntryUiBinder uiBinder = GWT
			.create(ChatEntryUiBinder.class);
	@UiField
	Label nameLabel;
	@UiField
	Label metinLabel;

	interface ChatEntryUiBinder extends UiBinder<Widget, ChatEntry> {
	}

	public ChatEntry(String userName, String text) {
		initWidget(uiBinder.createAndBindUi(this));

		nameLabel.setText(userName + " : ");
		metinLabel.setText(text);
	}
}
