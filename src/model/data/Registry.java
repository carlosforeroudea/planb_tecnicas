package model.data;

import java.time.ZonedDateTime;
import java.util.Locale;

public record Registry<InfoType, DataType, ExtraInfoType>(ZonedDateTime dateTime, Locale localization, InfoType i, DataType a, ExtraInfoType ex) {

    Registry(Locale localization, InfoType i, DataType a){
        this(ZonedDateTime.now(), Locale.getDefault(), i, a, null);
    }
    Registry(Locale localization, InfoType i, DataType a, ExtraInfoType ex){
        this(ZonedDateTime.now(), Locale.getDefault(), i, a, ex);
    }
    Registry(InfoType i, DataType a, ExtraInfoType ex){
        this(ZonedDateTime.now(), Locale.getDefault(), i, a, ex);
    }
    Registry(InfoType i, DataType a){
        this(ZonedDateTime.now(), Locale.getDefault(), i, a, null);
    }


}
