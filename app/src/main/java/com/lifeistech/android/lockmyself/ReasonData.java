package com.lifeistech.android.lockmyself;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by mikikyouka on 2017/07/08.
 */

public class ReasonData extends RealmObject {

        public String reason;
        public Date when;
        Date dt = new Date();

}