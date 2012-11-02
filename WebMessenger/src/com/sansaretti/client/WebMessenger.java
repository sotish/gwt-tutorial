package com.sansaretti.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sansaretti.client.ui.UserNamePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebMessenger implements EntryPoint {
	UserNamePanel userNamePanel = null;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		userNamePanel = new UserNamePanel(new UserNamePanel.GirisListener() {

			@Override
			public void girisDurumu(boolean durum) {
				/*
				 * giris durumu basarili ise
				 */
				if (durum) {
					RootPanel.get().remove(userNamePanel);
					Window.alert("giris basarili. Chat odasi gosterilecek.");
					/* TODO sayfaya chat odasini yukle */
				}
			}
		});

		RootPanel.get().add(userNamePanel);
	}
}
