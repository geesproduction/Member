/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.annotation.ColorInt
 *  android.support.annotation.ColorRes
 *  android.support.annotation.DrawableRes
 *  android.support.design.widget.CoordinatorLayout
 *  android.support.design.widget.CoordinatorLayout$Behavior
 *  android.support.design.widget.CoordinatorLayout$LayoutParams
 *  android.support.design.widget.FloatingActionButton
 *  android.support.v4.content.ContextCompat
 *  android.support.v4.view.ViewCompat
 *  android.support.v4.view.ViewPropertyAnimatorCompat
 *  android.support.v4.view.animation.LinearOutSlowInInterpolator
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewAnimationUtils
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.ViewPropertyAnimator
 *  android.view.WindowManager
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.OvershootInterpolator
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.aurelhubert.ahbottomnavigation.AHBottomNavigationBehavior
 *  com.aurelhubert.ahbottomnavigation.AHBottomNavigationFABBehavior
 *  com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
 *  com.aurelhubert.ahbottomnavigation.AHHelper
 *  com.aurelhubert.ahbottomnavigation.R
 *  com.aurelhubert.ahbottomnavigation.R$color
 *  com.aurelhubert.ahbottomnavigation.R$dimen
 *  com.aurelhubert.ahbottomnavigation.R$drawable
 *  com.aurelhubert.ahbottomnavigation.R$id
 *  com.aurelhubert.ahbottomnavigation.R$layout
 *  com.aurelhubert.ahbottomnavigation.R$styleable
 *  com.aurelhubert.ahbottomnavigation.notification.AHNotification
 *  com.aurelhubert.ahbottomnavigation.notification.AHNotificationHelper
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Locale
 */
package com.aurelhubert.ahbottomnavigation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationBehavior;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationFABBehavior;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHHelper;
import com.aurelhubert.ahbottomnavigation.R;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.aurelhubert.ahbottomnavigation.notification.AHNotificationHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class AHBottomNavigation
extends FrameLayout {
    public static final int CURRENT_ITEM_NONE = -1;
    private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS = "The position (%d) is out of bounds of the items (%d elements)";
    private static final int MAX_ITEMS = 5;
    private static final int MIN_ITEMS = 3;
    private static String TAG = "AHBottomNavigation";
    public static final int UPDATE_ALL_NOTIFICATIONS = -1;
    private View backgroundColorView;
    private boolean behaviorTranslationEnabled = true;
    private AHBottomNavigationBehavior<AHBottomNavigation> bottomNavigationBehavior;
    private int bottomNavigationHeight;
    private Animator circleRevealAnim;
    private boolean colored = false;
    @ColorInt
    private int coloredTitleColorActive;
    @ColorInt
    private int coloredTitleColorInactive;
    private Context context;
    private int currentColor = 0;
    private int currentItem = 0;
    private int defaultBackgroundColor = -1;
    private int defaultBackgroundResource = 0;
    private boolean forceTint = false;
    private boolean hideBottomNavigationWithAnimation = false;
    private boolean isBehaviorTranslationSet = false;
    private boolean isHidden = false;
    @ColorInt
    private int itemActiveColor;
    @ColorInt
    private int itemInactiveColor;
    private ArrayList<AHBottomNavigationItem> items = new ArrayList();
    private LinearLayout linearLayoutContainer;
    private int navigationBarHeight = 0;
    private OnNavigationPositionListener navigationPositionListener;
    private boolean needHideBottomNavigation = false;
    private float notSelectedItemWidth;
    private int notificationActiveMarginLeft;
    private int notificationActiveMarginTop;
    @ColorInt
    private int notificationBackgroundColor;
    private Drawable notificationBackgroundDrawable;
    private int notificationInactiveMarginLeft;
    private int notificationInactiveMarginTop;
    @ColorInt
    private int notificationTextColor;
    private Typeface notificationTypeface;
    private List<AHNotification> notifications = AHNotification.generateEmptyList((int)5);
    private Resources resources;
    private boolean selectedBackgroundVisible = false;
    private float selectedItemWidth;
    private OnTabSelectedListener tabSelectedListener;
    private float titleActiveTextSize;
    @ColorInt
    private int titleColorActive;
    @ColorInt
    private int titleColorInactive;
    private float titleInactiveTextSize;
    private TitleState titleState = TitleState.SHOW_WHEN_ACTIVE;
    private Typeface titleTypeface;
    private boolean translucentNavigationEnabled;
    private ArrayList<View> views = new ArrayList();

    public AHBottomNavigation(Context context) {
        super(context);
        AHBottomNavigation.super.init(context, null);
    }

    public AHBottomNavigation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AHBottomNavigation.super.init(context, attributeSet);
    }

    public AHBottomNavigation(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        AHBottomNavigation.super.init(context, attributeSet);
    }

    @SuppressLint(value={"NewApi"})
    @TargetApi(value=21)
    private int calculateHeight(int n) {
        if (!this.translucentNavigationEnabled) {
            return n;
        }
        int n2 = this.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (n2 > 0) {
            this.navigationBarHeight = this.resources.getDimensionPixelSize(n2);
        }
        int[] arrn = new int[]{16842973, 16843760};
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(arrn);
        typedArray.getBoolean(0, false);
        boolean bl = typedArray.getBoolean(1, true);
        if (this.hasImmersive() && bl) {
            n += this.navigationBarHeight;
        }
        typedArray.recycle();
        return n;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void createClassicItems(LinearLayout linearLayout) {
        int n;
        LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
        float f = this.resources.getDimension(R.dimen.bottom_navigation_height);
        float f2 = this.resources.getDimension(R.dimen.bottom_navigation_min_width);
        float f3 = this.resources.getDimension(R.dimen.bottom_navigation_max_width);
        if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            f2 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_min_width);
            f3 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_max_width);
        }
        if ((n = this.getWidth()) == 0 || this.items.size() == 0) {
            return;
        }
        float f4 = n / this.items.size();
        if (f4 < f2) {
            f4 = f2;
        } else if (f4 > f3) {
            f4 = f3;
        }
        float f5 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_active);
        float f6 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_inactive);
        int n2 = (int)this.resources.getDimension(R.dimen.bottom_navigation_margin_top_active);
        if (this.titleActiveTextSize != 0.0f && this.titleInactiveTextSize != 0.0f) {
            f5 = this.titleActiveTextSize;
            f6 = this.titleInactiveTextSize;
        } else if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            f5 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_active);
            f6 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_inactive);
        }
        int n3 = 0;
        do {
            if (n3 >= this.items.size()) {
                AHBottomNavigation.super.updateNotifications(true, -1);
                return;
            }
            boolean bl = this.currentItem == n3;
            final int n4 = n3;
            AHBottomNavigationItem aHBottomNavigationItem = (AHBottomNavigationItem)this.items.get(n4);
            View view = layoutInflater.inflate(R.layout.bottom_navigation_item, (ViewGroup)this, false);
            FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.bottom_navigation_container);
            ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_item_icon);
            TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_item_title);
            TextView textView2 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
            imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
            textView.setText((CharSequence)aHBottomNavigationItem.getTitle(this.context));
            if (this.titleTypeface != null) {
                textView.setTypeface(this.titleTypeface);
            }
            if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
                frameLayout.setPadding(0, frameLayout.getPaddingTop(), 0, frameLayout.getPaddingBottom());
            }
            if (bl) {
                if (this.selectedBackgroundVisible) {
                    view.setSelected(true);
                }
                imageView.setSelected(true);
                if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, n2, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams)textView2.getLayoutParams();
                    marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    view.requestLayout();
                }
            } else {
                imageView.setSelected(false);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)textView2.getLayoutParams();
                marginLayoutParams.setMargins(this.notificationInactiveMarginLeft, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (this.colored) {
                if (bl) {
                    this.setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                    this.currentColor = aHBottomNavigationItem.getColor(this.context);
                }
            } else if (this.defaultBackgroundResource != 0) {
                this.setBackgroundResource(this.defaultBackgroundResource);
            } else {
                this.setBackgroundColor(this.defaultBackgroundColor);
            }
            Drawable drawable = ((AHBottomNavigationItem)this.items.get(n3)).getDrawable(this.context);
            int n5 = bl ? this.itemActiveColor : this.itemInactiveColor;
            boolean bl2 = this.forceTint;
            imageView.setImageDrawable(AHHelper.getTintDrawable((Drawable)drawable, (int)n5, (boolean)bl2));
            int n6 = bl ? this.itemActiveColor : this.itemInactiveColor;
            textView.setTextColor(n6);
            float f7 = bl ? f5 : f6;
            textView.setTextSize(0, f7);
            View.OnClickListener onClickListener = new View.OnClickListener(){

                public void onClick(View view) {
                    AHBottomNavigation.this.updateItems(n4, true);
                }
            };
            view.setOnClickListener(onClickListener);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int)f4, (int)f);
            linearLayout.addView(view, (ViewGroup.LayoutParams)layoutParams);
            this.views.add((Object)view);
            ++n3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void createItems() {
        if (this.items.size() < 3) {
            Log.w((String)TAG, (String)"The items list should have at least 3 items");
        } else if (this.items.size() > 5) {
            Log.w((String)TAG, (String)"The items list should not have more than 5 items");
        }
        int n = (int)this.resources.getDimension(R.dimen.bottom_navigation_height);
        this.removeAllViews();
        this.views.clear();
        this.backgroundColorView = new View(this.context);
        if (Build.VERSION.SDK_INT >= 21) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.calculateHeight(n));
            this.addView(this.backgroundColorView, (ViewGroup.LayoutParams)layoutParams);
            this.bottomNavigationHeight = n;
        }
        this.linearLayoutContainer = new LinearLayout(this.context);
        this.linearLayoutContainer.setOrientation(0);
        this.linearLayoutContainer.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n);
        this.addView((View)this.linearLayoutContainer, (ViewGroup.LayoutParams)layoutParams);
        if (this.titleState != TitleState.ALWAYS_HIDE && (this.items.size() == 3 || this.titleState == TitleState.ALWAYS_SHOW)) {
            this.createClassicItems(this.linearLayoutContainer);
        } else {
            this.createSmallItems(this.linearLayoutContainer);
        }
        this.post(new Runnable(){

            public void run() {
                AHBottomNavigation.this.requestLayout();
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    private void createSmallItems(LinearLayout linearLayout) {
        float f;
        LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
        float f2 = this.resources.getDimension(R.dimen.bottom_navigation_height);
        float f3 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_min_width);
        float f4 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_max_width);
        int n = this.getWidth();
        if (n == 0 || this.items.size() == 0) {
            return;
        }
        float f5 = n / this.items.size();
        if (f5 < f3) {
            f5 = f3;
        } else if (f5 > f4) {
            f5 = f4;
        }
        int n2 = (int)this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top_active);
        float f6 = this.resources.getDimension(R.dimen.bottom_navigation_small_selected_width_difference);
        this.selectedItemWidth = f5 + f6 * (float)this.items.size();
        this.notSelectedItemWidth = f = f5 - f6;
        int n3 = 0;
        do {
            if (n3 >= this.items.size()) {
                AHBottomNavigation.super.updateNotifications(true, -1);
                return;
            }
            final int n4 = n3;
            AHBottomNavigationItem aHBottomNavigationItem = (AHBottomNavigationItem)this.items.get(n4);
            View view = layoutInflater.inflate(R.layout.bottom_navigation_small_item, (ViewGroup)this, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_small_item_icon);
            TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_small_item_title);
            TextView textView2 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
            imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
            if (this.titleState != TitleState.ALWAYS_HIDE) {
                textView.setText((CharSequence)aHBottomNavigationItem.getTitle(this.context));
            }
            if (this.titleActiveTextSize != 0.0f) {
                textView.setTextSize(0, this.titleActiveTextSize);
            }
            if (this.titleTypeface != null) {
                textView.setTypeface(this.titleTypeface);
            }
            if (n3 == this.currentItem) {
                if (this.selectedBackgroundVisible) {
                    view.setSelected(true);
                }
                imageView.setSelected(true);
                if (this.titleState != TitleState.ALWAYS_HIDE && view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, n2, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams)textView2.getLayoutParams();
                    marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, this.notificationActiveMarginTop, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    view.requestLayout();
                }
            } else {
                imageView.setSelected(false);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)textView2.getLayoutParams();
                marginLayoutParams.setMargins(this.notificationInactiveMarginLeft, this.notificationInactiveMarginTop, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (this.colored) {
                if (n3 == this.currentItem) {
                    this.setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                    this.currentColor = aHBottomNavigationItem.getColor(this.context);
                }
            } else if (this.defaultBackgroundResource != 0) {
                this.setBackgroundResource(this.defaultBackgroundResource);
            } else {
                this.setBackgroundColor(this.defaultBackgroundColor);
            }
            Drawable drawable = ((AHBottomNavigationItem)this.items.get(n3)).getDrawable(this.context);
            int n5 = this.currentItem == n3 ? this.itemActiveColor : this.itemInactiveColor;
            boolean bl = this.forceTint;
            imageView.setImageDrawable(AHHelper.getTintDrawable((Drawable)drawable, (int)n5, (boolean)bl));
            int n6 = this.currentItem == n3 ? this.itemActiveColor : this.itemInactiveColor;
            textView.setTextColor(n6);
            float f7 = this.currentItem == n3 ? 1.0f : 0.0f;
            textView.setAlpha(f7);
            View.OnClickListener onClickListener = new View.OnClickListener(){

                public void onClick(View view) {
                    AHBottomNavigation.this.updateSmallItems(n4, true);
                }
            };
            view.setOnClickListener(onClickListener);
            int n7 = n3 == this.currentItem ? (int)this.selectedItemWidth : (int)f;
            if (this.titleState == TitleState.ALWAYS_HIDE) {
                n7 = (int)(1.16 * (double)f);
            }
            int n8 = (int)f2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n7, n8);
            linearLayout.addView(view, (ViewGroup.LayoutParams)layoutParams);
            this.views.add((Object)view);
            ++n3;
        } while (true);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        this.context = context;
        this.resources = this.context.getResources();
        if (attributeSet != null) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.AHBottomNavigationBehavior_Params, 0, 0);
            this.selectedBackgroundVisible = typedArray.getBoolean(R.styleable.AHBottomNavigationBehavior_Params_selectedBackgroundVisible, false);
            this.translucentNavigationEnabled = typedArray.getBoolean(R.styleable.AHBottomNavigationBehavior_Params_translucentNavigationEnabled, false);
        }
        this.notificationTextColor = ContextCompat.getColor((Context)context, (int)17170443);
        this.bottomNavigationHeight = (int)this.resources.getDimension(R.dimen.bottom_navigation_height);
        this.titleColorActive = ContextCompat.getColor((Context)context, (int)R.color.colorBottomNavigationAccent);
        this.titleColorInactive = ContextCompat.getColor((Context)context, (int)R.color.colorBottomNavigationInactive);
        this.coloredTitleColorActive = ContextCompat.getColor((Context)context, (int)R.color.colorBottomNavigationActiveColored);
        this.coloredTitleColorInactive = ContextCompat.getColor((Context)context, (int)R.color.colorBottomNavigationInactiveColored);
        this.itemActiveColor = this.titleColorActive;
        this.itemInactiveColor = this.titleColorInactive;
        this.notificationActiveMarginLeft = (int)this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_left_active);
        this.notificationInactiveMarginLeft = (int)this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_left);
        this.notificationActiveMarginTop = (int)this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_top_active);
        this.notificationInactiveMarginTop = (int)this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_top);
        ViewCompat.setElevation((View)this, (float)this.resources.getDimension(R.dimen.bottom_navigation_elevation));
        this.setClipToPadding(false);
        this.setLayoutParams(new ViewGroup.LayoutParams(-1, this.bottomNavigationHeight));
        return;
        finally {
            typedArray.recycle();
        }
    }

    private boolean isClassic() {
        return this.titleState == TitleState.ALWAYS_SHOW || this.items.size() <= 3 && this.titleState != TitleState.ALWAYS_SHOW;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void updateItems(final int n, boolean bl) {
        if (this.currentItem == n) {
            if (this.tabSelectedListener == null) return;
            if (!bl) return;
            this.tabSelectedListener.onTabSelected(n, true);
            return;
        }
        if (this.tabSelectedListener != null && bl) {
            if (!this.tabSelectedListener.onTabSelected(n, false)) return;
        }
        int n2 = (int)this.resources.getDimension(R.dimen.bottom_navigation_margin_top_active);
        int n3 = (int)this.resources.getDimension(R.dimen.bottom_navigation_margin_top_inactive);
        float f = this.resources.getDimension(R.dimen.bottom_navigation_text_size_active);
        float f2 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_inactive);
        if (this.titleActiveTextSize != 0.0f && this.titleInactiveTextSize != 0.0f) {
            f = this.titleActiveTextSize;
            f2 = this.titleInactiveTextSize;
        } else if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            f = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_active);
            f2 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_inactive);
        }
        for (int i = 0; i < this.views.size(); ++i) {
            View view = (View)this.views.get(i);
            if (this.selectedBackgroundVisible) {
                boolean bl2 = i == n;
                view.setSelected(bl2);
            }
            if (i == n) {
                TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_item_title);
                ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_item_icon);
                TextView textView2 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
                imageView.setSelected(true);
                AHHelper.updateTopMargin((View)imageView, (int)n3, (int)n2);
                AHHelper.updateLeftMargin((View)textView2, (int)this.notificationInactiveMarginLeft, (int)this.notificationActiveMarginLeft);
                AHHelper.updateTextColor((TextView)textView, (int)this.itemInactiveColor, (int)this.itemActiveColor);
                AHHelper.updateTextSize((TextView)textView, (float)f2, (float)f);
                AHHelper.updateDrawableColor((Context)this.context, (Drawable)((AHBottomNavigationItem)this.items.get(n)).getDrawable(this.context), (ImageView)imageView, (int)this.itemInactiveColor, (int)this.itemActiveColor, (boolean)this.forceTint);
                if (Build.VERSION.SDK_INT >= 21 && this.colored) {
                    int n4 = Math.max((int)this.getWidth(), (int)this.getHeight());
                    int n5 = (int)view.getX() + view.getWidth() / 2;
                    int n6 = view.getHeight() / 2;
                    if (this.circleRevealAnim != null && this.circleRevealAnim.isRunning()) {
                        this.circleRevealAnim.cancel();
                        this.setBackgroundColor(((AHBottomNavigationItem)this.items.get(n)).getColor(this.context));
                        this.backgroundColorView.setBackgroundColor(0);
                    }
                    this.circleRevealAnim = ViewAnimationUtils.createCircularReveal((View)this.backgroundColorView, (int)n5, (int)n6, (float)0.0f, (float)n4);
                    this.circleRevealAnim.setStartDelay(5L);
                    this.circleRevealAnim.addListener(new Animator.AnimatorListener(){

                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            AHBottomNavigation.this.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(n)).getColor(AHBottomNavigation.this.context));
                            AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(n)).getColor(AHBottomNavigation.this.context));
                        }
                    });
                    this.circleRevealAnim.start();
                    continue;
                }
                if (this.colored) {
                    AHHelper.updateViewBackgroundColor((View)this, (int)this.currentColor, (int)((AHBottomNavigationItem)this.items.get(n)).getColor(this.context));
                    continue;
                }
                if (this.defaultBackgroundResource != 0) {
                    this.setBackgroundResource(this.defaultBackgroundResource);
                } else {
                    this.setBackgroundColor(this.defaultBackgroundColor);
                }
                this.backgroundColorView.setBackgroundColor(0);
                continue;
            }
            if (i != this.currentItem) continue;
            TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_item_title);
            ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_item_icon);
            TextView textView3 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
            imageView.setSelected(false);
            AHHelper.updateTopMargin((View)imageView, (int)n2, (int)n3);
            AHHelper.updateLeftMargin((View)textView3, (int)this.notificationActiveMarginLeft, (int)this.notificationInactiveMarginLeft);
            AHHelper.updateTextColor((TextView)textView, (int)this.itemActiveColor, (int)this.itemInactiveColor);
            AHHelper.updateTextSize((TextView)textView, (float)f, (float)f2);
            AHHelper.updateDrawableColor((Context)this.context, (Drawable)((AHBottomNavigationItem)this.items.get(this.currentItem)).getDrawable(this.context), (ImageView)imageView, (int)this.itemActiveColor, (int)this.itemInactiveColor, (boolean)this.forceTint);
        }
        this.currentItem = n;
        if (this.currentItem > 0 && this.currentItem < this.items.size()) {
            this.currentColor = ((AHBottomNavigationItem)this.items.get(this.currentItem)).getColor(this.context);
            return;
        }
        if (this.currentItem != -1) return;
        if (this.defaultBackgroundResource != 0) {
            this.setBackgroundResource(this.defaultBackgroundResource);
        } else {
            this.setBackgroundColor(this.defaultBackgroundColor);
        }
        this.backgroundColorView.setBackgroundColor(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateNotifications(boolean bl, int n) {
        int n2 = 0;
        while (n2 < this.views.size()) {
            if (n == -1 || n == n2) {
                AHNotification aHNotification = (AHNotification)this.notifications.get(n2);
                int n3 = AHNotificationHelper.getTextColor((AHNotification)aHNotification, (int)this.notificationTextColor);
                int n4 = AHNotificationHelper.getBackgroundColor((AHNotification)aHNotification, (int)this.notificationBackgroundColor);
                TextView textView = (TextView)((View)this.views.get(n2)).findViewById(R.id.bottom_navigation_notification);
                boolean bl2 = !textView.getText().toString().equals((Object)String.valueOf((Object)aHNotification.getText()));
                if (bl) {
                    textView.setTextColor(n3);
                    if (this.notificationTypeface != null) {
                        textView.setTypeface(this.notificationTypeface);
                    } else {
                        textView.setTypeface(null, 1);
                    }
                    if (this.notificationBackgroundDrawable != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            textView.setBackground(this.notificationBackgroundDrawable.getConstantState().newDrawable());
                        } else {
                            textView.setBackgroundDrawable(this.notificationBackgroundDrawable);
                        }
                    } else if (n4 != 0) {
                        Drawable drawable2 = ContextCompat.getDrawable((Context)this.context, (int)R.drawable.notification_background);
                        if (Build.VERSION.SDK_INT >= 16) {
                            textView.setBackground(AHHelper.getTintDrawable((Drawable)drawable2, (int)n4, (boolean)this.forceTint));
                        } else {
                            textView.setBackgroundDrawable(AHHelper.getTintDrawable((Drawable)drawable2, (int)n4, (boolean)this.forceTint));
                        }
                    }
                }
                if (aHNotification.isEmpty() && textView.getText().length() > 0) {
                    textView.setText((CharSequence)"");
                    if (bl2) {
                        textView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator((TimeInterpolator)new AccelerateInterpolator()).setDuration(150L).start();
                    }
                } else if (!aHNotification.isEmpty()) {
                    textView.setText((CharSequence)String.valueOf((Object)aHNotification.getText()));
                    if (bl2) {
                        textView.setScaleX(0.0f);
                        textView.setScaleY(0.0f);
                        textView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator((TimeInterpolator)new OvershootInterpolator()).setDuration(150L).start();
                    }
                }
            }
            ++n2;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void updateSmallItems(final int n, boolean bl) {
        if (this.currentItem == n) {
            if (this.tabSelectedListener == null) return;
            if (!bl) return;
            this.tabSelectedListener.onTabSelected(n, true);
            return;
        }
        if (this.tabSelectedListener != null && bl) {
            if (!this.tabSelectedListener.onTabSelected(n, false)) return;
        }
        int n2 = (int)this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top_active);
        int n3 = (int)this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top);
        for (int i = 0; i < this.views.size(); ++i) {
            View view = (View)this.views.get(i);
            if (this.selectedBackgroundVisible) {
                boolean bl2 = i == n;
                view.setSelected(bl2);
            }
            if (i == n) {
                FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.bottom_navigation_small_container);
                TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_small_item_title);
                ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_small_item_icon);
                TextView textView2 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
                imageView.setSelected(true);
                if (this.titleState != TitleState.ALWAYS_HIDE) {
                    AHHelper.updateTopMargin((View)imageView, (int)n3, (int)n2);
                    AHHelper.updateLeftMargin((View)textView2, (int)this.notificationInactiveMarginLeft, (int)this.notificationActiveMarginLeft);
                    AHHelper.updateTopMargin((View)textView2, (int)this.notificationInactiveMarginTop, (int)this.notificationActiveMarginTop);
                    AHHelper.updateTextColor((TextView)textView, (int)this.itemInactiveColor, (int)this.itemActiveColor);
                    AHHelper.updateWidth((View)frameLayout, (float)this.notSelectedItemWidth, (float)this.selectedItemWidth);
                }
                AHHelper.updateAlpha((View)textView, (float)0.0f, (float)1.0f);
                AHHelper.updateDrawableColor((Context)this.context, (Drawable)((AHBottomNavigationItem)this.items.get(n)).getDrawable(this.context), (ImageView)imageView, (int)this.itemInactiveColor, (int)this.itemActiveColor, (boolean)this.forceTint);
                if (Build.VERSION.SDK_INT >= 21 && this.colored) {
                    int n4 = Math.max((int)this.getWidth(), (int)this.getHeight());
                    int n5 = (int)((View)this.views.get(n)).getX() + ((View)this.views.get(n)).getWidth() / 2;
                    int n6 = ((View)this.views.get(n)).getHeight() / 2;
                    if (this.circleRevealAnim != null && this.circleRevealAnim.isRunning()) {
                        this.circleRevealAnim.cancel();
                        this.setBackgroundColor(((AHBottomNavigationItem)this.items.get(n)).getColor(this.context));
                        this.backgroundColorView.setBackgroundColor(0);
                    }
                    this.circleRevealAnim = ViewAnimationUtils.createCircularReveal((View)this.backgroundColorView, (int)n5, (int)n6, (float)0.0f, (float)n4);
                    this.circleRevealAnim.setStartDelay(5L);
                    this.circleRevealAnim.addListener(new Animator.AnimatorListener(){

                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            AHBottomNavigation.this.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(n)).getColor(AHBottomNavigation.this.context));
                            AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(n)).getColor(AHBottomNavigation.this.context));
                        }
                    });
                    this.circleRevealAnim.start();
                    continue;
                }
                if (this.colored) {
                    AHHelper.updateViewBackgroundColor((View)this, (int)this.currentColor, (int)((AHBottomNavigationItem)this.items.get(n)).getColor(this.context));
                    continue;
                }
                if (this.defaultBackgroundResource != 0) {
                    this.setBackgroundResource(this.defaultBackgroundResource);
                } else {
                    this.setBackgroundColor(this.defaultBackgroundColor);
                }
                this.backgroundColorView.setBackgroundColor(0);
                continue;
            }
            if (i != this.currentItem) continue;
            View view2 = view.findViewById(R.id.bottom_navigation_small_container);
            TextView textView = (TextView)view.findViewById(R.id.bottom_navigation_small_item_title);
            ImageView imageView = (ImageView)view.findViewById(R.id.bottom_navigation_small_item_icon);
            TextView textView3 = (TextView)view.findViewById(R.id.bottom_navigation_notification);
            imageView.setSelected(false);
            if (this.titleState != TitleState.ALWAYS_HIDE) {
                AHHelper.updateTopMargin((View)imageView, (int)n2, (int)n3);
                AHHelper.updateLeftMargin((View)textView3, (int)this.notificationActiveMarginLeft, (int)this.notificationInactiveMarginLeft);
                AHHelper.updateTopMargin((View)textView3, (int)this.notificationActiveMarginTop, (int)this.notificationInactiveMarginTop);
                AHHelper.updateTextColor((TextView)textView, (int)this.itemActiveColor, (int)this.itemInactiveColor);
                AHHelper.updateWidth((View)view2, (float)this.selectedItemWidth, (float)this.notSelectedItemWidth);
            }
            AHHelper.updateAlpha((View)textView, (float)1.0f, (float)0.0f);
            AHHelper.updateDrawableColor((Context)this.context, (Drawable)((AHBottomNavigationItem)this.items.get(this.currentItem)).getDrawable(this.context), (ImageView)imageView, (int)this.itemActiveColor, (int)this.itemInactiveColor, (boolean)this.forceTint);
        }
        this.currentItem = n;
        if (this.currentItem > 0 && this.currentItem < this.items.size()) {
            this.currentColor = ((AHBottomNavigationItem)this.items.get(this.currentItem)).getColor(this.context);
            return;
        }
        if (this.currentItem != -1) return;
        if (this.defaultBackgroundResource != 0) {
            this.setBackgroundResource(this.defaultBackgroundResource);
        } else {
            this.setBackgroundColor(this.defaultBackgroundColor);
        }
        this.backgroundColorView.setBackgroundColor(0);
    }

    public void addItem(AHBottomNavigationItem aHBottomNavigationItem) {
        if (this.items.size() > 5) {
            Log.w((String)TAG, (String)"The items list should not have more than 5 items");
        }
        this.items.add((Object)aHBottomNavigationItem);
        AHBottomNavigation.super.createItems();
    }

    public void addItems(List<AHBottomNavigationItem> list) {
        if (list.size() > 5 || this.items.size() + list.size() > 5) {
            Log.w((String)TAG, (String)"The items list should not have more than 5 items");
        }
        this.items.addAll(list);
        AHBottomNavigation.super.createItems();
    }

    public int getAccentColor() {
        return this.itemActiveColor;
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public int getInactiveColor() {
        return this.itemInactiveColor;
    }

    public AHBottomNavigationItem getItem(int n) {
        if (n < 0 || n > -1 + this.items.size()) {
            Log.w((String)TAG, (String)("The position is out of bounds of the items (" + this.items.size() + " elements)"));
        }
        return (AHBottomNavigationItem)this.items.get(n);
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public TitleState getTitleState() {
        return this.titleState;
    }

    public View getViewAtPosition(int n) {
        if (this.linearLayoutContainer != null && n >= 0 && n < this.linearLayoutContainer.getChildCount()) {
            return this.linearLayoutContainer.getChildAt(n);
        }
        return null;
    }

    @SuppressLint(value={"NewApi"})
    @TargetApi(value=21)
    public boolean hasImmersive() {
        Display display = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        int n = displayMetrics.heightPixels;
        int n2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        display.getMetrics(displayMetrics2);
        int n3 = displayMetrics2.heightPixels;
        return n2 > displayMetrics2.widthPixels || n > n3;
    }

    public void hideBottomNavigation() {
        this.hideBottomNavigation(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void hideBottomNavigation(boolean bl) {
        this.isHidden = true;
        if (this.bottomNavigationBehavior != null) {
            this.bottomNavigationBehavior.hideView((View)this, this.bottomNavigationHeight, bl);
            return;
        }
        if (this.getParent() instanceof CoordinatorLayout) {
            this.needHideBottomNavigation = true;
            this.hideBottomNavigationWithAnimation = bl;
            return;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this).translationY((float)this.bottomNavigationHeight).setInterpolator((Interpolator)new LinearOutSlowInInterpolator());
        long l = bl ? 300L : 0L;
        viewPropertyAnimatorCompat.setDuration(l).start();
    }

    public boolean isBehaviorTranslationEnabled() {
        return this.behaviorTranslationEnabled;
    }

    public boolean isColored() {
        return this.colored;
    }

    public boolean isForceTint() {
        return this.forceTint;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public boolean isTranslucentNavigationEnabled() {
        return this.translucentNavigationEnabled;
    }

    public void manageFloatingActionButtonBehavior(FloatingActionButton floatingActionButton) {
        if (floatingActionButton.getParent() instanceof CoordinatorLayout) {
            AHBottomNavigationFABBehavior aHBottomNavigationFABBehavior = new AHBottomNavigationFABBehavior(this.navigationBarHeight);
            ((CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams()).setBehavior((CoordinatorLayout.Behavior)aHBottomNavigationFABBehavior);
        }
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (!this.isBehaviorTranslationSet) {
            this.setBehaviorTranslationEnabled(this.behaviorTranslationEnabled);
            this.isBehaviorTranslationSet = true;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.currentItem = bundle.getInt("current_item");
            this.notifications = bundle.getParcelableArrayList("notifications");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("current_item", this.currentItem);
        bundle.putParcelableArrayList("notifications", new ArrayList(this.notifications));
        return bundle;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        AHBottomNavigation.super.createItems();
    }

    public void refresh() {
        this.createItems();
    }

    public void removeAllItems() {
        this.items.clear();
        this.createItems();
    }

    public void removeItemAtIndex(int n) {
        if (n < this.items.size()) {
            this.items.remove(n);
            AHBottomNavigation.super.createItems();
        }
    }

    public void removeOnNavigationPositionListener() {
        this.navigationPositionListener = null;
        if (this.bottomNavigationBehavior != null) {
            this.bottomNavigationBehavior.removeOnNavigationPositionListener();
        }
    }

    public void removeOnTabSelectedListener() {
        this.tabSelectedListener = null;
    }

    public void restoreBottomNavigation() {
        this.restoreBottomNavigation(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void restoreBottomNavigation(boolean bl) {
        this.isHidden = false;
        if (this.bottomNavigationBehavior != null) {
            this.bottomNavigationBehavior.resetOffset((View)this, bl);
            return;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this).translationY(0.0f).setInterpolator((Interpolator)new LinearOutSlowInInterpolator());
        long l = bl ? 300L : 0L;
        viewPropertyAnimatorCompat.setDuration(l).start();
    }

    public void setAccentColor(int n) {
        this.titleColorActive = n;
        this.itemActiveColor = n;
        AHBottomNavigation.super.createItems();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setBehaviorTranslationEnabled(boolean bl) {
        this.behaviorTranslationEnabled = bl;
        if (this.getParent() instanceof CoordinatorLayout) {
            ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
            if (this.bottomNavigationBehavior == null) {
                this.bottomNavigationBehavior = new AHBottomNavigationBehavior(bl, this.navigationBarHeight);
            } else {
                this.bottomNavigationBehavior.setBehaviorTranslationEnabled(bl, this.navigationBarHeight);
            }
            if (this.navigationPositionListener != null) {
                this.bottomNavigationBehavior.setOnNavigationPositionListener(this.navigationPositionListener);
            }
            ((CoordinatorLayout.LayoutParams)layoutParams).setBehavior(this.bottomNavigationBehavior);
            if (this.needHideBottomNavigation) {
                this.needHideBottomNavigation = false;
                this.bottomNavigationBehavior.hideView((View)this, this.bottomNavigationHeight, this.hideBottomNavigationWithAnimation);
                this.isHidden = true;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setColored(boolean bl) {
        this.colored = bl;
        int n = bl ? this.coloredTitleColorActive : this.titleColorActive;
        this.itemActiveColor = n;
        int n2 = bl ? this.coloredTitleColorInactive : this.titleColorInactive;
        this.itemInactiveColor = n2;
        AHBottomNavigation.super.createItems();
    }

    public void setColoredModeColors(@ColorInt int n, @ColorInt int n2) {
        this.coloredTitleColorActive = n;
        this.coloredTitleColorInactive = n2;
        AHBottomNavigation.super.createItems();
    }

    public void setCurrentItem(int n) {
        this.setCurrentItem(n, true);
    }

    public void setCurrentItem(int n, boolean bl) {
        if (n >= this.items.size()) {
            Log.w((String)TAG, (String)("The position is out of bounds of the items (" + this.items.size() + " elements)"));
            return;
        }
        if (this.titleState != TitleState.ALWAYS_HIDE && (this.items.size() == 3 || this.titleState == TitleState.ALWAYS_SHOW)) {
            AHBottomNavigation.super.updateItems(n, bl);
            return;
        }
        AHBottomNavigation.super.updateSmallItems(n, bl);
    }

    public void setDefaultBackgroundColor(@ColorInt int n) {
        this.defaultBackgroundColor = n;
        AHBottomNavigation.super.createItems();
    }

    public void setDefaultBackgroundResource(@DrawableRes int n) {
        this.defaultBackgroundResource = n;
        AHBottomNavigation.super.createItems();
    }

    public void setForceTint(boolean bl) {
        this.forceTint = bl;
        AHBottomNavigation.super.createItems();
    }

    public void setInactiveColor(int n) {
        this.titleColorInactive = n;
        this.itemInactiveColor = n;
        AHBottomNavigation.super.createItems();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Deprecated
    public void setNotification(int n, int n2) {
        if (n2 < 0 || n2 > -1 + this.items.size()) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{n2, this.items.size()};
            throw new IndexOutOfBoundsException(String.format((Locale)locale, (String)EXCEPTION_INDEX_OUT_OF_BOUNDS, (Object[])arrobject));
        }
        String string = n == 0 ? "" : String.valueOf((int)n);
        this.notifications.set(n2, (Object)AHNotification.justText((String)string));
        AHBottomNavigation.super.updateNotifications(false, n2);
    }

    public void setNotification(AHNotification aHNotification, int n) {
        if (n < 0 || n > -1 + this.items.size()) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{n, this.items.size()};
            throw new IndexOutOfBoundsException(String.format((Locale)locale, (String)EXCEPTION_INDEX_OUT_OF_BOUNDS, (Object[])arrobject));
        }
        if (aHNotification == null) {
            aHNotification = new AHNotification();
        }
        this.notifications.set(n, (Object)aHNotification);
        AHBottomNavigation.super.updateNotifications(true, n);
    }

    public void setNotification(String string, int n) {
        if (n < 0 || n > -1 + this.items.size()) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{n, this.items.size()};
            throw new IndexOutOfBoundsException(String.format((Locale)locale, (String)EXCEPTION_INDEX_OUT_OF_BOUNDS, (Object[])arrobject));
        }
        this.notifications.set(n, (Object)AHNotification.justText((String)string));
        AHBottomNavigation.super.updateNotifications(false, n);
    }

    public void setNotificationBackground(Drawable drawable2) {
        this.notificationBackgroundDrawable = drawable2;
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColor(@ColorInt int n) {
        this.notificationBackgroundColor = n;
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColorResource(@ColorRes int n) {
        this.notificationBackgroundColor = ContextCompat.getColor((Context)this.context, (int)n);
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setNotificationMarginLeft(int n, int n2) {
        this.notificationActiveMarginLeft = n;
        this.notificationInactiveMarginLeft = n2;
        AHBottomNavigation.super.createItems();
    }

    public void setNotificationTextColor(@ColorInt int n) {
        this.notificationTextColor = n;
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setNotificationTextColorResource(@ColorRes int n) {
        this.notificationTextColor = ContextCompat.getColor((Context)this.context, (int)n);
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setNotificationTypeface(Typeface typeface) {
        this.notificationTypeface = typeface;
        AHBottomNavigation.super.updateNotifications(true, -1);
    }

    public void setOnNavigationPositionListener(OnNavigationPositionListener onNavigationPositionListener) {
        this.navigationPositionListener = onNavigationPositionListener;
        if (this.bottomNavigationBehavior != null) {
            this.bottomNavigationBehavior.setOnNavigationPositionListener(onNavigationPositionListener);
        }
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.tabSelectedListener = onTabSelectedListener;
    }

    public void setSelectedBackgroundVisible(boolean bl) {
        this.selectedBackgroundVisible = bl;
        AHBottomNavigation.super.createItems();
    }

    public void setTitleState(TitleState titleState) {
        this.titleState = titleState;
        AHBottomNavigation.super.createItems();
    }

    public void setTitleTextSize(float f, float f2) {
        this.titleActiveTextSize = f;
        this.titleInactiveTextSize = f2;
        AHBottomNavigation.super.createItems();
    }

    public void setTitleTypeface(Typeface typeface) {
        this.titleTypeface = typeface;
        AHBottomNavigation.super.createItems();
    }

    public void setTranslucentNavigationEnabled(boolean bl) {
        this.translucentNavigationEnabled = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setUseElevation(boolean bl) {
        float f = bl ? this.resources.getDimension(R.dimen.bottom_navigation_elevation) : 0.0f;
        ViewCompat.setElevation((View)this, (float)f);
        this.setClipToPadding(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setUseElevation(boolean bl, float f) {
        if (!bl) {
            f = 0.0f;
        }
        ViewCompat.setElevation((View)this, (float)f);
        this.setClipToPadding(false);
    }

    public static interface OnNavigationPositionListener {
        public void onPositionChange(int var1);
    }

    public static interface OnTabSelectedListener {
        public boolean onTabSelected(int var1, boolean var2);
    }

    public static final class TitleState
    extends Enum<TitleState> {
        private static final /* synthetic */ TitleState[] $VALUES;
        public static final /* enum */ TitleState ALWAYS_HIDE;
        public static final /* enum */ TitleState ALWAYS_SHOW;
        public static final /* enum */ TitleState SHOW_WHEN_ACTIVE;

        static {
            SHOW_WHEN_ACTIVE = new TitleState();
            ALWAYS_SHOW = new TitleState();
            ALWAYS_HIDE = new TitleState();
            TitleState[] arrtitleState = new TitleState[]{SHOW_WHEN_ACTIVE, ALWAYS_SHOW, ALWAYS_HIDE};
            $VALUES = arrtitleState;
        }

        public static TitleState valueOf(String string) {
            return (TitleState)Enum.valueOf(TitleState.class, (String)string);
        }

        public static TitleState[] values() {
            return (TitleState[])$VALUES.clone();
        }
    }

}

