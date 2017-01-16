package com.gwt.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.gwt.client.mvp.place.GreetingPlace;
import com.gwt.client.mvp.place.LoginPlace;


@WithTokenizers({LoginPlace.Tokenizer.class, GreetingPlace.Tokenizer.class})
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}
