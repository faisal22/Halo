package com.paranoid.halo;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (Utils.getStatus(this)) {
            String[] packages = Utils.loadArray(this);
            if(packages != null) {
                NotificationManager notificationManager =
                        (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                for(String packageName : packages){
                	// Upon onCreate, there needs to be a way to retrieve the package's customStatusBarIcon that can be passed to Utils.createNotification as a Package
                	// The best would be to be able to extract this from the packages default status bar icon
                    Utils.createNotification(this, notificationManager, /*packageName and customStatusBarIcon passed to createNotification*/ new Package(packageName, R.drawable.ic_status));
                }
            }
        }
        
        loadExtensions();
    }
    
    public void loadExtensions(){
    	SharedPreferences ext_prefs = PreferenceManager.getDefaultSharedPreferences(this);
   		
    		String note1 = ext_prefs.getString("ext_note1", null);
    		String note2 = ext_prefs.getString("ext_note2", null);
    		String note3 = ext_prefs.getString("ext_note3", null);
    		String note4 = ext_prefs.getString("ext_note4", null);
    		
    		NotificationManager ext_notification_manager =
					(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    		
    		Intent intent = new Intent(this, ExtensionsActivity.class);
    	    PendingIntent ext_intent = PendingIntent.getActivity(this, 0, intent, 0);
    		
    		try{	
    		if(note1.length() > 0){
    				NotificationCompat.Builder ext_builder =
    			        new NotificationCompat.Builder(this)
    					.setSmallIcon(R.drawable.ic_add)
    					.setContentIntent(ext_intent)
    			        .setContentTitle(note1);
    				
    				 Notification notif = ext_builder.build();
    		            notif.flags |= Notification.FLAG_ONGOING_EVENT;
    		            notif.priority = Notification.PRIORITY_MIN;
    		            notif.tickerText = note1;
    				ext_notification_manager.notify(1, notif);
    			}
    			if(note1.length() == 0){
    				ext_notification_manager.cancel(1);
    			}
    			
    			if(note2.length() > 0){
    				NotificationCompat.Builder ext_builder =
    			        new NotificationCompat.Builder(this)
    					.setSmallIcon(R.drawable.ic_add)
    					.setContentIntent(ext_intent)
    			        .setContentTitle(note2);
    				
    				Notification notif = ext_builder.build();
		            notif.flags |= Notification.FLAG_ONGOING_EVENT;
		            notif.priority = Notification.PRIORITY_MIN;
		            notif.tickerText = note2;
				ext_notification_manager.notify(2, notif);    			
				}
    			
    			if(note2.length() == 0){
    				ext_notification_manager.cancel(2);
    			}
    			
    			if(note3.length() > 0){
    				NotificationCompat.Builder ext_builder =
    			        new NotificationCompat.Builder(this)
    					.setSmallIcon(R.drawable.ic_add)
    					.setContentIntent(ext_intent)
    			        .setContentTitle(note3);
    				
    				Notification notif = ext_builder.build();
		            notif.flags |= Notification.FLAG_ONGOING_EVENT;
		            notif.priority = Notification.PRIORITY_MIN;
		            notif.tickerText = note3;
				ext_notification_manager.notify(3, notif);    			
				}
    			
    			if(note3.length() == 0){
    				ext_notification_manager.cancel(3);
    			}
    			
    			if(note4.length() > 0){
    				NotificationCompat.Builder ext_builder =
        			        new NotificationCompat.Builder(this)
        					.setSmallIcon(R.drawable.ic_add)
        					.setContentIntent(ext_intent)
        			        .setContentTitle(note4);
        				
        				 Notification notif = ext_builder.build();
        		            notif.flags |= Notification.FLAG_ONGOING_EVENT;
        		            notif.priority = Notification.PRIORITY_MIN;
        		            notif.tickerText = note4;
        				ext_notification_manager.notify(4, notif);     			
				}
    			
    			if(note4.length() == 0){
    				ext_notification_manager.cancel(4);
    			}
    			
    		}
    		catch(Exception e){
    			
    		}
    }
}
