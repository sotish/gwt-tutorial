package com.sansaretti.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sansaretti.client.ui.ChatOdasi;
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
			public void girisDurumu(boolean durum, String userName) {
				/*
				 * giris durumu basarili ise
				 */
				if (durum) {
					RootPanel.get().remove(userNamePanel);
					// Window.alert("giris basarili. Chat odasi gosterilecek.");
					/*
					 * chat odasini goster
					 */
					RootPanel.get().add(new ChatOdasi(userName));
				}
			}
		});

		RootPanel.get().add(userNamePanel);
	}
}
