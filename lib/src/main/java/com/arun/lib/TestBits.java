package com.arun.lib;

import org.junit.Test;

public class TestBits {

    int FEATURE_FAVORITE_LOCATION = 1 << 17;
     @Deprecated int FEATURE_USE_NEW_AVAILABILITY_API = 1 << 18;
     int FEATURE_AUTO_ASSIGNMENT = 1 << 19;
     int FEATURE_PAX_NO_SHOW = 1 << 21;
     int FEATURE_WORDPRESS_TRAINING = 1 << 22;
     int FEATURE_PARTNER_BENEFITS = 1 << 23;
     @SuppressWarnings("unused") @Deprecated int FEATURE_NEW_IN_TRANSIT = 1 << 24;
     int FEATURE_GRABFOOD_CASH_ON_HAND = 1 << 25;
     int FEATURE_DRIVER_REFERRAL = 1 << 26;
     int FEATURE_IN_APP_NAV = 1 << 27;
     int FEATURE_POP = 1 << 28;
    @Deprecated  int FEATURE_NEW_PROFILE_SCREEN = 1 << 29;
    @Deprecated  int FEATURE_NEW_PROFILE_SCREEN2 = 1 << 30;

    /* AppFeatures to enable */
     long APP_FEATURE_FOOD_NEW_TRANSIT = 1L << 1;
     long APP_FEATURE_SCRIBE = 1L << 2;
     long APP_FEATURE_AA_FIRST_TIME_TUTORIAL = 1L << 3;
     long APP_FEATURE_PULL_BALANCE_ENABLED = 1L << 4;
     long APP_FEATURE_DRD_RN = 1L << 5;
     long APP_FEATURE_FOOD_INTEGRATE_MODE = 1L << 6;
    @Deprecated  long APP_FEATURE_HOME_V3 = 1L << 7;
     long APP_FEATURE_HEATMAPS_2018 = 1L << 8;
     long APP_FEATURE_DRIVER_SANDBOX = 1L << 9;
     long APP_FEATURE_AXONIFY_TRAINING = 1 << 10;
     long APP_FEATURE_EXPLICIT_CONSENT = 1 << 11;
     long APP_FEATURE_EXPLICIT_CONSENT_ADVERTISING = 1 << 12;
     long APP_FEATURE_CRASH_NDK = 1 << 13;
     long APP_FEATURE_SHORTCUT_DRAWER = 1 << 15;
     long APP_FEATURE_DISABLE_GRAB_NOW_HOME_SCREEN = 1 << 17;
     long APP_FEATURE_FOOD_TSP = 1 << 18;
     long APP_FEATURE_RECEIPT_V4 = 1 << 19;
     long APP_FEATURE_FOOD_ORDER_BATCHING = 1 << 20;

    
    int feature = 1098846421;
    long appFeature = 1436;

    int featureFlag = FEATURE_IN_APP_NAV;
    long appFeatureFlag = APP_FEATURE_AXONIFY_TRAINING;

    @Test
    public void test_FeatureFlag() {
        System.out.println("feature flag is " + compare(featureFlag, feature));
        System.out.println("App feature flag is " + compare(appFeatureFlag, appFeature));
    }



    public static boolean compare(final long typeToMatch,
                                  final long type) {
        return type >= 0L && (type & typeToMatch) == typeToMatch;
    }


    public static boolean compare(final int typeToMatch,
                                  final int type) {
        return type >= 0 && (type & typeToMatch) == typeToMatch;
    }


}
