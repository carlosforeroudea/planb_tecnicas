package model.util;

import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.logging.Logger;

public record Registry<ActionType, InfoType, ExtraInfoType>(ZonedDateTime dateTime, Locale localization, ActionType action, InfoType reducedInfo, ExtraInfoType extraInfo) {

    public Registry(Locale localization, ActionType action, InfoType reducedInfo){
        this(ZonedDateTime.now(), Locale.getDefault(), action, reducedInfo, null);
    }
    public Registry(Locale localization, ActionType action, InfoType reducedInfo, ExtraInfoType extraInfo){
        this(ZonedDateTime.now(), Locale.getDefault(), action, reducedInfo, extraInfo);
    }
    public Registry(ActionType action, InfoType reducedInfo, ExtraInfoType extraInfo){
        this(ZonedDateTime.now(), Locale.getDefault(), action, reducedInfo, extraInfo);
    }
    public Registry(ActionType action, InfoType reducedInfo){
        this(ZonedDateTime.now(), Locale.getDefault(), action, reducedInfo, null);
    }

}
