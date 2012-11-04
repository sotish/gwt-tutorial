package com.sansaretti.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ChatOdasi extends Composite {

	private static ChatOdasiUiBinder uiBinder = GWT
			.create(ChatOdasiUiBinder.class);

	interface ChatOdasiUiBinder extends UiBinder<Widget, ChatOdasi> {
	}

	@UiField
	Button yazButton;
	@UiField
	VerticalPanel chatsPanel;
	@UiField
	Label usernameLabel;
	@UiField
	TextBox metinTextBox;
	String userName;

	public ChatOdasi(final String userName) {
		initWidget(uiBinder.createAndBindUi(this));
		this.userName = userName;
		usernameLabel.setText("Merhaba, " + userName);

		yazButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				gonder();
			}
		});

		metinTextBox.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					gonder();
				}
			}
		});
	}

	private void gonder() {
		chatsPanel.add(new ChatEntry(userName, metinTextBox.getText()));
		metinTextBox.setText("");
	}
}
