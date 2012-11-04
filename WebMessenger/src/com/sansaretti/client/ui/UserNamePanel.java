package com.sansaretti.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserNamePanel extends Composite {
	/**
	 * ui.xml ile bu sinifin eslestirilmesi icin gerekli interface tanimi.
	 */
	interface UserNamePanelUiBinder extends UiBinder<Widget, UserNamePanel> {
	}

	/**
	 * binder olustur.
	 */
	private static UserNamePanelUiBinder uiBinder = GWT
			.create(UserNamePanelUiBinder.class);

	/**
	 * kullanicinin adini yazacagi text box
	 */
	@UiField
	TextBox adTextBox;
	/**
	 * chat'e baslama butonu.
	 */
	@UiField
	Button baslaButton;

	public UserNamePanel(final GirisListener girisListener) {
		/*
		 * Composite sinifinin icerigini binder ile doldur.
		 */
		initWidget(uiBinder.createAndBindUi(this));

		/*
		 * basla tusuna tiklaninca
		 */
		baslaButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				/*
				 * kullanici adini al
				 */
				String userName = adTextBox.getText();
				/*
				 * adi kontrol et
				 */
				if (userName == null || userName.isEmpty()) {
					/*
					 * kullaniciyi uyar.
					 */
					Window.alert("Lutfen adinizi giriniz.");
					/*
					 * UserNamePanel kullanicilarini uyar.
					 */
					girisListener.girisDurumu(false, null);
					return;
				}

				/*
				 * kullanici gecerli bir isim girdi. UserNamePanel
				 * kullanicilarini uyar.
				 */
				girisListener.girisDurumu(true, userName);
			}
		});
	}

	/**
	 * Uyenin adini girip, basla butonuna basma durumu icin.
	 * 
	 */
	public interface GirisListener {
		void girisDurumu(boolean durum, String userName);
	}
}
