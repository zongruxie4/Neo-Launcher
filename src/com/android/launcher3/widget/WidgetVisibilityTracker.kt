/*
 * Copyright (C) 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3.widget

import android.view.View
import com.android.launcher3.Launcher
import com.android.launcher3.LauncherState
import com.android.launcher3.PagedView
import com.android.launcher3.Workspace
import com.android.launcher3.statemanager.StateManager
import com.android.launcher3.views.ActivityContext

/**
 * Updates visibility hints on widget views in response to swiping on the workspace, opening all
 * apps, or a floating view.
 */
class WidgetVisibilityTracker(
    private val activityContext: ActivityContext,
    private val widgetHolder: LauncherWidgetHolder,
    private val workspace: Workspace<*>,
    private val stateManager: StateManager<LauncherState, Launcher>,
) : StateManager.StateListener<LauncherState>, PagedView.PageSwitchListener {
    init {
        workspace.addPageSwitchListener(this)
        stateManager.addStateListener(this)
    }

    override fun onPageSwitch() {
        updateVisibility()
    }

    override fun onStateTransitionComplete(finalState: LauncherState?) {
        updateVisibility()
    }

    fun onDragLayerHierarchyChanged() {
        updateVisibility()
    }

    fun onWidgetAdded() {
        updateVisibility()
    }

    private fun updateVisibility() {
        // AOSP tells each widget whether it is on screen through
        // AppWidgetHostView.startVisibilityTracking() / stopVisibilityTracking(). That is a hint
        // to the provider, and it leaves the view in place. Both methods are public since
        // SDK 36.1, but they are missing from prebuilt/libs/framework-16.jar, which comes ahead
        // of the SDK android.jar on the compile classpath, so they cannot be called from here
        // yet.
        //
        // They had been replaced with View.GONE / View.VISIBLE. That is not equivalent: a GONE
        // view is neither laid out nor drawn. And since this method only runs once a page switch
        // has been committed, at the end of the scroll, two defects followed:
        //   - widgets on the incoming page were not drawn for the whole page transition, then
        //     popped in at once;
        //   - any open floating view hid every widget, and the resize frame is one, so the
        //     widget being resized vanished and stopped being laid out -- its frame stayed at
        //     the size it had when the resize started, until the frame was dismissed.
        //
        // So leave view visibility alone. The hint can come back exactly as AOSP writes it once
        // the prebuilt framework jar carries the API.
    }

    fun destroy() {
        workspace.removePageSwitchListener(this)
        stateManager.removeStateListener(this)
    }
}

private val View.parents: Sequence<View>
    get() = generateSequence(parent as? View) { it.parent as? View }
