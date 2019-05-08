package com.winiter.everyutils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.Iterator;
import java.util.List;

public class ShareUtils {
    public static void sendEmail(Context context, String toEmail, String subject) {
        try {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:" + toEmail));
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            PackageManager pn = context.getPackageManager();
            List<ResolveInfo> apps = pn.queryIntentActivities(i, 0);
            Iterator<ResolveInfo> iterator = apps.iterator();
            if (iterator.hasNext()) {
                ResolveInfo ri = iterator.next();
                if (null == ri) {
                    context.startActivity(i);
                } else {
                    String packageName = ri.activityInfo.packageName;
                    String className = ri.activityInfo.name;
                    ComponentName cn = new ComponentName(packageName, className);
                    i.setComponent(cn);
                    context.startActivity(i);
                }
            } else {
                context.startActivity(i);
            }
        } catch (ActivityNotFoundException ignore) {
        }
    }
}
