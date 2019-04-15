/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.GridView
 */
package com.bikinaplikasi.onlineshop.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ExpandableHeightGridView
extends GridView {
    boolean expanded = false;

    public ExpandableHeightGridView(Context context) {
        super(context);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onMeasure(int n, int n2) {
        if (this.isExpanded()) {
            super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)16777215, (int)Integer.MIN_VALUE));
            this.getLayoutParams().height = this.getMeasuredHeight();
            return;
        }
        super.onMeasure(n, n2);
    }

    public void setExpanded(boolean bl) {
        this.expanded = bl;
    }
}

