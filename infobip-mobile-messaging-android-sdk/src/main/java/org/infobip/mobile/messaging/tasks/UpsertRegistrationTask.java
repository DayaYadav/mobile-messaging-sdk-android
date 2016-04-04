package org.infobip.mobile.messaging.tasks;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import org.infobip.mobile.messaging.MobileMessaging;
import org.infobip.mobile.messaging.api.registration.RegistrationResponse;

/**
 * @author mstipanov
 * @since 03.03.2016.
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class UpsertRegistrationTask extends AsyncTask<Object, Void, RegistrationResponse> {
    private final Context context;

    public UpsertRegistrationTask(Context context) {
        this.context = context;
    }

    @Override
    protected RegistrationResponse doInBackground(Object... notUsed) {
        try {
            return MobileApiResourceProvider.INSTANCE.getMobileApiRegistration(context).upsert(MobileMessaging.getInstance(context).getDeviceApplicationInstanceId(), MobileMessaging.getInstance(context).getRegistrationId());
        } catch (Exception e) {
            Log.e(MobileMessaging.TAG, "Error creating registration!", e);
            cancel(true);
            return null;
        }
    }
}